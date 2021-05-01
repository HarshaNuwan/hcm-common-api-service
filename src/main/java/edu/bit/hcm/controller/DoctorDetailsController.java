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

import edu.bit.hcm.DoctorDTO;
import edu.bit.hcm.SpecializationDTO;
import edu.bit.hcm.entity.DoctorEntity;
import edu.bit.hcm.model.DoctorDetailsModel;
import edu.bit.hcm.wrapper.DoctorDTOListWrapper;

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

		return ResponseEntity.status(HttpStatus.OK).body("{\"MESSAGE\":\"Doctor details successfully saved\"}");
	}
	
	@PostMapping("/doctor/delete")
	public ResponseEntity<String> deleteDoctor(@RequestBody DoctorDTO doctorDTO){
		
		detailsModel.deleteDoctor(convertToEntity(doctorDTO));
		return ResponseEntity.status(HttpStatus.OK).body("{\"MESSAGE\":\"Doctor details successfully deleted\"}");
		
	}

	@GetMapping("/doctor/getalldoctors")
	public ResponseEntity<DoctorDTOListWrapper> getAllDoctors() {
		DoctorDTOListWrapper dtoListWrapper = new DoctorDTOListWrapper();
		List<DoctorDTO> list = new ArrayList<DoctorDTO>();
		for (DoctorEntity entity : detailsModel.findAllDoctors()) {
			DoctorDTO doctorDTO = convertToDTO(entity);
			
			doctorDTO.setSpecializationDTO(new SpecializationDTO(0, "Test"));
			list.add(doctorDTO);
		}
		dtoListWrapper.setDoctors(list);
		return ResponseEntity.status(HttpStatus.OK).body(dtoListWrapper);
	}
	
	@GetMapping("/doctor/findbyspecializationcode")
	public ResponseEntity<DoctorDTOListWrapper> findBySpecializationCode(@RequestParam Integer spc){
		DoctorDTOListWrapper dtoListWrapper = new DoctorDTOListWrapper();
		List<DoctorDTO> list = new ArrayList<DoctorDTO>();
		for (DoctorEntity entity : detailsModel.findBySpecializationCode(spc)) {
			DoctorDTO doctorDTO = convertToDTO(entity);
			
			doctorDTO.setSpecializationDTO(new SpecializationDTO(0, "Test"));
			list.add(doctorDTO);
		}
		dtoListWrapper.setDoctors(list);
		return ResponseEntity.status(HttpStatus.OK).body(dtoListWrapper);
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
