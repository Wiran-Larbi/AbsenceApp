package com.ensah.absence.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name = "idEnseignant")
@AllArgsConstructor@NoArgsConstructor @Data @ToString
public class Enseignant extends Utilisateur {
	
	private String specialite;
	@OneToMany(mappedBy = "enseignant" ,  cascade = CascadeType.ALL, targetEntity = Coordination.class)
	private Set<Coordination> coordinations;
	@OneToMany(mappedBy = "enseignant" ,  cascade = CascadeType.ALL, targetEntity = Absence.class)
	private Set<Absence> absence;

}