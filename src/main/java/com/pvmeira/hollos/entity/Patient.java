package com.pvmeira.hollos.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "patient")
@SequenceGenerator(name = "patient_id_patient_seq", sequenceName = "patient_id_patient_seq", allocationSize = 1, initialValue = 1)
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_id_patient_seq")
	@Column(name = "id_patient")
	private Long id;

	@NotEmpty(message = "Nome é obrigatorio")
	@Size(max = 60, message = "O nome não pode ter mais de 60 caracteres")
	private String name;

	@NotEmpty(message = "Email é obrigatorio")
	private String email;

	private String phone;

	@NotEmpty(message = "Queixa é obrigatorio")
	private String complaint;

	private String treatment;

	private String observation;

	@DecimalMax(value = "120", message = "Idade não pode ser maior que 120 anos.")
	@DecimalMin(value = "1", message = "Idade não pode ser menor que 1 ano.")
	private int age;

	private String address;

	private String occupation;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date registerDate;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date lastVisitDate;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date nextVisitDate;

	private boolean active;

	public Patient() {
	}

	public Patient(Long id, String name, String email, String phone, String complaint, String treatment,
			String observation, int age, String address, String occupation, Date registerDate, Date lastVisitDate,
			Date nextVisitDate, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.complaint = complaint;
		this.treatment = treatment;
		this.observation = observation;
		this.age = age;
		this.address = address;
		this.occupation = occupation;
		this.registerDate = registerDate;
		this.lastVisitDate = lastVisitDate;
		this.nextVisitDate = nextVisitDate;
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getComplaint() {
		return complaint;
	}

	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Date getLastVisitDate() {
		return lastVisitDate;
	}

	public void setLastVisitDate(Date lastVisitDate) {
		this.lastVisitDate = lastVisitDate;
	}

	public Date getNextVisitDate() {
		return nextVisitDate;
	}

	public void setNextVisitDate(Date nextVisitDate) {
		this.nextVisitDate = nextVisitDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
