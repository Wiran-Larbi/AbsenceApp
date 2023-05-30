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
    @Column(name = "id")
    private Long idNotification;


    private String type;


    private String titre;


    private String texte;


    private Date dateCreation;

    private Integer etat;

    @ManyToOne
    @JoinColumn(name = "idCompte")
    private Compte compte;
}
