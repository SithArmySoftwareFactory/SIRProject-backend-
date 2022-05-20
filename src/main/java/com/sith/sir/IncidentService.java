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
        return incidentRepository.save(incident);
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
            updatingIncident.setDate(incident.getDate());
            updatingIncident.setTime(incident.getTime());

            updatingIncident.setCommand(incident.getCommand());

            updatingIncident.setEffects(incident.getEffects());

            updatingIncident.setEventType(incident.getEventType());
            updatingIncident.setHarm(incident.getHarm());

            updatingIncident.setLocation(incident.getLocation());

            updatingIncident.setPatientName(incident.getPatientName());
            updatingIncident.setPatientAddress(incident.getPatientAddress());
            updatingIncident.setPatientSSN(incident.getPatientSSN());
            updatingIncident.setPatientPhone(incident.getPatientPhone());

            updatingIncident.setIndividuals(incident.getIndividuals());

            updatingIncident.setWitness1Name(incident.getWitness1Name());
            updatingIncident.setWitness1Phone(incident.getWitness1Phone());
            updatingIncident.setWitness2Name(incident.getWitness2Name());
            updatingIncident.setWitness2Phone(incident.getWitness2Phone());
            updatingIncident.setWitness3Name(incident.getWitness3Name());
            updatingIncident.setWitness3Phone(incident.getWitness3Phone());

            updatingIncident.setDepartment(incident.getDepartment());
            updatingIncident.setDescription(incident.getDescription());
            updatingIncident.setPrevention(incident.getPrevention());

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

