package com.tpjpa.demo.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "PATIENTS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Patient {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="NOM", length = 25)
	private String nom;
	@Temporal(TemporalType.DATE)
	private Date dateNaiss;
	private Boolean malade;
//	@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY )
//	private java.util.Collection<RendezVous> rendezVous;

}
