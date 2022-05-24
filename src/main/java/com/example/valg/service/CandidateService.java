package com.example.valg.service;

import com.example.valg.entities.Candidate;
import com.example.valg.repositories.CandidateRepository;
import com.example.valg.dto.CandidateResponse;
import com.example.valg.repositories.PartyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidateService {
    CandidateRepository candidateRepository;
    PartyRepository partyRepository;

    public CandidateService(CandidateRepository candidateRepository, PartyRepository partyRepository) {
        this.candidateRepository = candidateRepository;
        this.partyRepository = partyRepository;
    }


    public List<CandidateResponse> getAllCandidates(String letter) {
        List<Candidate> candidates;
        if(letter != null){
            candidates = candidateRepository.findCandidateByParty_Partyletter(letter);
        } else {
            candidates = candidateRepository.findAll();
        }
        //return candidates.stream().map(CandidateResponse::new).collect(Collectors.toList());
        return candidates.stream().map((candidate)->new CandidateResponse(candidate)).collect(Collectors.toList());
    }
}
