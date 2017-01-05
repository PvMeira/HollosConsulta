package com.pvmeira.hollos.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "patient_history")
@SequenceGenerator(name = "patient_history_id_patient_history_seq", sequenceName = "patient_history_id_patient_history_seq", allocationSize = 1, initialValue = 1)
public class PatientHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_history_id_patient_history_seq")
	@Column(name = "id_patient_history")
	private Long id;

	private String patientName;

	private String userName;

	private Calendar actionDate;

	private String action;

	public PatientHistory() {
	}

	public PatientHistory(Long id, String patientName, String userName, Calendar actionDate, String action) {
		super();
		this.id = id;
		this.patientName = patientName;
		this.userName = userName;
		this.actionDate = actionDate;
		this.action = action;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Calendar getActionDate() {
		return actionDate;
	}

	public void setActionDate(Calendar actionDate) {
		this.actionDate = actionDate;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
