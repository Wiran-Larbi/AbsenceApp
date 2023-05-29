package com.ensah.absence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data @AllArgsConstructor @ToString @NoArgsConstructor
public class Utilisateur {

    @Id
    @GeneratedValue(generator = "increment_id_utilisateur")
    @GenericGenerator(name = "increment_id_utilisateur", strategy = "increment")
    private Long idUtilisateur;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "cin" ,unique = true, nullable = true)
    private String cin;

    @Column(unique = true, nullable = true)
    private String email;

    @Column(nullable = true)
    private String telephone;

    /*
    @Column(nullable = true)
    private String nomArabe;

    @Column(nullable = true)
    private String prenomArabe;
    */

    @JsonIgnore
    private String photo;

    @JsonIgnore
    @OneToMany(mappedBy = "proprietaire", cascade = CascadeType.ALL, targetEntity = Compte.class)
    private Set<Compte> comptes;
}