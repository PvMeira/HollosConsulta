package com.pvmeira.hollos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pvmeira.hollos.entity.PatientHistory;

public interface PatientHistoryRepository extends JpaRepository<PatientHistory, Long> {

}
