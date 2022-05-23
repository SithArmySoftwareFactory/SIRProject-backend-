package com.sith.sir;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class IncidentControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    @Transactional
    @Rollback
    void createASingleIncidentWithPost() throws Exception {
        this.mvc.perform(
                post("/api/incident")
                        .contentType(APPLICATION_JSON)
                        .content("{ \"location\" : \"barracks\" }")
        );
        this.mvc.perform(get("/api/incident/2")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.location").value("barracks"));
    }

    @Test
    @Transactional
    @Rollback
    void getASingleIncidentById() throws Exception {
        this.mvc.perform(get("/api/incident/1")
                        .contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.date").value("2010-01-05"))
                .andExpect(jsonPath("$.location").value("Barracks BLDG 6910"));
    }

    @Test
    @Transactional
    @Rollback
    void updateASingleIncidentById() throws Exception {
        this.mvc.perform(patch("/api/incident/1")
                .contentType(APPLICATION_JSON)
                .content("{ \"harm\" : false,\n" +
                        "\"patientSSN\" : \"123-45-6789\",\n" +
                        " \"patientName\" : \"Lance\"\n" +
                        "}"));

        this.mvc.perform(get("/api/incident/1").contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.harm").value(false))
                .andExpect(jsonPath("$.patientSSN").value("123-45-6789"))
                .andExpect(jsonPath("$.patientName").value("Lance"));
    }

    @Test
    @Transactional
    @Rollback
    void deleteASingleIncidentById() throws Exception {
        this.mvc.perform(
                post("/api/incident")
                        .contentType(APPLICATION_JSON)
                        .content("{ \"location\" : \"barracks\" }")
        );
        this.mvc.perform(get("/api/incident/"))
                .andExpect(jsonPath("$.length()").value(2));

        this.mvc.perform(delete("/api/incident/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[1].location").doesNotExist());
    }


    @Test
    @Transactional
    @Rollback
    void returnAllIncidents() throws Exception {
        this.mvc.perform(
                post("/api/incident")
                        .contentType(APPLICATION_JSON)
                        .content("{ \"location\" : \"barracks\" }")
        );
        this.mvc.perform(get("/api/incident"))
                .andExpect(jsonPath("$.length()").value(2));
    }
}