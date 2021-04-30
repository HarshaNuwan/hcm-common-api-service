package edu.bit.hcm.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bit.hcm.DoctorDTO;
import edu.bit.hcm.SpecializationDTO;
import edu.bit.hcm.entity.SpecializationEntity;
import edu.bit.hcm.model.SpecializationModel;
import edu.bit.hcm.wrapper.SpecializationDTOListWrapper;

@RestController
public class SpecializationController {
	
	@Autowired
	private SpecializationModel specializationModel;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/doctor/getspecialization")
	public ResponseEntity<SpecializationDTOListWrapper> getAllDoctors() {
		SpecializationDTOListWrapper specializationDTOListWrapper = new SpecializationDTOListWrapper();
		List<SpecializationDTO> list = new ArrayList<SpecializationDTO>();
		for (SpecializationEntity entity : specializationModel.findAllSpecialization()) {
			SpecializationDTO dto = convertToDTO(entity);
			list.add(dto);
		}
		specializationDTOListWrapper.setSpecializationLists(list);
		return ResponseEntity.status(HttpStatus.OK).body(specializationDTOListWrapper);
	}

	private SpecializationEntity convertToEntity(DoctorDTO dto) {
		SpecializationEntity entity = modelMapper.map(dto, SpecializationEntity.class);
		return entity;
	}

	private SpecializationDTO convertToDTO(SpecializationEntity entity) {
		SpecializationDTO dto = modelMapper.map(entity, SpecializationDTO.class);

		return dto;
	}
	

}
