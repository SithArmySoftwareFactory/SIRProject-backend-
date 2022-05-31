package com.sith.sir;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

@Configuration
public class IncidentConfiguration {
    private IncidentRepository incidentRepository;

    @Bean
    CommandLineRunner commandLineRunnerIncident(IncidentRepository ir) {

        return args -> {
            LocalDate date = LocalDate.of(2010, Month.JANUARY, 05);
            LocalTime time = LocalTime.of(6, 30);
            Incident one = new Incident(date,
                    time,
                    "Barracks BLDG 6910",
                    "Actual Event/Incident",
                    true,
                    "Family Member,Patient,Adult,Child",
                    "Medical,Property,Adverse Drug Reaction",
                    true,
                    "512-409-4941",
                    "555-432-2000",
                    "123 Street",
                    "Jane",
                    "Alice",
                    "123-456-7890",
                    "Bob",
                    "111-222-3333",
                    "Witness3IsMe",
                    "324-234-5626",
                    "Ambulatory Care,Dental",
                    "SM should have been sedated",
                    "Should have read the instruction manual.",
                    "11th EN BN");

            ir.save(one);
        };
    }

}
