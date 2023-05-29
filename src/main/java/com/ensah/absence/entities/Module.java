package com.ensah.absence.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data@AllArgsConstructor@NoArgsConstructor
public class Module {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idModule;

	private String titre;

	private String code;


	@OneToMany(mappedBy = "module", cascade = CascadeType.ALL, targetEntity = Element.class)
	private List<Element> elements;

	@ManyToOne
	@JoinColumn(name = "idNiveau")
	private Niveau niveau;
}