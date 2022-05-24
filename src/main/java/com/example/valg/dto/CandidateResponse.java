package com.example.valg.dto;

import com.example.valg.entities.Candidate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CandidateResponse {

    private int id;
    private String name;
    private String partyLetter;

    public CandidateResponse(Candidate body) {
        this.id = body.getId();
        this.name = body.getName();
        this.partyLetter = body.getParty().getPartyletter();
    }
}
