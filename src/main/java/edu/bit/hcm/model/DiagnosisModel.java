package edu.bit.hcm.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.hcm.entity.ChannelingEntitity;
import edu.bit.hcm.entity.DiagnosisEntity;
import edu.bit.hcm.entity.PatientEntity;
import edu.bit.hcm.repository.DiagnosisRepository;
import edu.bit.hcm.repository.PatientRepository;

@Service
public class DiagnosisModel {

	@Autowired
	private DiagnosisRepository diagnosisRepository;

	@Autowired
	private PatientRepository patientRepository;

	public void saveDiagnosis(DiagnosisEntity diagnosisEntity) {
		diagnosisRepository.save(diagnosisEntity);

	}

	public List<DiagnosisEntity> findByPidAndDoctorId(int pid, int doctorId) {
		return diagnosisRepository.findByPidAndDoctorID(pid, doctorId);
	}

	public void updatePrescriptionStatus(int dId, boolean status) {
		diagnosisRepository.updatePrescriptionStatus(new Boolean(status), dId);
	}

	public List<DiagnosisEntity> findByDate(String date) {
		Date dd = null;
		try {
			dd = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(date).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return diagnosisRepository.findByDate(dd);
	}

	public PatientEntity getPatienEntityById(int id) {
		return patientRepository.findByPatientId(id);
	}

	public void completeLabReport(int diagnosisId) {
		diagnosisRepository.updateLabReportStatus(true, diagnosisId);
	}

	
	public List<DiagnosisEntity> getAllPrescriptions(String fDate) {
		List<DiagnosisEntity> pharmacyEntities = null;
		try {
			Date dd = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(fDate).getTime());
			pharmacyEntities = diagnosisRepository.findByDateForPharmacy(dd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pharmacyEntities;
	}
	
	public List<DiagnosisEntity> findByDate(Date date) {
		return diagnosisRepository.findByDateForPharmacy(date);
	}
	
}
