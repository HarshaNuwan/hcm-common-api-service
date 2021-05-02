package edu.bit.hcm.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.bit.hcm.DiagnosisDTO;
import edu.bit.hcm.entity.DiagnosisEntity;
import edu.bit.hcm.model.DiagnosisModel;
import edu.bit.hcm.wrapper.DiagnosisDTOListWrapper;

@RestController
public class DiagnosisController {

	@Autowired
	private DiagnosisModel diagnosisModel;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/diagnosis/savediagnosis")
	public ResponseEntity<Object> saveDiagnosis(@RequestBody DiagnosisDTO diagnosisDTO) {
		try {
			DiagnosisEntity diagnosisEntity = convertToEntity(diagnosisDTO);

			diagnosisModel.saveDiagnosis(diagnosisEntity);

			return ResponseEntity.status(HttpStatus.OK).body("{\"Messege\":\"Diagnosis successfully saved\"}");

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"Error\":\"Error occurred\"}");
		}
	}
	
	@GetMapping("/diagnosis/updatediagnosis")
	public ResponseEntity<Object> updatePrescriptionStatus(@RequestParam Integer dId, @RequestParam Boolean status){
		try {

			diagnosisModel.updatePrescriptionStatus(dId, status);

			return ResponseEntity.status(HttpStatus.OK).body("{\"Messege\":\"Diagnosis successfully updated\"}");

		} catch (Exception e) {

			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"Error\":\"Error occurred\"}");
		}
	}

	@GetMapping("/diagnosis/getallbypidanddoctorid")
	public ResponseEntity<DiagnosisDTOListWrapper> findByPidAndDoctorId(@RequestParam Integer pid,
			@RequestParam Integer doctorId) {
		List<DiagnosisEntity> diagnosisEntities = diagnosisModel.findByPidAndDoctorId(pid, doctorId);
		List<DiagnosisDTO> diagnosisDTOs = new ArrayList<DiagnosisDTO>();
		for (DiagnosisEntity diagnosisEntity : diagnosisEntities) {
			DiagnosisDTO diagnosisDTO = convertToDTO(diagnosisEntity);
			diagnosisDTOs.add(diagnosisDTO);
		}
		DiagnosisDTOListWrapper diagnosisDTOListWrapper = new DiagnosisDTOListWrapper();
		diagnosisDTOListWrapper.setList(diagnosisDTOs);
		return ResponseEntity.status(HttpStatus.OK).body(diagnosisDTOListWrapper);
	}

	private DiagnosisEntity convertToEntity(DiagnosisDTO dto) {
		DiagnosisEntity entity = modelMapper.map(dto, DiagnosisEntity.class);
		return entity;
	}

	private DiagnosisDTO convertToDTO(DiagnosisEntity entity) {
		DiagnosisDTO dto = modelMapper.map(entity, DiagnosisDTO.class);

		return dto;
	}
}
