package com.tpjpa.demo.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tpjpa.demo.entities.Patient;

// JPA Repository 1er est l'entity qu'on utilise, 2em est type de ID d entity
public interface PatientRepository extends JpaRepository<Patient, Long>{
	public List<Patient> findByNomContaining(String name);
	public List<Patient> findByMalade(Boolean malad);
	public List<Patient> findByNomContainingAndMalade(String name, Boolean malad);
	// attention de la definition de Page
	public Page<Patient> findByMalade(Boolean malad,Pageable pageable);
	// 用SQL语句构建一个 JPA里不存在的方法
	@Query("Select p from Patient p Where dateNaiss between :x and :y or p.name :z")
	List<Patient> cherchePatient (Date d1, Date d2, String nom);
}
