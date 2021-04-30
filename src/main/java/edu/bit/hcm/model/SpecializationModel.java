package edu.bit.hcm.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.hcm.entity.SpecializationEntity;
import edu.bit.hcm.repository.SpecializationRepository;

@Service
public class SpecializationModel {

	@Autowired
	private SpecializationRepository specializationRepository;

	public List<SpecializationEntity> findAllSpecialization() {
		return specializationRepository.findAll();
	}

}
