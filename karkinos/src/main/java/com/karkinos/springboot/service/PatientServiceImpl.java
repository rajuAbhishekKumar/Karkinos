package com.karkinos.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karkinos.springboot.model.Patient;
import com.karkinos.springboot.repository.PatientRepository;

/*Service layer file for our application for business logic operations  */
@Service
public class PatientServiceImpl implements PatientService {

	
	@Autowired
	private PatientRepository patientRepository;
	
	@Override
	public List<Patient> getAllPatient() {
		return patientRepository.findAll();
	}

	@Override
	public void savePatient(Patient patient) {
		this.patientRepository.save(patient);		
	}

	@Override
	public Patient getPatientById(long ID) {

		Optional<Patient> optional = patientRepository.findById(ID);
		Patient patient = null;
		
		if(optional.isPresent()) {
			
			patient = optional.get();
		}else {
			
			throw new RuntimeException("Patient Not Find "+ ID);
			
		}
		return patient;
		
	}
	
	

	@Override
	public void deletePatient(long id) {
		this.patientRepository.deleteById(id);		
	}

	@Override
	public List findByName(String name) {
		return patientRepository.findByNameLike("%"+name+"%");
	}

	
}
