package com.example.valg.service;

import com.example.valg.dto.CyclistRequest;
import com.example.valg.dto.CyclistResponse;
import com.example.valg.entities.Cyclist;
import com.example.valg.entities.Team;
import com.example.valg.repositories.CyclistRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;



@DataJpaTest
class CyclistServiceTest {
    @Autowired
    CyclistRepository cyclistRepository;
    CyclistService cyclistService;

    static int cyclist1Id, cyclist2Id, cyclist3Id;

    @BeforeAll
    static void setup(@Autowired CyclistRepository cyclistRepository) {
        cyclistRepository.deleteAll();
        cyclist1Id = cyclistRepository.save(new Cyclist("Bobby")).getId();
        cyclist2Id = cyclistRepository.save(new Cyclist("Flemming")).getId();
        cyclist3Id = cyclistRepository.save(new Cyclist("Isabel")).getId();
    }


    /*@BeforeEach
    public void setupService() {
        cyclistService = new CyclistService(cyclistRepository);
    }

    @Test
    void getCyclists() {
        List<CyclistResponse> cyclistResponse = cyclistService.getCyclists();
        assertEquals(3, cyclistResponse.size());
        assertInstanceOf(CyclistResponse.class, cyclistResponse.get(0));

    }

    @Test
    void getCyclistByName() {


    }

    @Test
    void addCyclist() {
            Team vinderTeam = new Team("vinderTeam");
            Cyclist newCyclist = new Cyclist("Anja", vinderTeam);
            CyclistResponse cyclistResponse = cyclistService.addCyclist(new CyclistRequest("Anja", newCyclist.getTeam()));
            assertEquals(4,cyclistResponse.getId());
            assertEquals("Anja",cyclistResponse.getName());

        List<CyclistResponse> cyclistResponses = cyclistService.getCyclists();
        assertEquals(4, cyclistResponses.size());
        assertInstanceOf(CyclistResponse.class, cyclistResponses.get(0));

    }

    //@Test
    void deleteCar() {
    }*/
}

