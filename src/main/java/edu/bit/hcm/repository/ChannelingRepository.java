package edu.bit.hcm.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.bit.hcm.entity.ChannelingEntitity;

@Repository
public interface ChannelingRepository extends JpaRepository<ChannelingEntitity, Integer> {
	
	@Query("SELECT c FROM ChannelingEntitity c WHERE c.date = ?1 AND c.doctorId = ?2")
	public List<ChannelingEntitity> findByDoctorIDAndDate(Date date, Integer doctorId);

}
