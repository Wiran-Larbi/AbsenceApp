package com.ensah.absence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "idEtudiant")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Etudiant extends Utilisateur {

    @Column(unique = true,nullable = true)
    private String cne;

    private Date dateNaissance;

    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL, targetEntity = Inscription.class)
    private List<Inscription> inscriptions;


}



