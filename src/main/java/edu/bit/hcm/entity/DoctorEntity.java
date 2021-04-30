package edu.bit.hcm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "hms_master_doctors" database table.
 * 
 */
@Entity
@Table(name="\"hms_master_doctors\"" , schema = "hcm_schema")
@NamedQuery(name="DoctorEntity.findAll", query="SELECT d FROM DoctorEntity d")
public class DoctorEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="\"doctor_id\"")
	private int doctorId;

	@Column(name="\"address_l1\"")
	private String addressL1;

	@Column(name="\"address_l2\"")
	private String addressL2;

	@Column(name="\"address_l3\"")
	private String addressL3;

	@Temporal(TemporalType.DATE)
	@Column(name="\"dob\"")
	private Date dob;

	@Column(name="\"email\"")
	private String email;

	@Column(name="\"first_name\"")
	private String firstName;

	@Column(name="\"last_name\"")
	private String lastName;

	@Column(name="\"mobile\"")
	private String mobile;

	@Column(name="\"nic\"")
	private String nic;

	@Column(name="\"reg_no\"")
	private String regNo;

	@Column(name="\"specialization_code\"")
	private int specializationCode;

	@Column(name="\"telephone\"")
	private String telephone;

	public DoctorEntity() {
	}

	public int getDoctorId() {
		return this.doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getAddressL1() {
		return this.addressL1;
	}

	public void setAddressL1(String addressL1) {
		this.addressL1 = addressL1;
	}

	public String getAddressL2() {
		return this.addressL2;
	}

	public void setAddressL2(String addressL2) {
		this.addressL2 = addressL2;
	}

	public String getAddressL3() {
		return this.addressL3;
	}

	public void setAddressL3(String addressL3) {
		this.addressL3 = addressL3;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNic() {
		return this.nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getRegNo() {
		return this.regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public int getSpecializationCode() {
		return this.specializationCode;
	}

	public void setSpecializationCode(int specializationCode) {
		this.specializationCode = specializationCode;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}