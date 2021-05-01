package edu.bit.hcm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import edu.bit.hcm.ChannelingDTO;
import edu.bit.hcm.entity.ChannelingEntitity;
import edu.bit.hcm.model.ChannelingModel;
import edu.bit.hcm.wrapper.ChannelingDTOWrapper;

@RestController
public class ChannelingController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ChannelingModel channelingModel;

	@PostMapping("/channeling/savechanneldetails")
	public ResponseEntity<Object> saveChannelDetails(@RequestBody ChannelingDTO channelingDTO) {
		channelingModel.saveChannelingDetails(convertToEntity(channelingDTO));
		return ResponseEntity.status(HttpStatus.OK).body("{\"MESSAGE\":\"Channeling details successfully saved\"}");
	}

	@GetMapping("/channeling/getallchanneling")
	public ResponseEntity<ChannelingDTOWrapper> getAllChannelings() {
		List<ChannelingEntitity> channelingEntities = channelingModel.getAllChannelings();
		List<ChannelingDTO> channelingDTOs = new ArrayList<ChannelingDTO>();
		for (ChannelingEntitity entitity : channelingEntities) {
			channelingDTOs.add(convertToDTO(entitity));
		}
		ChannelingDTOWrapper channelingDTOWrapper = new ChannelingDTOWrapper();
		channelingDTOWrapper.setList(channelingDTOs);
		return ResponseEntity.status(HttpStatus.OK).body(channelingDTOWrapper);
	}
	
	@GetMapping("/channeling/findbydoctoranddate")
	public ResponseEntity<ChannelingDTOWrapper> findByDoctorAndDate(@RequestParam String date, @RequestParam int doctorId) throws ParseException {
		List<ChannelingEntitity> channelingEntities = channelingModel.getAllChannelings(date, doctorId);
		List<ChannelingDTO> channelingDTOs = new ArrayList<ChannelingDTO>();
		for (ChannelingEntitity entitity : channelingEntities) {
			channelingDTOs.add(convertToDTO(entitity));
		}
		ChannelingDTOWrapper channelingDTOWrapper = new ChannelingDTOWrapper();
		channelingDTOWrapper.setList(channelingDTOs);
		return ResponseEntity.status(HttpStatus.OK).body(channelingDTOWrapper);
	}

	private ChannelingEntitity convertToEntity(ChannelingDTO dto) {
		ChannelingEntitity entity = modelMapper.map(dto, ChannelingEntitity.class);
		return entity;
	}

	private ChannelingDTO convertToDTO(ChannelingEntitity entity) {
		ChannelingDTO dto = modelMapper.map(entity, ChannelingDTO.class);

		return dto;
	}
}
