package com.ensah.absence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data@AllArgsConstructor@NoArgsConstructor@ToString
public class InscriptionMatiere {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInscriptionMatiere;

	private double noteSN;
	private double noteSR;
	private double noteFinale;
	private String validation;
	private String plusInfos;

	/** Coefficient */
	private double coefficient;

	@ManyToOne
	@JoinColumn(name = "idMatiere")
	private Element matiere;

	@ManyToOne
	@JoinColumn(name = "idInscription")
	private InscriptionAnnuelle inscriptionAnnuelle;

}
