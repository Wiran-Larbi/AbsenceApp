package com.ensah.absence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor

public class TypeSeance {
    @Id
    @GeneratedValue
    private int idTypeSeance;
    private String intitule;
    private String alias;

    @ManyToMany(mappedBy = "typeSeances", cascade = CascadeType.ALL, targetEntity = Absence.class)
    private List<Absence> absenceSet=new ArrayList<>();

}
