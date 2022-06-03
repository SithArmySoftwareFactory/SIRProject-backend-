package com.sith.sir;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

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
                    "1600 Pennsylvania Avenue NW, Washington, DC 20500",
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
                    "11th EN BN", 38.8976633, -77.0365739);

            Incident two = new Incident(date,
                    time,
                    "Austin, TX",
                    "Actual Event/Incident",
                    false,
                    "Family Member,Patient,Adult,Child",
                    "Property,Adverse Drug Reaction",
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
                    "11th EN BN", 30.267153, -97.7430608);


            Incident three = new Incident(date,
                    time,
                    "San Diego",
                    "Actual Event/Incident",
                    false,
                    "Volunteer",
                    "Adverse Drug Reaction",
                    false,
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
                    "11th EN BN", 30.267153, -97.7430608);


            Incident four = new Incident(date,
                    time,
                    "Austin, TX",
                    "Actual Event/Incident",
                    true,
                    "Other",
                    "Adverse Drug Reaction",
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
                    "11th EN BN", 32.715738, -117.1610838);

            Incident five = new Incident(date,
                    time,
                    "New York",
                    "Actual Event/Incident",
                    true,
                    "Patient",
                    "Medical,Property,Adverse Drug Reaction",
                    false,
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
                    "11th EN BN", 40.7127753, -74.0059728);

            Incident six = new Incident(date,
                    time,
                    "Miami, FL",
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

            Incident seven = new Incident(date,
                    time,
                    "Tampa, FL",
                    "Actual Event/Incident",
                    false,
                    "Patient, Other",
                    "Medical,Property,Adverse Drug Reaction",
                    false,
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


            Incident eight = new Incident(date,
                    time,
                    "Little Rock, Arkansas",
                    "Actual Event/Incident",
                    false,
                    "Family Member,Patient",
                    "Property",
                    true,
                    "512-409-4941",
                    "555-432-2000",
                    "123 Street",
                    "Jake",
                    "Alice",
                    "123-456-7890",
                    "Bob",
                    "111-222-3333",
                    "Dud",
                    "324-234-5626",
                    "Dental",
                    "SM should have been sedated",
                    "Should have read the instruction manual.",
                    "11th EN BN");

            ir.saveAll(List.of(one,two,three,four,five,six,seven,eight));
        };
    }

}
