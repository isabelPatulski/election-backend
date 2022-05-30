package com.example.valg.dto;

import com.example.valg.entities.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TeamResponse {

    private String name;

    public TeamResponse(Team body) {
        this.name = body.getName();
    }

}
