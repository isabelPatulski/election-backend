package com.example.valg.dto;

import com.example.valg.entities.Cyclist;
import com.example.valg.entities.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class CyclistResponse {

    private int id;
    private String name;
    private Team team;

    public CyclistResponse(Cyclist cyclist) {
        this.id = cyclist.getId();
        this.name = cyclist.getName();
        this.team = cyclist.getTeam();
    }

    public CyclistResponse(Cyclist cyclist, boolean includeAll) {
        this.name = cyclist.getName();
        this.team = cyclist.getTeam();
        this.id= cyclist.getId();
        }

    public static List<CyclistResponse> getCyclistFromEntities(List<Cyclist> cyclists){
        return cyclists.stream().map(cyclist-> new CyclistResponse(cyclist,false)).collect(Collectors.toList());

    }

}
