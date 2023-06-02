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

@NoArgsConstructor
public class Niveau {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idNiveau;

	private String alias;

	private String titre;

	@OneToMany(mappedBy = "niveau" , cascade = CascadeType.ALL, targetEntity = Module.class)
	private List<Module> modules;

	@OneToMany(mappedBy = "niveau" , cascade = CascadeType.ALL, targetEntity = Inscription.class)
	private List<Inscription> inscriptions;

	@ManyToOne
	@JoinColumn(name="idFiliere")
	private Filiere filiere;
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Niveau niveau = (Niveau) o;
		return idNiveau != null && idNiveau.equals(niveau.idNiveau);
	}

	@Override
	public int hashCode() {
		return 31;
	}
	@Override
	public String toString() {
		return "Niveau{" +
				"idNiveau=" + idNiveau +
				", alias='" + alias + '\'' +
				", titre='" + titre + '\'' +
				'}';
	}
}