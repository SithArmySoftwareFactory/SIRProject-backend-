package com.sith.sir;

import com.sith.sir.exceptions.ApiException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class IncidentService {

    private final IncidentRepository incidentRepository;


    public Incident createASingleIncident(Incident incident) {
        if(incident == null) return null;
       return  incidentRepository.save(incident);
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

