package com.sith.sir;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
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
    public String createASingleIncidentWithPost(@RequestBody Incident incident) {
        return incidentService.createASingleIncident(incident);
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


