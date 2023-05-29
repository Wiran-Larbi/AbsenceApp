package com.ensah.absence;

import com.ensah.absence.repositories.UtilisateurRepository;
import com.github.javafaker.Faker;
import jdk.jshell.execution.Util;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AbsenceAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AbsenceAppApplication.class, args);
    }

    private void createUsers(Integer count) {
        Faker faker = new Faker();
        String nom = faker.name().firstName();
        String prenom = faker.name().lastName();
        String email = String.format("%s.%s@gmail.com", nom, prenom);
        String telephone = faker.numerify("+212 6## ### ###");
        String photo = String.format("src://%s-%s-img", nom, prenom);

    }

    @Bean
    CommandLineRunner commandLineRunner(UtilisateurRepository utilisateurRepository) {


        return args -> {
            System.out.println("This is just adding new Users ...");

        };
    }
}
