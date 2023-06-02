package com.ensah.absence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data@AllArgsConstructor@NoArgsConstructor@ToString
public class Coordination {
    @Id
    @GeneratedValue
    private Long idCoordination;

    private LocalDate dateDebut;

    private LocalDate dateFin;
    @ManyToOne
    private Filiere filiere;
    @ManyToOne
    private Enseignant enseignant;

    public CharSequence getDateDebutStr() {
        return getDateDebut().toString();
    }

    public CharSequence getDateFinStr() {
        return getDateFin().toString();
    }
}

