package com.karkinos.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.karkinos.springboot.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

	List findByNameLike(String name);

	/*	List findByNameLike(String full_name);


	 * @Query("SELECT p FROM patient p WHERE p.ID LIKE %?1%"
	 * +"OR p.FULL_NAME LIKE LIKE %?1%" +"OR p.phone LIKE %?1%") public
	 * List<Patient> findAll(String keyword);
	 
	
		public List<Patient> findByIDContainingAndPatient(String ID,Patient patient);
	*/
}
