package com.ensah.absence.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor

@NoArgsConstructor
public class Filiere {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFiliere;

	private String titreFiliere;

	private String codeFiliere;

	private int anneeaccreditation;

	private int anneeFinaccreditation;

	@OneToMany(mappedBy = "filiere" ,  cascade = CascadeType.ALL, targetEntity = Niveau.class)
	private Set<Niveau> niveaux;
	@OneToMany(mappedBy = "filiere" ,  cascade = CascadeType.ALL, targetEntity = Coordination.class)
	private Set<Coordination> coordinations;
	public void addNiveau(Niveau niveau) {
		niveaux.add(niveau);
		niveau.setFiliere(this);
	}
	public void addNiveaux(List<Niveau> niveaux) {
		for (Niveau niveau : niveaux) {
			this.addNiveau(niveau);
		}
	}
	public void addCoordination(Coordination coordination){
		coordinations.add(coordination);
		coordination.setFiliere(this);
	}
	public void addCoordinations(List<Coordination> coordinations) {
		for (Coordination coordination : coordinations) {
			this.addCoordination(coordination);
		}
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Filiere filiere = (Filiere) o;
		return idFiliere != null && idFiliere.equals(filiere.idFiliere);
	}

	@Override
	public int hashCode() {
		return 31;
	}
	@Override
	public String toString() {
		return "Filiere{" +
				"idFiliere=" + idFiliere +
				", titreFiliere='" + titreFiliere + '\'' +
				", codeFiliere='" + codeFiliere + '\'' +
				", anneeaccreditation=" + anneeaccreditation +
				", anneeFinaccreditation=" + anneeFinaccreditation +
				'}';
	}





}