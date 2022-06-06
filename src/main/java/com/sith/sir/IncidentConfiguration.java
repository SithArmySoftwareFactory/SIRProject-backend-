package com.sith.sir;


import com.sith.sir.domain.AppUser;
import com.sith.sir.domain.Role;
import com.sith.sir.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class IncidentConfiguration {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner commandLineRunnerIncident(IncidentRepository incidentRepository) {

        return args -> {
            LocalDate date = LocalDate.of(2019, Month.JANUARY, 5);
            LocalTime time = LocalTime.of(6, 30);

            LocalDate date2 = LocalDate.of(2021, Month.FEBRUARY, 20);
            LocalTime time2 = LocalTime.of(10, 30);

            LocalDate date3 = LocalDate.of(2021, Month.MARCH, 13);
            LocalTime time3 = LocalTime.of(10, 30);

            LocalDate date4 = LocalDate.of(2021, Month.APRIL, 15);
            LocalTime time4 = LocalTime.of(12, 30);

            LocalDate date5 = LocalDate.of(2021,  Month.JUNE, 18);
            LocalTime time5 = LocalTime.of(14, 30);

            LocalDate date6 = LocalDate.of(2021, Month.DECEMBER, 4);
            LocalTime time6 = LocalTime.of(17, 30);


            LocalDate date7 = LocalDate.of(2021, Month.JANUARY, 20);
            LocalTime time7 = LocalTime.of(6, 30);


            LocalDate date8 = LocalDate.of(2021, Month.FEBRUARY, 14);
            LocalTime time8 = LocalTime.of(6, 30);

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
                    "11th EN BN", 38.8976633, -77.0365739, "low");

            Incident two = new Incident(date2,
                    time2,
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
                    "SM  did not participate in training and had no PT Belt.",
                    "Generate a CONOP for training.",
                    "11th EN BN", 30.267153, -97.7430608, "low");


            Incident three = new Incident(date3,
                    time3,
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
                    "We can prevent this from happening, by participating in the annual dental care program.",
                    "11th EN BN", 30.267153, -97.7430608, "medium");


            Incident four = new Incident(date4,
                    time4,
                    "Austin, TX",
                    "Actual Event/Incident",
                    true,
                    "Other",
                    "Needle Stick/Sharp Injury",
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
                    "Too many indivudals in the area, we can fix this by simply implementing our standard safety measures.",
                    "11th EN BN", 32.715738, -117.1610838, "high");

            Incident five = new Incident(date5,
                    time5,
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
                    "11th EN BN", 40.7127753, -74.0059728, "low");

            Incident six = new Incident(date6,
                    time6,
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
                    "Should have read the instruction manual. Next time we will have to implement guard actions.",
                    "11th EN BN", 25.830500, -80.180374, "medium");

            Incident seven = new Incident(date7,
                    time7,
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
                    "11th EN BN", 27.964157, -82.452606, "low");


            Incident eight = new Incident(date8,
                    time8,
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
                    "Need to wear a PT belt.",
                    "11th EN BN", 34.746483, -92.289597, "medium");

            incidentRepository.saveAll(List.of(one,two,three,four,five,six,seven,eight));
        };
    }

    @Bean
    CommandLineRunner run(UserService userService){
        return arg ->{
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new AppUser(null, "Bruce Black", "bruce", "1234", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Dakota Slay", "dakota", "1234", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Lance Redfearn", "lance", "1234", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Josh Matos", "josh", "1234", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Sydney Fink", "sydney", "1234", new ArrayList<>()));

            userService.addRoleToAppUser("bruce", "ROLE_USER");
            userService.addRoleToAppUser("bruce", "ROLE_MANAGER");
            userService.addRoleToAppUser("bruce", "ROLE_ADMIN");
            userService.addRoleToAppUser("bruce", "ROLE_SUPER_ADMIN");
            userService.addRoleToAppUser("dakota", "ROLE_MANAGER");
            userService.addRoleToAppUser("lance", "ROLE_ADMIN");
            userService.addRoleToAppUser("josh", "ROLE_SUPER_ADMIN");
            userService.addRoleToAppUser("sydney", "ROLE_SUPER_ADMIN");


        };
    }
}
