package edu.bit.hcm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "hms_master_diagnosis" database table.
 * 
 */
@Entity
@Table(name="\"hms_master_diagnosis\"", schema = "hcm_schema")
@NamedQuery(name="DiagnosisEntity.findAll", query="SELECT d FROM DiagnosisEntity d")
public class DiagnosisEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="\"diagnosis_id\"")
	private int diagnosisId;
	
	@Column(name="\"channel_id\"")
	private int channelId;

	@Temporal(TemporalType.DATE)
	@Column(name="\"date\"")
	private Date date;

	@Column(name="\"diagnosis\"")
	private String diagnosis;

	@Column(name="\"doctor_id\"")
	private int doctorId;

	@Column(name="\"pid\"")
	private int pid;

	@Column(name="\"prescription\"")
	private String prescription;

	@Column(name="\"reports\"")
	private String reports;
	
	@Column(name="\"prescription_status\"")
	private boolean prescriptionStatus;
	
	@Column(name="\"report_status\"")
	private boolean reportStatus;

	public DiagnosisEntity() {
	}

	public int getChannelId() {
		return this.channelId;
	}

	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDiagnosis() {
		return this.diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public int getDiagnosisId() {
		return this.diagnosisId;
	}

	public void setDiagnosisId(int diagnosisId) {
		this.diagnosisId = diagnosisId;
	}

	public int getDoctorId() {
		return this.doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getPid() {
		return this.pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPrescription() {
		return this.prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public String getReports() {
		return this.reports;
	}

	public void setReports(String reports) {
		this.reports = reports;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public void setPrescriptionStatus(boolean prescriptionStatus) {
		this.prescriptionStatus = prescriptionStatus;
	}

	public boolean isReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(boolean reportStatus) {
		this.reportStatus = reportStatus;
	}

	public boolean isPrescriptionStatus() {
		return prescriptionStatus;
	}
	
	

}