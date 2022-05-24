package com.example.valg.repositories;

import com.example.valg.entities.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<Party,Integer> {
}
