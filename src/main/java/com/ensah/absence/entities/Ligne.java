package com.ensah.absence.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data@AllArgsConstructor@NoArgsConstructor@ToString
public class Ligne {

	@Id
	@GeneratedValue
	private int id;
	private String cne;
	private String nom ;
	private String prenom;
	private int id_niveau;
	private String type;

	

}
