package com.example.valg.repositories;

import com.example.valg.entities.Cyclist;
import com.example.valg.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CyclistRepository extends JpaRepository<Cyclist,Integer> {
    List<Cyclist> findCyclistByTeam_Name(String name);
}