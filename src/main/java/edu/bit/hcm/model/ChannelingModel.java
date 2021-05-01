package edu.bit.hcm.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.hcm.entity.ChannelingEntitity;
import edu.bit.hcm.entity.PatientEntity;
import edu.bit.hcm.repository.ChannelingRepository;
import edu.bit.hcm.repository.PatientRepository;

@Service
public class ChannelingModel {

	@Autowired
	private ChannelingRepository channelingRepository;

	@Autowired
	private PatientRepository patientRepository;

	public List<ChannelingEntitity> getAllChannelings() {
		List<ChannelingEntitity> channelingEntities = channelingRepository.findAll();

		return channelingEntities;
	}

	public void saveChannelingDetails(ChannelingEntitity channelingEntitity) {
		Date dd = new java.sql.Date(channelingEntitity.getDate().getTime());
		List<ChannelingEntitity> channelingEntitities = channelingRepository.findByDoctorIDAndDate(dd,
				channelingEntitity.getDoctorId());
		int nextAppointmentId = channelingEntitities.size() > 0 ? channelingEntitities.size() + 1 : 1;
		channelingEntitity.setAppointmentNo(nextAppointmentId);
		channelingRepository.save(channelingEntitity);
	}
	
	

	public List<ChannelingEntitity> getAllChannelings(String fDate, int fDoctorId) {
		List<ChannelingEntitity> channelingEntities = null;
		try {
			Date dd = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(fDate).getTime());
			channelingEntities = channelingRepository.findByDoctorIDAndDate(dd, new Integer(fDoctorId));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return channelingEntities;
	}
	
	public List<ChannelingEntitity> getAllChannelings(int pid, int fDoctorId) throws ParseException {
		List<ChannelingEntitity> channelingEntities = null;
		channelingEntities = channelingRepository.findByPIDAndDate(pid, fDoctorId);

		return channelingEntities;
	}

	public PatientEntity getPatienEntityById(int id) {
		return patientRepository.findByPatientId(id);
	}

}
