package com.ensah.absence.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data@AllArgsConstructor@NoArgsConstructor@ToString
public class Element {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMatiere;

	private String nom;

	private String code;
	
	private double currentCoefficient;

	@ManyToOne
	@JoinColumn(name="idModule")
	private Module module;

	
	

}