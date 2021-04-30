package edu.bit.hcm.model;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.hcm.entity.ChannelingEntitity;
import edu.bit.hcm.repository.ChannelingRepository;

@Service
public class ChannelingModel {

	@Autowired
	private ChannelingRepository channelingRepository;
	
	public List<ChannelingEntitity> getAllChannelings() {
		List<ChannelingEntitity> channelingEntities = channelingRepository.findAll();
		
		return channelingEntities;
	}

	public void saveChannelingDetails(ChannelingEntitity channelingEntitity) {
		channelingRepository.save(channelingEntitity);
	}
	
	public List<ChannelingEntitity> getAllChannelings(Date fDate, int fDoctorId) {
		List<ChannelingEntitity> channelingEntities = channelingRepository.findByDoctorIDAndDate(fDate,  new Integer(fDoctorId));
		
		return channelingEntities;
	}

}
