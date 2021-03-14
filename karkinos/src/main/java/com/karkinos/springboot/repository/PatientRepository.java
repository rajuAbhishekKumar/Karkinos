package com.karkinos.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karkinos.springboot.model.Patient;


/*Main Repository file */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

	/*Used for search operation*/
	List findByNameLike(String string);


}
