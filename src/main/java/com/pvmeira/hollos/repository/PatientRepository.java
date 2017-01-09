package com.pvmeira.hollos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pvmeira.hollos.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	//Search by %name
	public List<Patient>findByNameContaining(String descricao);
	//Search all patients that are active
	public List<Patient>findByActiveTrue();
}
