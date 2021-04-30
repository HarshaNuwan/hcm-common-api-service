package edu.bit.hcm.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.bit.hcm.DoctorDTO;
import edu.bit.hcm.entity.DoctorEntity;
import edu.bit.hcm.model.DoctorDetailsModel;

@RestController
public class DoctorDetailsController {

	@Autowired
	private DoctorDetailsModel detailsModel;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/doctor/savedetails")
	public ResponseEntity<Object> saveDoctorDetails(@RequestBody DoctorDTO doctorDTO) {
		DoctorEntity doctorEntity = convertToEntity(doctorDTO);
		detailsModel.saveDoctorDetails(doctorEntity);
		
		return ResponseEntity.status(HttpStatus.OK)
				.body("{\"MESSAGE\":\"Doctor details successfully saved\"}");
	}
	
	
	private DoctorEntity convertToEntity(DoctorDTO dto) {
		DoctorEntity entity = modelMapper.map(dto, DoctorEntity.class);		
		return entity;
	}
	
	private DoctorDTO convertToDTO(DoctorEntity entity) {
		DoctorDTO dto = modelMapper.map(entity, DoctorDTO.class);
		
		return dto;
	}
}
