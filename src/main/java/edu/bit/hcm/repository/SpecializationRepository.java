package edu.bit.hcm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.bit.hcm.entity.SpecializationEntity;

@Repository
public interface SpecializationRepository extends JpaRepository<SpecializationEntity, Integer>{ 

}
