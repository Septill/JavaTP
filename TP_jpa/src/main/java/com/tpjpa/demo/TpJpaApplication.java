package com.tpjpa.demo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.tpjpa.demo.entities.Patient;
import com.tpjpa.demo.repositories.PatientRepository;

@SpringBootApplication
public class TpJpaApplication implements CommandLineRunner{
	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(TpJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		patientRepository.save(new Patient(null,"Victo",new Date(), false));
		patientRepository.save(new Patient(null,"Paul",new Date(), true));
		patientRepository.save(new Patient(null,"Cedric",new Date(), false));
		patientRepository.save(new Patient(null,"Irina",new Date(),false));
		patientRepository.save(new Patient(null,"Anna",new Date(),false));
		
		Patient patient1= new Patient (null,"Hadrien",new Date(), true);
		Patient patient2= new Patient (null,"Katarina",new Date(), true);
		patientRepository.save(patient1);
		patientRepository.save(patient2);
		
		Patient patient3= new Patient (null,"Rayame",new Date(),true);
		Patient patient4= new Patient (null,"Richard",new Date(), true);
		patientRepository.saveAll(Arrays.asList(patient3,patient4));
		
		System.out.println("****************************");
		
		// x presente les objets qu'on trouve par findall
		// console print tous les patients
		patientRepository.findAll().forEach(x->{
			System.out.println(x.toString());
		});
		System.out.println("****************************");
		
		Patient patient = patientRepository.findById(3L).get();
		System.out.println(patient);
		System.out.println(patient.getNom());
		
		System.out.println("****************************");
		List<Patient> patients = patientRepository.findByNomContaining("c");
		patients.forEach(y->{
			System.out.println(y.getNom());
		});
		
		System.out.println("****************************");
		List<Patient> patients2 = patientRepository.findByMalade(true);
		patients.forEach(p->{
			System.out.println(p.getId());
		});
		
		System.out.println("**************************** contient xx");
		List<Patient> patients3 = patientRepository.findByNomContainingAndMalade("i",true);
		patients3.forEach(y->{
			System.out.println(y.getNom());
		});
		
		System.out.println("**************************** affiche par PAGE");
		//第二页  每页3个
		Page<Patient> patientPage = patientRepository.findAll(PageRequest.of(1, 3));
		patientPage.forEach(i->{
			System.out.println(i.getNom());
		});
		System.out.println("Nombre de page :" + patientPage.getTotalPages());
		
		System.out.println("**************************** par list de PAGE");
		List<Patient> listPatients = patientPage.getContent();
		listPatients.forEach(j->{
			System.out.println(j.getNom());
		});
		
		System.out.println("**************************** affiche par Pageable");
		//第一页  每页3个
		Page<Patient> pagePatient = patientRepository.findByMalade(true, PageRequest.of(0,3));
		pagePatient.forEach(o->{
			System.out.println(o.toString());
		});
	}
}
