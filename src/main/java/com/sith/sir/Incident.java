package com.sith.sir;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime time;
    private String location;
    private String incidentType;
    private Boolean harm;
    private String individuals;
    private String eventType;
    private Boolean effects;
    private String patientSSN;
    private String patientPhone;
    private String patientAddress;
    private String patientName;
    private String witness1Name;
    private String witness1Phone;
    private String witness2Name;
    private String witness2Phone;
    private String witness3Name;
    private String witness3Phone;
    private String department;
    private String description;
    private String prevention;
    private String command;

    public Incident(Long id, LocalDate date, LocalTime time, String location, String incidentType, Boolean harm, String individuals, String eventType, Boolean effects, String patientSSN, String patientPhone, String patientAddress, String patientName, String witness1Name, String witness1Phone, String witness2Name, String witness2Phone, String witness3Name, String witness3Phone, String department, String description, String prevention, String command) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.location = location;
        this.incidentType = incidentType;
        this.harm = harm;
        this.individuals = individuals;
        this.eventType = eventType;
        this.effects = effects;
        this.patientSSN = patientSSN;
        this.patientPhone = patientPhone;
        this.patientAddress = patientAddress;
        this.patientName = patientName;
        this.witness1Name = witness1Name;
        this.witness1Phone = witness1Phone;
        this.witness2Name = witness2Name;
        this.witness2Phone = witness2Phone;
        this.witness3Name = witness3Name;
        this.witness3Phone = witness3Phone;
        this.department = department;
        this.description = description;
        this.prevention = prevention;
        this.command = command;
    }

    public Incident(LocalDate date, LocalTime time, String location, String incidentType, Boolean harm, String individuals, String eventType, Boolean effects, String patientSSN, String patientPhone, String patientAddress, String patientName, String witness1Name, String witness1Phone, String witness2Name, String witness2Phone, String witness3Name, String witness3Phone, String department, String description, String prevention, String command) {
        this.date = date;
        this.time = time;
        this.location = location;
        this.incidentType = incidentType;
        this.harm = harm;
        this.individuals = individuals;
        this.eventType = eventType;
        this.effects = effects;
        this.patientSSN = patientSSN;
        this.patientPhone = patientPhone;
        this.patientAddress = patientAddress;
        this.patientName = patientName;
        this.witness1Name = witness1Name;
        this.witness1Phone = witness1Phone;
        this.witness2Name = witness2Name;
        this.witness2Phone = witness2Phone;
        this.witness3Name = witness3Name;
        this.witness3Phone = witness3Phone;
        this.department = department;
        this.description = description;
        this.prevention = prevention;
        this.command = command;
    }

    public Incident() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Boolean getHarm() {
        return harm;
    }

    public void setHarm(Boolean harm) {
        this.harm = harm;
    }

    public Boolean getEffects() {
        return effects;
    }

    public void setEffects(Boolean effects) {
        this.effects = effects;
    }

    public String getPatientSSN() {
        return patientSSN;
    }

    public void setPatientSSN(String patientSSN) {
        this.patientSSN = patientSSN;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getWitness1Name() {
        return witness1Name;
    }

    public void setWitness1Name(String witness1Name) {
        this.witness1Name = witness1Name;
    }

    public String getWitness1Phone() {
        return witness1Phone;
    }

    public void setWitness1Phone(String witness1Phone) {
        this.witness1Phone = witness1Phone;
    }

    public String getWitness2Name() {
        return witness2Name;
    }

    public void setWitness2Name(String witness2Name) {
        this.witness2Name = witness2Name;
    }

    public String getWitness2Phone() {
        return witness2Phone;
    }

    public void setWitness2Phone(String witness2Phone) {
        this.witness2Phone = witness2Phone;
    }

    public String getWitness3Name() {
        return witness3Name;
    }

    public void setWitness3Name(String witness3Name) {
        this.witness3Name = witness3Name;
    }

    public String getWitness3Phone() {
        return witness3Phone;
    }

    public void setWitness3Phone(String witness3Phone) {
        this.witness3Phone = witness3Phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrevention() {
        return prevention;
    }

    public void setPrevention(String prevention) {
        this.prevention = prevention;
    }

    public String getIndividuals() {
        return individuals;
    }

    public void setIndividuals(String individuals) {
        this.individuals = individuals;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(String incidentType) {
        this.incidentType = incidentType;
    }
}
