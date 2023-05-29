package com.ensah.absence.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data@AllArgsConstructor@NoArgsConstructor@ToString
public class InscriptionModule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInscriptionModule;

	private double noteSN;
	private double noteSR;
	private double noteFinale;
	private String validation;
	private String plusInfos;

	@ManyToOne
	@JoinColumn(name = "idModule")
	private Module module;

	@ManyToOne
	@JoinColumn(name = "idInscription")
	private InscriptionAnnuelle inscriptionAnnuelle;




}
