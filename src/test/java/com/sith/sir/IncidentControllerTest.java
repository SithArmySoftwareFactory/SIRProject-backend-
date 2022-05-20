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
                        .content("{\n" +
                                "  \"location\": \"Barracks BLDG 6910\",\n" +
                                "}")
        );
        this.mvc.perform(get("/api/incident/2")
                        .contentType(APPLICATION_JSON))
//                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].location").value("Barracks BLDG 6910"));

    }

    @Test
    @Transactional
    @Rollback
    void getASingleDonutById() throws Exception {
        this.mvc.perform(get("/api/incident/1")
                        .contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value("Name1"))
                .andExpect(jsonPath("$.expiration").value("2010-01-05"));
    }

    @Test
    @Transactional
    @Rollback
    void updateASingleDonutById() throws Exception {
        this.mvc.perform(patch("/api/incident/1")
                .contentType(APPLICATION_JSON)
                .content("{\n" +
                        "  \"name\": \"fake_data\",\n" +
                        "  \"topping\": \"fake_data\",\n" +
                        "  \"expiration\": \"2022-12-05\"\n" +
                        "}"));

        this.mvc.perform(get("/api/incident/1").contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("fake_data"))
                .andExpect(jsonPath("$.expiration").value("2022-12-05"));
    }

    @Test
    @Transactional
    @Rollback
    void deleteASingleDonutById() throws Exception {
        int id = 1;

        this.mvc.perform(get("/api/incident/1")
                        .contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value("Name1"))
                .andExpect(jsonPath("$.expiration").value("2010-01-05"));

        this.mvc.perform(delete("/api/incident/1").contentType(APPLICATION_JSON));

        this.mvc.perform(get("/api/incident/1")
                        .contentType(APPLICATION_JSON))
                .andExpect(content().string("Data error code: 03x03499fa. Please contact a System Administrator"));
    }

    @Test
    @Transactional
    @Rollback
    void returnAllDonuts() throws Exception {
        this.mvc.perform(get("/api/incident/1")
                        .contentType(APPLICATION_JSON))
//                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$.location").value("Barracks BLDG 6910"));

        this.mvc.perform(get("/api/incident")
                        .contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].location").value("Barracks BLDG 6910"));
    }

    @Test
    @Transactional
    @Rollback
    void returnAllDonutsWithFilter() throws Exception {
        this.mvc.perform(get("/api/incident?filter=X")
                        .contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value("2"))
                .andExpect(jsonPath("$[0].name").value("Xame2"))
                .andExpect(jsonPath("$[0].expiration").value("2010-01-05"));

        this.mvc.perform(get("/api/incident")
                        .contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$[3].id").value("4"))
                .andExpect(jsonPath("$[3].name").value("Name4"));
    }

    @Test
    @Transactional
    @Rollback
    void returnAllDonutsWithFilterDesc() throws Exception {
        this.mvc.perform(get("/api/incident?filter=N&sort=desc")
                        .contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value("4"))
                .andExpect(jsonPath("$[0].name").value("Name4"))
                .andExpect(jsonPath("$[0].expiration").value("2010-01-05"))
                .andExpect(jsonPath("$[1].id").value("1"))
                .andExpect(jsonPath("$[1].name").value("Name1"));
        ;

    }

    @Test
    @Transactional
    @Rollback
    void returnAllDonutsWithFilterAsc() throws Exception {
        this.mvc.perform(get("/api/incident?filter=N&sort=asc")
                        .contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].name").value("Name1"))
                .andExpect(jsonPath("$[1].id").value("4"))
                .andExpect(jsonPath("$[1].name").value("Name4"));


    }
}