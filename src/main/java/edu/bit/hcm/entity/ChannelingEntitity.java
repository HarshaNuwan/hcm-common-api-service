package edu.bit.hcm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "hms_master_channeling" database table.
 * 
 */
@Entity
@Table(name="\"hms_master_channeling\"", schema = "hcm_schema")
@NamedQuery(name="ChannelingEntitity.findAll", query="SELECT h FROM ChannelingEntitity h")
public class ChannelingEntitity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="\"channeling_id\"")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int channelingId;

	@Column(name="\"appointment_no\"")
	private int appointmentNo;

	@Temporal(TemporalType.DATE)
	@Column(name="\"date\"")
	private Date date;

	@Column(name="\"doctor_id\"")
	private int doctorId;

	@Column(name="\"pid\"")
	private int pid;

	@Column(name="\"reason\"")
	private String reason;

	@Column(name="\"time\"")
	private String time;

	public ChannelingEntitity() {
	}

	public int getChannelingId() {
		return this.channelingId;
	}

	public void setChannelingId(int channelingId) {
		this.channelingId = channelingId;
	}

	public int getAppointmentNo() {
		return this.appointmentNo;
	}

	public void setAppointmentNo(int appointmentNo) {
		this.appointmentNo = appointmentNo;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}