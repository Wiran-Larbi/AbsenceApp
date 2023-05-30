package com.ensah.absence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class PieceJustif {
    @Id
    @GeneratedValue
    private Long idPieceJusif;
    private String cheminFichier;
    private String intitule;
    private int etat;
    private Date dateLivraison;
    private String source;
    @ManyToMany(mappedBy = "pieceJustifs", cascade = CascadeType.ALL, targetEntity = Absence.class)
    private Set<Absence> absenceSetJustif;
}
