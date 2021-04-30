package edu.bit.hcm.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "hms_def_specialization" database table.
 * 
 */
@Entity
@Table(name="\"hms_def_specialization\"", schema = "hcm_schema")
@NamedQuery(name="SpecializationEntity.findAll", query="SELECT h FROM SpecializationEntity h")
public class SpecializationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="\"specialization_code\"")
	private int specializationCode;

	@Column(name="\"specialization_name\"")
	private String specializationName;

	public SpecializationEntity() {
	}

	public int getSpecializationCode() {
		return this.specializationCode;
	}

	public void setSpecializationCode(int specializationCode) {
		this.specializationCode = specializationCode;
	}

	public String getSpecializationName() {
		return this.specializationName;
	}

	public void setSpecializationName(String specializationName) {
		this.specializationName = specializationName;
	}

}