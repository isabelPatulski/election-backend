package com.example.valg.repositories;

import com.example.valg.entities.Candidate;
import com.example.valg.entities.Party;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest   //IMPORTANT
class CandidateRepositoryTest {

    @Autowired
    PartyRepository partyRepository;

    @Autowired
    CandidateRepository candidateRepository;

    @BeforeEach
    void setUp() {
        partyRepository.deleteAll();
        candidateRepository.deleteAll();
        Party party1 = new Party("Socialdemokratiet","A");
        Candidate candidate1 = new Candidate("Marcel Meijer");
        Candidate candidate2 = new Candidate("Michael Kristensen");

        party1.addCandidate(candidate1);
        party1.addCandidate(candidate2);
        partyRepository.save(party1);
    }

    @Test
    public void getCandidates(){
        List<Candidate> candidates = candidateRepository.findAll();
        assertEquals(2,candidates.size());
    }
    @Test
    public void getCandidatesFromPartyOK(){
        List<Candidate> candidates = candidateRepository.findCandidateByParty_Partyletter("A");
        assertEquals(2,candidates.size());
    }
    @Test
    public void getCandidatesFromPartyNotOK(){
        List<Candidate> candidates = candidateRepository.findCandidateByParty_Partyletter("C");
        assertEquals(0,candidates.size());
    }
}