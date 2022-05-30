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
    private String fullName;


    public CyclistResponse(Cyclist cyclist) {
        this.id = cyclist.getId();
        this.fullName = cyclist.getFullName();
    }

    public CyclistResponse(Cyclist cyclist, boolean includeAll) {
        this.fullName = cyclist.getFullName();
        this.id= cyclist.getId();
        }

}
