package com.ensah.absence.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompte;

    private boolean accountNonExpired = true;

    private boolean accountNonLocked = true;

    private boolean credentialsNonExpired = true;

    private boolean enabled = true;

    private String login;

    private String password;

    private boolean disconnectAccount;

    private boolean accepteDemandeAutorisationAbsence;

    private boolean affichePhoto;

    private boolean afficheEmail;

    @ManyToOne
    @JoinColumn(name = "idRole")
    private Role role;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idUtilisateur")
    private Utilisateur proprietaire;

    @OneToMany(mappedBy = "compte", cascade = CascadeType.ALL,targetEntity = Notification.class)
    private List<Notification> notifications;

    @OneToMany(mappedBy = "compte", cascade = CascadeType.ALL, targetEntity = JournalisationEvenements.class)
    private List<JournalisationEvenements> journalisationEvenements;
}
