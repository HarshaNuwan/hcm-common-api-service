package edu.bit.hcm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.bit.hcm.dto.PatientDTO;
import edu.bit.hcm.entity.PatientEntity;
import edu.bit.hcm.model.PatientModel;

@RestController
public class PatientController {
	
	@Autowired
	private PatientModel patientModel;
	
	
	@PostMapping("/savepatient")
	public ResponseEntity<Object> savePatient(@RequestBody PatientDTO patientDTO) {
		try {
			PatientEntity patientEntity = new PatientEntity();
			patientEntity.setPid(patientDTO.getPid());
			patientEntity.setNic(patientDTO.getNic());
			patientEntity.setFirstName(patientDTO.getFirst_name());
			patientEntity.setLastName(patientDTO.getLast_name());
			
			patientModel.savePatient(patientEntity);
			
			return ResponseEntity.status(HttpStatus.OK).body("{\"Messege\":\"Patient successfully saved\"}");
			
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"Error\":\"Error occurred\"}");
		}
	}

}
