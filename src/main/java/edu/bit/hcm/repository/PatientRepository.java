package edu.bit.hcm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.bit.hcm.entity.PatientEntity;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

}
