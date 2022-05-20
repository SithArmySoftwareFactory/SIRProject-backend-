package com.sith.sir;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class IncidentController {

    private final IncidentService iS;

    @GetMapping("/api/incident")
    public List<Incident> returnAllIncidents(
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) String filter
    ) {
        return iS.getAllIncidents(sort, filter);
    }

    @PostMapping("/api/incident")
    public Incident createASingleIncidentWithPost(@RequestBody Incident incident) {
        return iS.createASingleIncident(incident);
    }

    @GetMapping("/api/incident/{id}")
    public Optional<Incident> getASingleIncidentById(@PathVariable Long id) {
        return iS.getASingleIncident(id);
    }

    @PatchMapping("/api/incident/{id}")
    public Incident updateASingleIncidentById(
            @PathVariable Long id,
            @RequestBody Incident incident
    ) {
        return iS.patchASingleIncident(id, incident);
    }

    @DeleteMapping("/api/incident/{id}")
    public String deleteASingleIncidentById(@PathVariable Long id) {
        return iS.deleteASingleIncident(id);
    }
}


