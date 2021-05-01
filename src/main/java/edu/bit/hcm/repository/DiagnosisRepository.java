package edu.bit.hcm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.bit.hcm.entity.DiagnosisEntity;

@Repository
public interface DiagnosisRepository extends JpaRepository<DiagnosisEntity, Integer> {
	
	@Query("SELECT d FROM DiagnosisEntity d WHERE d.pid = ?1 AND d.doctorId = ?2")
	public List<DiagnosisEntity> findByPidAndDoctorID(Integer pid, Integer doctorId);

}
