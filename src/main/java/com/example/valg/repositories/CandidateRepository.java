package com.example.valg.repositories;

import com.example.valg.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate,Integer> {
  List<Candidate> findCandidateByParty_Partyletter(String letter);
}
