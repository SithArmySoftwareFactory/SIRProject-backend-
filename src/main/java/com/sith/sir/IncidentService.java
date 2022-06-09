package com.sith.sir;

import com.sith.sir.exceptions.ApiException;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.message.MapMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class IncidentService {

    private final IncidentRepository incidentRepository;

    @Autowired
    private EmailSenderService senderService;


    public void sendMail(Incident incident) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        senderService.sendEmail("lance.c.redfearn.mil@swf.army.mil", String.format("**New Incident** %s %s" , formatter.format(date), incident.getDescription()) ,
                String.format("Sir/Ma'am,\n\n"+
                        "Below is the information for a new incident. Please log into the SIR portal to review.\n\n"+
                        "Location of Event: %s\n\n" +
                        "Event Type: %s\n\n" +
                        "Harm or Potential Harm: %s\n\n" +
                        "Individuals Involved: %s\n\n" +
                        "Type of Event: %s\n\n" +
                        "Harm Sustained: %s\n\n" +
                        "Witness Name: %s\n\n" +
                        "Witness Phone: %s\n\n" +
                        "Departments: %s\n\n" +
                        "Description: %s\n\n" +
                        "Actions Taken: %s\n\n" +
                        "Patient Name: %s\n\n" +
                        "Patient SSN: \n\n" +
                        "Patient Phone: %s\n\n" +
                        "Patient Address: %s",
                        incident.getLocation(),
                        incident.getEventType(),
                        incident.getHarm(),
                        incident.getIndividuals(),
                        incident.getIncidentType(),
                        incident.getEffects(),
                        incident.getWitness1Name(),
                        incident.getWitness1Phone(),
                        incident.getDepartment(),
                        incident.getDescription(),
                        incident.getPrevention(),
                        incident.getPatientName(),
                        incident.getPatientSSN(),
                        incident.getPatientPhone(),
                        incident.getPatientAddress(),
                        incident.getDescription()));
    }


    public String sendToCommandService(){

        senderService.sendEmail("lance.c.redfearn.mil@swf.army.mil","**New Incidents To Review**",
                String.format("Sir/Ma'am,\n\n You have Incidents to review. Please log into the SRI portal to review.")
                );
        return "Sent to commander";
    }

    public Incident createASingleIncident(Incident incident) {
        if(incident == null) {
            return null;
        } else {
            sendMail(incident);
            incidentRepository.save(incident);
            return incidentRepository.save(incident);
        }
    }

    public Optional<Incident> getASingleIncident(Long id) {
        if (incidentRepository.existsById(id)) {
            return incidentRepository.findById(id);
        } else {
            throw new ApiException("Incident id:" + id + " does not exist.");
        }
    }


    public Incident patchASingleIncident(Long id, Incident incident) {
        if (incidentRepository.existsById(id)) {

            Incident updatingIncident = incidentRepository.findIncidentById(id);
            //need to add logic for patch
            if(incident.getDate() != null)
            updatingIncident.setDate(incident.getDate());
            System.out.println(incident.getDate());
            if(incident.getTime() != null)
            updatingIncident.setTime(incident.getTime());

            if(incident.getCommand() != null)
            updatingIncident.setCommand(incident.getCommand());

            if(incident.getEffects() != null)
            updatingIncident.setEffects(incident.getEffects());

            if(incident.getEventType() != null)
            updatingIncident.setEventType(incident.getEventType());

            if(incident.getIncidentType() != null)
            updatingIncident.setIncidentType(incident.getIncidentType());

            if(incident.getHarm() != null)
            updatingIncident.setHarm(incident.getHarm());

            if(incident.getLocation() != null)
            updatingIncident.setLocation(incident.getLocation());

            if(incident.getPatientName() != null)
            updatingIncident.setPatientName(incident.getPatientName());

            if(incident.getPatientAddress() != null)
            updatingIncident.setPatientAddress(incident.getPatientAddress());

            if(incident.getPatientSSN() != null)
            updatingIncident.setPatientSSN(incident.getPatientSSN());

            if(incident.getPatientPhone() != null)
            updatingIncident.setPatientPhone(incident.getPatientPhone());

            if(incident.getIndividuals() != null)
            updatingIncident.setIndividuals(incident.getIndividuals());

            if(incident.getWitness1Name() != null)
            updatingIncident.setWitness1Name(incident.getWitness1Name());

            if(incident.getWitness1Phone() != null)
            updatingIncident.setWitness1Phone(incident.getWitness1Phone());

            if(incident.getWitness2Name() != null)
            updatingIncident.setWitness2Name(incident.getWitness2Name());

            if(incident.getWitness2Phone() != null)
            updatingIncident.setWitness2Phone(incident.getWitness2Phone());

            if(incident.getWitness3Name() != null)
            updatingIncident.setWitness3Name(incident.getWitness3Name());

            if(incident.getWitness3Phone() != null)
            updatingIncident.setWitness3Phone(incident.getWitness3Phone());

            if(incident.getDepartment() != null)
            updatingIncident.setDepartment(incident.getDepartment());

            if(incident.getDescription() != null)
            updatingIncident.setDescription(incident.getDescription());

            if(incident.getPrevention() != null)
            updatingIncident.setPrevention(incident.getPrevention());

            if(incident.getLat() != null)
            updatingIncident.setLat(incident.getLat());

            if(incident.getLng() != null)
            updatingIncident.setLng(incident.getLng());

            if(incident.getSentiment() != null)
                updatingIncident.setSentiment(incident.getSentiment());

            if(incident.getSentiment() != null)
                updatingIncident.setSentiment(incident.getSentiment());

            incidentRepository.save(updatingIncident);

            return incidentRepository.findIncidentById(id);

        } else {
            throw new ApiException("Incident id:" + id + " does not exist.");
        }
    }

    public String deleteASingleIncident(Long id) {
        if (incidentRepository.existsById(id)) {
            incidentRepository.deleteById(id);
            return "Incident deleted.";
        } else {
            throw new ApiException("Incident id:" + id + " does not exist.");
        }
    }

    public List<Incident> getAllIncidents(String sort, String filter) {
//        if (sort == null) {
//            sort = "asc";
//        }
//
//        if ((filter != null) && (filter.length() > 0)) {
//            if (sort.equals("desc")) {
//                return incidentRepository.findByNameStartingWithIgnoreCaseOrderByNameDesc(filter);
//            } else {
//                return incidentRepository.findByNameStartingWithIgnoreCaseOrderByNameAsc(filter);
//            }
//        } else if (sort.equals("desc")) {
//            return incidentRepository.findAllByOrderByIdDesc();
//        }

        return incidentRepository.findAll();

    }
}

