package com.example.valg.repositories;

import com.example.valg.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team,Integer> {
    List<Team> findTeamById (int id);

}
