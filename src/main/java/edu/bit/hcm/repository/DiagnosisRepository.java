package edu.bit.hcm.repository;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.bit.hcm.entity.DiagnosisEntity;

@Repository
public interface DiagnosisRepository extends JpaRepository<DiagnosisEntity, Integer> {
	
	@Query("SELECT d FROM DiagnosisEntity d WHERE d.pid = ?1 AND d.doctorId = ?2")
	public List<DiagnosisEntity> findByPidAndDoctorID(Integer pid, Integer doctorId);
	
	@Query("SELECT d FROM DiagnosisEntity d WHERE d.date = ?1")
	public List<DiagnosisEntity> findByDate(Date date);
	
	@Transactional
	@Modifying
	@Query("UPDATE DiagnosisEntity d SET d.prescriptionStatus=?1 WHERE d.diagnosisId = ?2")
	public void updatePrescriptionStatus(Boolean status, Integer diagnosis_id);
	
	@Transactional
	@Modifying
	@Query("UPDATE DiagnosisEntity d SET d.reportStatus=?1 WHERE d.diagnosisId = ?2")
	public void updateLabReportStatus(Boolean status, Integer diagnosis_id);

}
