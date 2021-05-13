package edu.bit.hcm.model;

import java.util.List;

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
	
	public List<PatientEntity> getAllPatients(){
		return patientRepository.findAll();
	}
	
	public void deletePatient (PatientEntity entity) {
		patientRepository.delete(entity);
	}

}
