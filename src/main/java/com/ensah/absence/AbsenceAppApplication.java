package com.ensah.absence;

import com.ensah.absence.entities.Filiere;
import com.ensah.absence.repositories.UtilisateurRepository;
import com.ensah.absence.services.StructPedaService;
import com.github.javafaker.Faker;
import jdk.jshell.execution.Util;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@AllArgsConstructor
public class AbsenceAppApplication implements CommandLineRunner {
    private StructPedaService structPedaService;
    public static void main(String[] args) {
        SpringApplication.run(AbsenceAppApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        /*Filiere filiere1 = new Filiere();
        filiere1.setTitreFiliere("Génie Informatique");
        filiere1.setCodeFiliere("GI");
        filiere1.setAnneeaccreditation(2021);
        filiere1.setAnneeFinaccreditation(2024);
        structPedaService.ajouterFiliere(filiere1);

        Filiere filiere2 = new Filiere();
        filiere2.setTitreFiliere("Genie energetic énergie renouvelable");
        filiere2.setCodeFiliere("GEER");
        filiere2.setAnneeaccreditation(2020);
        filiere2.setAnneeFinaccreditation(2023);
        structPedaService.ajouterFiliere(filiere2);

        Filiere filiere3 = new Filiere();
        filiere3.setTitreFiliere("Génie mécanique");
        filiere3.setCodeFiliere("GM");
        filiere3.setAnneeaccreditation(2019);
        filiere3.setAnneeFinaccreditation(2022);
        structPedaService.ajouterFiliere(filiere3);

        Filiere filiere4 = new Filiere();
        filiere4.setTitreFiliere("Ingénierie de données");
        filiere4.setCodeFiliere("ID");
        filiere4.setAnneeaccreditation(2018);
        filiere4.setAnneeFinaccreditation(2021);
        structPedaService.ajouterFiliere(filiere4);
        Filiere filiere5 = new Filiere();
        filiere5.setTitreFiliere("Génie civil");
        filiere5.setCodeFiliere("GC");
        filiere5.setAnneeaccreditation(2018);
        filiere5.setAnneeFinaccreditation(2021);
        structPedaService.ajouterFiliere(filiere5);*/

    }
}
