package com.klef.soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.soa.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long>
{
 
}
