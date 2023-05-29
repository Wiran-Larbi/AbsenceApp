package com.ensah.absence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.Set;

@Entity
@Data@AllArgsConstructor@NoArgsConstructor@ToString
public class Absence {
    @Id
    @GeneratedValue
    private Long idAbsence;
    private Date dateHeureDebutAbsecnce;
    private Date dateHeureFinAbsecnce;
    private int etat;
    private String typeSaisie;
    @ManyToOne
    private Enseignant enseignant;
    @ManyToOne
    private Inscription inscription;
    @ManyToMany(mappedBy = "absenceSet", cascade = CascadeType.ALL, targetEntity = PieceJustif.class)
    private Set<PieceJustif> pieceJustifs;
    @ManyToMany(mappedBy = "absenceSet", cascade = CascadeType.ALL, targetEntity = TypeSeance.class)
    private Set<TypeSeance> typeSeances;

}
