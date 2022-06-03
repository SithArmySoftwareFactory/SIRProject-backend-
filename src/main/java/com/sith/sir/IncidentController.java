package com.sith.sir;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import javax.management.Notification;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class IncidentController {

    private final IncidentService incidentService;


    @GetMapping("/api/incident")
    public List<Incident> returnAllIncidents(
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) String filter
    ) {
        return incidentService.getAllIncidents(sort, filter);
    }

    @PostMapping("/api/incident")
    public Incident createASingleIncidentWithPost(@RequestBody Incident incident) {
        return incidentService.createASingleIncident(incident);
    }

    @PostMapping("/api/send")
    public String sendToCommand(){

        incidentService.sendToCommandService();
        return "Sent to commander.";
    }


    @GetMapping("/api/incident/{id}")
    public Optional<Incident> getASingleIncidentById(@PathVariable Long id) {
        return incidentService.getASingleIncident(id);
    }

    @PatchMapping("/api/incident/{id}")
    public Incident updateASingleIncidentById(
            @PathVariable Long id,
            @RequestBody Incident incident
    ) {
        return incidentService.patchASingleIncident(id, incident);
    }

    @DeleteMapping("/api/incident/{id}")
    public String deleteASingleIncidentById(@PathVariable Long id) {
        return incidentService.deleteASingleIncident(id);
    }
}


