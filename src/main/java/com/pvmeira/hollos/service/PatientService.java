package com.pvmeira.hollos.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pvmeira.hollos.entity.Patient;
import com.pvmeira.hollos.repository.PatientRepository;
import com.pvmeira.hollos.repository.filter.PatientSearchFilter;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;

	public void save(Patient patient) {
		try {
			this.addRegisterAndVisitDate(patient);
			// save
			patientRepository.save(patient);
		} catch (Exception e) {
			throw new IllegalArgumentException("Ops, ocorreu um erro");
		}
	}

	// Check if this is the a add(*Add a istance fot Register and LastVisit
	// date´s) or a edit(*Dont do anything)
	private void addRegisterAndVisitDate(Patient patient) {
		if (patient.getId() == null) {
			patient.setRegisterDate(Calendar.getInstance().getTime());
			patient.setLastVisitDate(Calendar.getInstance().getTime());
		}
	}

	public void delete(Long id) {
		patientRepository.delete(id);
	}

	public List<Patient> listAllPatients() {
		return patientRepository.findAll();
	}

	public List<Patient> filtrar(PatientSearchFilter filtro) {
		List<Patient> result=new ArrayList<>();
		String descricao = filtro.getDescricao() == null ? "%" : filtro.getDescricao();
		List<Patient> list = patientRepository.findByNameContaining(descricao);
		for (Patient patient : list) {
			if(patient.isActive()){
				result.add(patient);
			}
		}
		return result;
	}
	public List<Patient> listAllPatientDisable(){
		List<Patient> result=new ArrayList<>();
		List<Patient> l = this.patientRepository.findAll();
		
		for (Patient patient : l) {
			if(!patient.isActive()){
				result.add(patient);
			}
		}
		return result;
	}
	public void disactivePatient(Patient p){
		p.setActive(false);
		patientRepository.save(p);
	}
	
	public void activePatient(Patient p){
		p.setActive(Boolean.TRUE);
		patientRepository.save(p);
	}
}
