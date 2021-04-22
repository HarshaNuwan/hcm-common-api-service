package edu.bit.hcm.repository;

import org.springframework.stereotype.Repository;

import edu.bit.hcm.entity.PatientEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

}
