package com.sith.sir;



import com.sith.sir.security.SecurityConfig;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Import;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;
import javax.annotation.security.RolesAllowed;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import javax.management.Notification;
import java.util.List;
import java.util.Optional;
@Import(SecurityConfig.class)
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
        Twilio.init("AC36495638afb137d0807184f2b37bbae3","4a90cb3d0ce7ea6cb60032bfba27b642");
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("+13185071317"),
                        new com.twilio.type.PhoneNumber("+13072964041"),
                        "SIR Generated: " + incident.getEventType())
                .create();
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


