package com.example.valg.dto;

import com.example.valg.entities.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TeamResponse {

    int id;
    String teamName;

    public TeamResponse(Team body) {
        this.teamName = body.getTeamName();
        this.id = body.getId();
    }

}
