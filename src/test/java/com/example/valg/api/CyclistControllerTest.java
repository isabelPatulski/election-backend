package com.example.valg.api;

import com.example.valg.dto.CyclistRequest;
import com.example.valg.entities.Cyclist;
import com.example.valg.entities.Team;
import com.example.valg.repositories.CyclistRepository;
import com.example.valg.repositories.TeamRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ActiveProfiles("test")
class CyclistControllerTest {
    @Autowired
    MockMvc mockMvc;


    @Autowired
    CyclistRepository cyclistRepository;

    @Autowired
    TeamRepository teamRepository;


    @Autowired
    private ObjectMapper objectMapper;

    static int cyclistOneId, cyclistTwoId;

    static Team teamOneID, teamTwoID;

    @BeforeEach
    public void setup() {
        cyclistRepository.deleteAll();
        teamRepository.deleteAll();


        //Make Cyclist
        Cyclist c1 = new Cyclist("Lars");
        cyclistRepository.save(c1);

        Cyclist c2 = new Cyclist("Gitte");
        cyclistRepository.save(c2);


        //Make Teams
        /*Team t1 = teamRepository.save
                (new Team("The Champions"));
        teamOneID = t1.getId();

        Team t2 = teamRepository.save
                (new Team("The Seconds"));
        teamTwoID = t2.getId();*/

    }


    @Test
    void testAddCyclist() throws Exception {
        CyclistRequest newCyclist = new CyclistRequest();
        mockMvc.perform(MockMvcRequestBuilders.post("/api/cyclists")
                .contentType("application/json")
                .accept("application/json")
                .content(objectMapper.writeValueAsString(newCyclist)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Hanne"));


        //Testing
        assertEquals(3, cyclistRepository.count());

    }


    @Test
    public void testUpdateCyclist() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .put("/api/cyclists/{id}", cyclistOneId)
                .content(objectMapper.writeValueAsString(new CyclistRequest("Børge")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Ændret"));


    }

    //Virker 22/3
    @Test
    void getCyclists() throws Exception {
        String name = "";
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/cyclists/")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0]").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))

                //Testing
                .andExpect(MockMvcResultMatchers.jsonPath(name, "Lars").exists())
                .andExpect(MockMvcResultMatchers.jsonPath(name, "Gitte").exists());

    }

    //Virker 22/3
    @Test
    void getCyclist() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/cyclists/{id}", cyclistOneId)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                //.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(personOneId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Lars"));

    }
}


    //Virker 22/3
    //Virker ikke 24/3
    /*
    @Test
    void deletePerson() throws Exception {

        System.out.println("1---------------------" + personRepository.count() + "---------------------");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .delete("/api/person/{id}", personOneId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        //Testing
        System.out.println("2---------------------" + personRepository.count() + "---------------------");

        assertEquals(1, personRepository.count());

    }

     */

