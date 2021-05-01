package edu.bit.hcm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.bit.hcm.entity.DoctorEntity;

@Repository
public interface DoctorDetailsRepository extends JpaRepository<DoctorEntity, Integer> {

	@Query("SELECT d FROM DoctorEntity d WHERE d.specializationCode = ?1")
	public List<DoctorEntity> findBySpecializationCode(Integer specializationCode);

}
