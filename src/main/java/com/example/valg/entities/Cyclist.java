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

    private String fullName;

    @ManyToOne()
    private Team team;

    public Cyclist(String fullName) {
        this.fullName = fullName;
    }

    public Cyclist(CyclistRequest body) {
        this.fullName = body.getFullName();
    }
}