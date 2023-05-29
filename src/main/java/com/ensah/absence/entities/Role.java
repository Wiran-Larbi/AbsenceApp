package com.ensah.absence.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRole;

	private String nomRole;

	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL , targetEntity = Compte.class)
	private Set<Compte> comptes;

	public String getNomRole() {
		return nomRole;
	}


	
	
}