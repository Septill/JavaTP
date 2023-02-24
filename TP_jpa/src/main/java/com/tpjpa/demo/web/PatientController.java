package com.tpjpa.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tpjpa.demo.entities.Patient;
import com.tpjpa.demo.repositories.PatientRepository;

@RestController
public class PatientController {
	@Autowired
	private PatientRepository patientRepository;
	@GetMapping("/patients")
	public List<Patient> patients(){
		return patientRepository.findAll();
	}
	@GetMapping("/patients/{id}")
	public Patient patient(@PathVariable  Long id) {
		return patientRepository.findById(id).get();
	}
}
