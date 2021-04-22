package edu.bit.hcm.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.hcm.entity.PatientEntity;
import edu.bit.hcm.repository.PatientRepository;

@Service
public class PatientModel {
	
	@Autowired
	private PatientRepository patientRepository;
	
	public void savePatient (PatientEntity patientEntity) throws Exception {		
		patientRepository.save(patientEntity);
	}

}
