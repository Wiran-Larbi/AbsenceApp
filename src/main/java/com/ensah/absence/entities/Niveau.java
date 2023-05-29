package com.ensah.absence.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Niveau {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idNiveau;

	private String alias;

	private String titre;

	@OneToMany(mappedBy = "niveau" , cascade = CascadeType.ALL, targetEntity = Module.class)
	private List<Module> modules;

	@OneToMany(mappedBy = "niveau" , cascade = CascadeType.ALL, targetEntity = InscriptionAnnuelle.class)
	private List<InscriptionAnnuelle> inscriptions;

	@ManyToOne
	@JoinColumn(name="idFiliere")
	private Filiere filiere;



	
	
}