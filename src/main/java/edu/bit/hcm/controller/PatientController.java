package edu.bit.hcm.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.bit.hcm.PatientDTO;
import edu.bit.hcm.entity.PatientEntity;
import edu.bit.hcm.model.PatientModel;

@RestController
public class PatientController {

	@Autowired
	private PatientModel patientModel;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/savepatient")
	public ResponseEntity<Object> savePatient(@RequestBody PatientDTO patientDTO) {
		try {
			PatientEntity patientEntity = convertToEntity(patientDTO);

			patientModel.savePatient(patientEntity);

			return ResponseEntity.status(HttpStatus.OK).body("{\"Messege\":\"Patient successfully saved\"}");

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"Error\":\"Error occurred\"}");
		}
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
