package com.ensah.absence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "journalisation_evenements")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JournalisationEvenements {

    @Id
    private Long idEvenements;

    private String details;

    private String adresseIP;

    private Date DateHeure;

    private String typeEvenements;

    private String criticite;

    @ManyToOne
    @JoinColumn(name = "idCompte")
    private Compte compte;




}
