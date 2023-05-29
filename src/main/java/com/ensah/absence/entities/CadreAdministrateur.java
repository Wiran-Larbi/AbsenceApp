package com.ensah.absence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@PrimaryKeyJoinColumn(name = "idCardreAdmin")
@Data @AllArgsConstructor @NoArgsConstructor@ToString
public class CadreAdministrateur extends Utilisateur {

	private String grade;




}