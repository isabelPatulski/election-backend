package com.example.valg.dto;

import com.example.valg.entities.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class CyclistRequest {
    String fullName;


    public CyclistRequest(String fullName) {
        this.fullName = fullName;
    }
}
