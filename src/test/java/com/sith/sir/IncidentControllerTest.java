//package com.sith.sir;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.transaction.annotation.Transactional;
//import static org.springframework.http.MediaType.APPLICATION_JSON;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//
//@SpringBootTest
//@AutoConfigureMockMvc
//class IncidentControllerTest {
//    @Autowired
//    public MockMvc mvc;
//
//
//    @Test
//    @Transactional
//    @Rollback
//    void getASingleIncidentById() throws Exception {
//        this.mvc.perform(get("/api/incident/1")
//                        .contentType(APPLICATION_JSON))
//                .andExpect(jsonPath("$.id").value("1"))
//                .andExpect(jsonPath("$.date").value("2010-01-05"))
//                .andExpect(jsonPath("$.location").value("Barracks BLDG 6910"));
//    }
//
//    @Test
//    @Transactional
//    @Rollback
//    void updateASingleIncidentById() throws Exception {
//        this.mvc.perform(patch("/api/incident/1")
//                .contentType(APPLICATION_JSON)
//                .content("{ \"harm\" : false,\n" +
//                        "\"patientSSN\" : \"123-45-6789\",\n" +
//                        " \"patientName\" : \"Lance\"\n" +
//                        "}"));
//
//        this.mvc.perform(get("/api/incident/1").contentType(APPLICATION_JSON))
//                .andExpect(jsonPath("$.id").value(1))
//                .andExpect(jsonPath("$.harm").value(false))
//                .andExpect(jsonPath("$.patientSSN").value("123-45-6789"))
//                .andExpect(jsonPath("$.patientName").value("Lance"));
//    }
//
//
//
//
//    @Test
//    @Transactional
//    @Rollback
//    void returnAllIncidents() throws Exception {
//        this.mvc.perform(
//                post("/api/incident")
//                        .contentType(APPLICATION_JSON)
//                        .content("{ \"location\" : \"barracks\" }")
//        );
//        this.mvc.perform(get("/api/incident"))
//                .andExpect(jsonPath("$.length()").value(2));
//    }
//
//    @Test
//    @Transactional
//    @Rollback
//    void deleteASingleIncidentById() throws Exception {
//        this.mvc.perform(
//                post("/api/incident")
//                        .contentType(APPLICATION_JSON)
//                        .content("{ \"location\" : \"barracks\" }")
//        );
//        this.mvc.perform(get("/api/incident/"))
//                .andExpect(jsonPath("$.length()").exists());
//
//        this.mvc.perform(delete("/api/incident/2"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[1].location").doesNotExist());
//    }
//
//    @Test
//    @Transactional
//    @Rollback
//    void createASingleIncidentWithPost() throws Exception {
//        this.mvc.perform(
//                post("/api/incident")
//                        .contentType(APPLICATION_JSON)
//                        .content("{\n" +
//                                "    \"date\": \"2010-01-05\",\n" +
//                                "    \"time\": \"06:30\",\n" +
//                                "    \"location\": \"barracks\",\n" +
//                                "    \"eventType\": \"Actual Event/Incident\",\n" +
//                                "    \"incidentType\": \"Medical\",\n" +
//                                "    \"harm\": true,\n" +
//                                "    \"effects\": true,\n" +
//                                "    \"patientSSN\": \"777-99-8888\",\n" +
//                                "    \"patientPhone\": \"512-409-4941\",\n" +
//                                "    \"patientAddress\": \"123 Street\",\n" +
//                                "    \"patientName\": \"John\",\n" +
//                                "    \"witness1Name\": \"Jane\",\n" +
//                                "    \"witness1Phone\": \"123-456-7890\",\n" +
//                                "    \"witness2Name\": \"Alice\",\n" +
//                                "    \"witness2Phone\": \"111-222-3333\",\n" +
//                                "    \"witness3Name\": \"Bob\",\n" +
//                                "    \"witness3Phone\": \"888-888-8888\",\n" +
//                                "    \"department\": \"Dental\",\n" +
//                                "    \"description\": \"SM fell out of chair and broke teeth\",\n" +
//                                "    \"prevention\": \"SM should have been sedated\",\n" +
//                                "    \"individuals\": \"Patient, Staff Member\",\n" +
//                                "    \"command\": \"11th EN BN\"\n" +
//                                "}")
//        );
//        this.mvc.perform(get("/api/incident/")
//                        .contentType(APPLICATION_JSON))
//                .andExpect(jsonPath("$[1].location").value("barracks"));
//    }
//}