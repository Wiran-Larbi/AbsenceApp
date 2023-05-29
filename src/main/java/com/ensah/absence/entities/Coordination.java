package com.ensah.absence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@Data@AllArgsConstructor@NoArgsConstructor@ToString
public class Coordination {
    @Id
    @GeneratedValue
    private Long idCoordination;
    private Date dateDebut;
    private Date dateFin;
    @ManyToOne
    private Filiere filiere;
    @ManyToOne
    private Enseignant enseignant;
}

