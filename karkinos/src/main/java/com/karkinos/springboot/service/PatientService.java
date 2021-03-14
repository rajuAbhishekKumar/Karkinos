package com.karkinos.springboot.service;

import java.util.List;

import com.karkinos.springboot.model.Patient;

public interface PatientService {

	List<Patient> getAllPatient();
	void savePatient(Patient patient);
	Patient getPatientById(long id);
	void deletePatient(long id);
	List findByName(String name);
}
