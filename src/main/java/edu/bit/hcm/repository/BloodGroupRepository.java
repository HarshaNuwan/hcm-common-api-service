package edu.bit.hcm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.bit.hcm.entity.BloodGroupEntity;

@Repository
public interface BloodGroupRepository extends JpaRepository<BloodGroupEntity, Integer> {

}
