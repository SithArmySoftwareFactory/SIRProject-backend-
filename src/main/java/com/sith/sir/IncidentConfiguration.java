package com.sith.sir;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

@Configuration
public class IncidentConfiguration {
    private IncidentRepository ir;

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
                    true,
                    "777-99-8888",
                    "512-409-4941",
                    "123 Street",
                    "John",
                    "Jane",
                    "123-456-7890",
                    "Alice",
                    "111-222-3333",
                    "Bob",
                    "888-888-8888",
                    "Dental",
                    "SM fell out of chair and broke teeth",
                    "SM should have been sedated",
                    "Patient, Staff Member",
                    "11th EN BN");

            ir.save(one);
        };
    }

}
