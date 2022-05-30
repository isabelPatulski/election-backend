package com.example.valg.repositories;

import com.example.valg.entities.Cyclist;
import com.example.valg.entities.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest   //IMPORTANT
class CyclistRepositoryTest {

    @Autowired
    CyclistRepository cyclistRepository;

    @Autowired
    TeamRepository teamRepository;

    int cyclist1ID, cyclist2ID, team1ID, team2ID;
    String team1Name, team2Name;


    @BeforeEach
    void setUp() {
        cyclistRepository.deleteAll();
        teamRepository.deleteAll();
        Team team1 = new Team("Vinderne");
        Team team2 = new Team("Taberne");

        Cyclist cyclist1 = cyclistRepository.save(new Cyclist("Anja Nielsen"));
        Cyclist cyclist2 = cyclistRepository.save(new Cyclist("Flemming Nielse"));

        cyclist1ID = cyclist1.getId();
        cyclist2ID = cyclist2.getId();
        team1Name = team1.getTeamName();
        team2Name = team2.getTeamName();

        team1.addCyclist(Set.of(cyclist1));
        team2.addCyclist(Set.of(cyclist2));

        teamRepository.saveAll(List.of(team1, team2));
    }

    @Test
    public void findCyclistByTeam_TeamName() {
        List<Cyclist> allCyclistInTeam = cyclistRepository.findCyclistByTeam_TeamName(team1Name);
        assertEquals(1,allCyclistInTeam.size());
    }

}