package com.ensah.absence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data @AllArgsConstructor @ToString @NoArgsConstructor
public class Utilisateur {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idUtilisateur;


    private String nom;


    private String prenom;

    @Column(unique = true)
    private String cin;

    @Column(unique = true)
    private String email;


    private String telephone;


    @JsonIgnore
    private String photo;

    @JsonIgnore
    @OneToMany(mappedBy = "proprietaire", cascade = CascadeType.ALL, targetEntity = Compte.class)
    private Set<Compte> comptes;
}