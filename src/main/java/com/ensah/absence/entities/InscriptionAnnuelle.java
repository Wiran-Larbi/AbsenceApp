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
public class InscriptionAnnuelle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInscription;

	private int annee;

	private int etat;

	private String type;

	private int rang;

	private String validation;

	private String mention;

	private String plusInfos;

	/**Permet de stocker les notes des matières*/
	@OneToMany(mappedBy = "inscriptionAnnuelle", cascade = CascadeType.ALL, targetEntity = InscriptionMatiere.class)
	private Set<InscriptionMatiere> inscriptionMatieres;

	
	/**Permet de stocker les notes des matières*/
	@OneToMany(mappedBy = "inscriptionAnnuelle", cascade = CascadeType.ALL, targetEntity = InscriptionModule.class)
	private Set<InscriptionModule> inscriptionModules;

	@ManyToOne
	@JoinColumn(name = "idNiveau")
	private Niveau niveau;

	@ManyToOne
	@JoinColumn(name = "idEtudiant")
	private Etudiant etudiant;

}