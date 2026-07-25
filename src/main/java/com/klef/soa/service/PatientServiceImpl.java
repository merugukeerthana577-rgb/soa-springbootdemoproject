package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import com.klef.soa.entity.Patient;
import com.klef.soa.repository.PatientRepository;

public class PatientServiceImpl implements PatientService 
{
	private final PatientRepository repo;

	PatientServiceImpl(PatientRepository repo) {
		this.repo = repo;
	}
	@Override
	public Patient addPatient(Patient patient) {
		return repo.save(patient);
		
	}

	@Override
	public List<Patient> displayAllPatients()
	{
		return  repo.findAll();
		
	}

	@Override
	public Patient updatePatient(Patient p) 
	{
		Optional<Patient> optional = repo.findById(p.getId());
		if (optional.isPresent())
	{
		Patient patient = optional.get();
		
		patient.setName(p.getName());
		patient.setAge(p.getAge());
		patient.setContact(p.getContact());
		patient.setRemarks(p.getRemarks());
		
	 return repo.save(patient);
	}
		else
		{
			return null;
		}
	}

	@Override
	public Patient displayPatientById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletePatientById(Long id)
	{
	 boolean status = repo.existsById(id);
	 if(status)
	 {
		repo.deleteById(id);
		return "Patient Deleted Successfully";
	 }
	 else
	 {
		 return "Patient ID not found";
	 }
	}

	@Override
	public List<Patient> displayPatientByGender(String gender) 
	{
		return repo.findByGender(gender);
		
	}

}
