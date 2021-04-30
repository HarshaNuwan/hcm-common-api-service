package edu.bit.hcm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.bit.hcm.entity.DoctorEntity;

@Repository
public interface DoctorDetailsRepository extends JpaRepository<DoctorEntity, Integer> {

}
