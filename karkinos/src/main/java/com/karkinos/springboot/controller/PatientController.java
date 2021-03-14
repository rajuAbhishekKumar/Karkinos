package com.karkinos.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.karkinos.springboot.model.Patient;
import com.karkinos.springboot.service.PatientService;

@Controller
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	//Mapping for Main page 
	@GetMapping("/")
	public String viewHomePage(Model model,@RequestParam(defaultValue ="") String name) {
		model.addAttribute("listPatients", patientService.findByName(name));
		return "index";
		
	}
		
	
	//Form to add new User 
	@GetMapping("/showNewPatientForm")
	public String showNewPatientForm(Model model) {
		
		Patient patient = new Patient();
		model.addAttribute("patient", patient);
		return "new_patient";
		
	}

	//Save the Patient record in DB	
	@PostMapping("/savePatient")
	public String savePatient(@ModelAttribute("patient") Patient patient) {
		patientService.savePatient(patient);
		return "redirect:/";
		
	}
	
	//Search the patient based on ID.
	@GetMapping("/showFormForUpdate/{ID}")
	public String showFormForUpdate(@PathVariable(value="ID")long id,Model model) {
		Patient patient = patientService.getPatientById(id);
		model.addAttribute("patient", patient);
		return "update_patient";
		
	}
	
	
	//To delete patient record
	@GetMapping("/deletePatient/{ID}")
	public String showFormForUpdate(@PathVariable(value="ID")long id) {
		
		this.patientService.deletePatient(id);
		return "redirect:/";
		
	}
	
}
