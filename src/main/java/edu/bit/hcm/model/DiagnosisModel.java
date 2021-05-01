package edu.bit.hcm.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.hcm.entity.DiagnosisEntity;
import edu.bit.hcm.repository.DiagnosisRepository;

@Service
public class DiagnosisModel {

	@Autowired
	private DiagnosisRepository diagnosisRepository;

	public void saveDiagnosis(DiagnosisEntity diagnosisEntity) {
		diagnosisRepository.save(diagnosisEntity);

	}

	public List<DiagnosisEntity> findByPidAndDoctorId(int pid, int doctorId) {
		return diagnosisRepository.findByPidAndDoctorID(pid, doctorId);
	}

}
