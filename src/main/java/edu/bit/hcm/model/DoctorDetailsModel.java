package edu.bit.hcm.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.hcm.entity.DoctorEntity;
import edu.bit.hcm.repository.DoctorDetailsRepository;

@Service
public class DoctorDetailsModel {

	@Autowired
	private DoctorDetailsRepository doctorDetailsRepository;

	public void saveDoctorDetails(DoctorEntity doctorEntity) {
		doctorDetailsRepository.save(doctorEntity);
	}

	public List<DoctorEntity> findAllDoctors() {
		return doctorDetailsRepository.findAll();
		
	}
	
	public List<DoctorEntity> findBySpecializationCode(int spc){
		return doctorDetailsRepository.findBySpecializationCode(new Integer(spc));
	}

	public void deleteDoctor(DoctorEntity entity) {
		doctorDetailsRepository.delete(entity);		
	}
	
	
}
