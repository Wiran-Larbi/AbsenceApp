package com.ensah.absence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.Set;



@Entity
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Inscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInscription;

	private int annee;

	private int etat;

	/**Permet de stocker les notes des matières*/
	@OneToMany(mappedBy = "inscription", cascade = CascadeType.ALL, targetEntity = Absence.class)
	private Set<Absence> absences;

	@ManyToOne
	@JoinColumn(name = "idNiveau")
	private Niveau niveau;

	@ManyToOne
	@JoinColumn(name = "idEtudiant")
	private Etudiant etudiant;

}