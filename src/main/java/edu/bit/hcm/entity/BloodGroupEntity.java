package edu.bit.hcm.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "hms_def_blood_group" database table.
 * 
 */
@Entity
@Table(name="\"hms_def_blood_group\"")
@NamedQuery(name="BloodGroupEntity.findAll", query="SELECT b FROM BloodGroupEntity b")
public class BloodGroupEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="\"blood_group_code\"")
	private int bloodGroupCode;

	@Column(name="\"blood_group_name\"")
	private String bloodGroupName;

	public BloodGroupEntity() {
	}

	public int getBloodGroupCode() {
		return this.bloodGroupCode;
	}

	public void setBloodGroupCode(int bloodGroupCode) {
		this.bloodGroupCode = bloodGroupCode;
	}

	public String getBloodGroupName() {
		return this.bloodGroupName;
	}

	public void setBloodGroupName(String bloodGroupName) {
		this.bloodGroupName = bloodGroupName;
	}

}