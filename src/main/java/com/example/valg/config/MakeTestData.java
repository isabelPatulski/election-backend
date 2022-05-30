package com.example.valg.config;

import com.example.valg.entities.Cyclist;
import com.example.valg.entities.Team;
import com.example.valg.repositories.CyclistRepository;
import com.example.valg.repositories.TeamRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@Profile("!test")
public class MakeTestData implements ApplicationRunner {

    CyclistRepository cyclistRepository;
    TeamRepository teamRepository;

    public MakeTestData(CyclistRepository cyclistRepository, TeamRepository teamRepository) {
        this.cyclistRepository = cyclistRepository;
        this.teamRepository = teamRepository;
    }

    public void makeTeamsWithCyclist(){
        Team team1 = new Team("Team Easy on");
        Team team2 = new Team("Cofidis");
        Team team3 = new Team("Israel Premier Tech");
        Team team4 = new Team("Movistar Team");

        Cyclist cyclist1 = new Cyclist("Bobby Olsen");
        Cyclist cyclist2 = new Cyclist("Pim de Keysergracht");
        Cyclist cyclist3 = new Cyclist("Benjamin Thomas");
        Cyclist cyclist4 = new Cyclist("Ion Izagirre");
        Cyclist cyclist5 = new Cyclist("Rudy Barbier");
        Cyclist cyclist6 = new Cyclist("Jorge Arcas");
        Cyclist cyclist7 = new Cyclist("Alex Aranburu ");
        Cyclist cyclist8 = new Cyclist("Mathias Norsgaard");

        team1.addCyclist(Set.of(cyclist1,cyclist2));
        team2.addCyclist(Set.of(cyclist3,cyclist4));
        team3.addCyclist(Set.of(cyclist5));
        team4.addCyclist(Set.of(cyclist6,cyclist7, cyclist8));

        teamRepository.saveAll(List.of(team1, team2, team3, team4));

    }


    @Override
    public void run(ApplicationArguments args) throws Exception {

        makeTeamsWithCyclist();
    }
}

