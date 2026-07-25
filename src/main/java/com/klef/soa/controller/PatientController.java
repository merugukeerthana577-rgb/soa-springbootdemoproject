package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.Patient;
import com.klef.soa.service.PatientService;

@RestController
public class PatientController 
{
	private final PatientService service;

	PatientController(PatientService service) {
		this.service = service;
	}
	
	@GetMapping("/")
  public String  test() 
  {
	  return "S0A Programming & Microservices";
  }
	@GetMapping("/displayall")
	public ResponseEntity<List<Patient>> displayallpatients()
	{
		List<Patient> patients = service.displayAllPatients();
		return ResponseEntity.status(200).body(patients);
		
	}
	@PostMapping("/add")
	public ResponseEntity<Patient> addpatient(@RequestBody Patient p)
	{
        Patient patient = service.addPatient(p);
		return ResponseEntity.status(201).body(patient);
	}
}
