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

    public void makeCyclistsAndTeams(){
        Team team1 = new Team("Team easy on");
        Team team2 = new Team("Visma");
        Team team3 = new Team("Lotto Soudal");

        Cyclist cyclist1 = new Cyclist("Bobby Nielsen");
        Cyclist cyclist2 = new Cyclist("Leonardo Dicaprio");
        Cyclist cyclist3 = new Cyclist("Freddy Nielsen");
        Cyclist cyclist4 = new Cyclist("Anja Flemming");
        Cyclist cyclist5 = new Cyclist("Isabel Patulski Nielsen");
        Cyclist cyclist6 = new Cyclist("Thor");


        team1.addCyclist(Set.of(cyclist1, cyclist2, cyclist3));
        team2.addCyclist(Set.of(cyclist4, cyclist5));
        team3.addCyclist(Set.of(cyclist6));

        teamRepository.saveAll(List.of(team1, team2, team3));
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        makeCyclistsAndTeams();

    }

}