package com.example.valg.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "team", cascade = {CascadeType.PERSIST ,CascadeType.MERGE})
    private Set<Cyclist> cyclists = new HashSet<>();

    public Team(String name) {
        this.name = name;
    }

    public void addCyclist(Cyclist cyclist) {
        this.cyclists.add(cyclist);
        cyclist.setTeam(this);
    }

    public void addCyclist(Set<Cyclist> cyclists) {
        this.cyclists.addAll(cyclists);
        for (Cyclist cyclist : cyclists) {
            cyclist.setTeam(this);
        }
    }
}
