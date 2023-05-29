package com.ensah.absence.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@Entity
@Table(name = "notification")
@Data
@NoArgsConstructor@AllArgsConstructor
@ToString
public class Notification {

    @Id
    @Column(name = "id",unique = true)
    private Long idNotification;

    @Column(name = "type", nullable = true)
    private String type;

    @Column(name = "titre", nullable = true)
    private String titre;

    @Column(name = "texte", nullable = true)
    private String texte;

    @Column(name = "type", nullable = true)
    private Date dateCreation;

    private Integer etat;

    @ManyToOne
    @JoinColumn(name = "idCompte")
    private Compte compte;
}
