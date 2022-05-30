package com.example.valg.entities;


import com.example.valg.dto.CyclistRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Cyclist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne()
    private Team team;

    public Cyclist(String name) {
        this.name = name;
    }

    public Cyclist(CyclistRequest body) {
        this.name = body.getName();
        this.team = body.getTeam();
    }



    public Cyclist(String name, Team team) {
        this.name = name;
        this.team = team;

    }
}