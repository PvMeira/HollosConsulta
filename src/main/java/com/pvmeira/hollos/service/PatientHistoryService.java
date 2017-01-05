package com.pvmeira.hollos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pvmeira.hollos.entity.PatientHistory;
import com.pvmeira.hollos.repository.PatientHistoryRepository;

@Service
public class PatientHistoryService {

	@Autowired
	private PatientHistoryRepository patientHistoryRepository;

	public void insertRegister(String type, PatientHistory p) {
		p.setAction(type);
		patientHistoryRepository.save(p);
	}
}
