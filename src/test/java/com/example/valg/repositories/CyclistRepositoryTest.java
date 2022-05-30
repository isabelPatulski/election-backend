package com.example.valg.repositories;

import com.example.valg.entities.Cyclist;
import com.example.valg.entities.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest   //IMPORTANT
class CyclistRepositoryTest {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    CyclistRepository cyclistRepository;

    @BeforeEach
    void setUp() {
        teamRepository.deleteAll();
        cyclistRepository.deleteAll();
        Team team1 = new Team("Team Easy On");
        Cyclist cyclist1 = new Cyclist("Bobby Olsen", team1);
        Cyclist cyclist2 = new Cyclist("Pim de Keysergracht", team1);

        cyclistRepository.save(cyclist1);
        cyclistRepository.save(cyclist2);

        teamRepository.save(team1);
    }

    @Test
    public void getCyclists(){
        List<Cyclist> cyclists = cyclistRepository.findAll();
        assertEquals(2,cyclists.size());
    }
    @Test
    public void getCyclistsFromTeamOK(){
        List<Cyclist> cyclists = cyclistRepository.findCyclistByTeam_Name("Team Easy On");
        assertEquals(2,cyclists.size());
    }
    @Test
    public void getCyclistsFromTeamNotOK(){
        List<Cyclist> cyclists = cyclistRepository.findCyclistByTeam_Name("Team ensom");
        assertEquals(0,cyclists.size());
    }
    @Test
    public void testAddCyclist(){
        Cyclist cyclistNew = cyclistRepository.save(new Cyclist("Bobby Olsen"));
        assertNotEquals(0,cyclistNew.getId());
        assertEquals(3,cyclistRepository.count());
    }
}