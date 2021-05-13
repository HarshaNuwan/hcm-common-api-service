package edu.bit.hcm.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.bit.hcm.ChannelingDTO;
import edu.bit.hcm.DoctorDTO;
import edu.bit.hcm.PatientDTO;
import edu.bit.hcm.entity.ChannelingEntitity;
import edu.bit.hcm.entity.PatientEntity;
import edu.bit.hcm.model.PatientModel;
import edu.bit.hcm.wrapper.ChannelingDTOWrapper;
import edu.bit.hcm.wrapper.PatientDTOListWrapper;

@RestController
public class PatientController {

	@Autowired
	private PatientModel patientModel;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/patient/save")
	public ResponseEntity<Object> savePatient(@RequestBody PatientDTO patientDTO) {
		try {
			PatientEntity patientEntity = convertToEntity(patientDTO);

			patientModel.savePatient(patientEntity);

			return ResponseEntity.status(HttpStatus.OK).body("{\"Messege\":\"Patient successfully saved\"}");

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"Error\":\"Error occurred\"}");
		}
	}

	@GetMapping("/patient/getallpatients")
	public ResponseEntity<PatientDTOListWrapper> getAllChannelings() {
		List<PatientEntity> patientEntities = patientModel.getAllPatients();
		List<PatientDTO> patientDTOs = new ArrayList<PatientDTO>();
		for (PatientEntity entitity : patientEntities) {
			PatientDTO patientDTO = convertToDTO(entitity);
			patientDTOs.add(patientDTO);
		}
		PatientDTOListWrapper patientDTOListWrapper = new PatientDTOListWrapper();
		patientDTOListWrapper.setList(patientDTOs);
		return ResponseEntity.status(HttpStatus.OK).body(patientDTOListWrapper);
	}

	@PostMapping("/patient/delete")
	public ResponseEntity<String> deletePatient(@RequestBody PatientDTO patientDTO) {
		patientModel.deletePatient(convertToEntity(patientDTO));
		return ResponseEntity.status(HttpStatus.OK).body("{\"MESSAGE\":\"Patient details successfully deleted\"}");
	}

	private PatientEntity convertToEntity(PatientDTO dto) {
		PatientEntity entity = modelMapper.map(dto, PatientEntity.class);
		return entity;
	}

	private PatientDTO convertToDTO(PatientEntity entity) {
		PatientDTO dto = modelMapper.map(entity, PatientDTO.class);

		return dto;
	}

}
