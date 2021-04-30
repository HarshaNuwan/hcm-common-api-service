package edu.bit.hcm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "hms_master_patients" database table.
 * 
 */
@Entity
@Table(name="\"hms_master_patient\"", schema = "hcm_schema")
@NamedQuery(name="PatientEntity.findAll", query="SELECT p FROM PatientEntity p")
public class PatientEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="\"pid\"")
	private int pid;

	@Column(name="\"address_line_1\"")
	private String addressLine1;

	@Column(name="\"address_line_2\"")
	private String addressLine2;

	@Column(name="\"address_line_3\"")
	private String addressLine3;

	@Column(name="\"blood_group_code\"")
	private int bloodGroupCode;

	@Temporal(TemporalType.DATE)
	@Column(name="\"dob\"")
	private Date dob;

	@Column(name="\"email\"")
	private String email;

	@Column(name="\"first_name\"")
	private String firstName;

	@Column(name="\"gender_code\"")
	private int genderCode;

	@Column(name="\"height\"")
	private String height;

	@Column(name="\"last_name\"")
	private String lastName;

	@Column(name="\"mobile\"")
	private String mobile;

	@Column(name="\"nic\"")
	private String nic;

	@Column(name="\"telephone\"")
	private String telephone;

	@Column(name="\"title_code\"")
	private int titleCode;

	@Column(name="\"weight\"")
	private String weight;
	

	public PatientEntity() {
	}

	public int getPid() {
		return this.pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return this.addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public int getBloodGroupCode() {
		return this.bloodGroupCode;
	}

	public void setBloodGroupCode(int bloodGroupCode) {
		this.bloodGroupCode = bloodGroupCode;
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

	public int getGenderCode() {
		return this.genderCode;
	}

	public void setGenderCode(int genderCode) {
		this.genderCode = genderCode;
	}

	public String getHeight() {
		return this.height;
	}

	public void setHeight(String height) {
		this.height = height;
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

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getTitleCode() {
		return this.titleCode;
	}

	public void setTitleCode(int titleCode) {
		this.titleCode = titleCode;
	}

	public String getWeight() {
		return this.weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

}