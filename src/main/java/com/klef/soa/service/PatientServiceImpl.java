package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Patient;
import com.klef.soa.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService
{
  @Autowired
  private PatientRepository repo;
  @Override
  public Patient addPatient(Patient patient) 
  {
    return repo.save(patient);
  }

  @Override
  public List<Patient> displayAllPatients() {
    return repo.findAll();
  }

  @Override
  public Patient updatePatient(Patient p) 
  {
  Optional<Patient> optional =repo.findById(p.getId());
  if(optional.isPresent()) 
  {
    Patient patient = optional.get();
    patient.setName(p.getName());
    patient.setAge(p.getAge());
    patient.setContact(p.getContact());
    patient.setRemarks(p.getRemarks());
    
    return repo.save(patient);
    
  }
  else {
    return null;
  }
  }

  @Override
  public Patient displayPatientById(Long id) 
  {
    return repo.findById(id).orElse(null);
  }

  @Override
  public String deletePatientById(Long id) {
    boolean status =repo.existsById(id);
    if(status) 
    {
      repo.deleteById(id);
      return "Patient Deleted Successfully";
    }
    else 
    {
      return "Patient ID Not Found";
    }
  }

  @Override
  public List<Patient> displayPatientsByGender(String gender)
  {
    return repo.findByGender(gender);
  }

  @Override
  public Long displayPatientCount()
  {
	return repo.count();
  }

}
