package com.ensah.absence.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@PrimaryKeyJoinColumn(name = "idEnseighant")
@AllArgsConstructor@NoArgsConstructor @Data @ToString
public class Enseignant extends Utilisateur {


	
	private String specialite;

}