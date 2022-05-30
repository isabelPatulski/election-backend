package com.example.valg.service;

import com.example.valg.dto.CyclistRequest;
import com.example.valg.dto.CyclistResponse;
import com.example.valg.entities.Cyclist;
import com.example.valg.entities.Team;
import com.example.valg.repositories.CyclistRepository;
import com.example.valg.repositories.TeamRepository;
import error.Client4xxException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CyclistService {
    CyclistRepository cyclistRepository;
    TeamRepository teamRepository;

    public CyclistService() {
    }

    public CyclistService(CyclistRepository cyclistRepository) {
        this.cyclistRepository = cyclistRepository;
    }

    public CyclistService(CyclistRepository cyclistRepository, TeamRepository teamRepository) {
        this.cyclistRepository = cyclistRepository;
        this.teamRepository = teamRepository;
    }

    //Finder alle cyklister medmindre der er blevet givet en "teamName" attribut med - så er det kun dem fra
    // det hold der bliver vist
    public List<CyclistResponse> getCyclists(){
        List<Cyclist> cyclists =  cyclistRepository.findAll();
        return CyclistResponse.getCyclistsFromEntities(cyclists);
    }


    //Finder en cyklist fra et givent id
    public CyclistResponse getCyclist(int id) throws Exception {
        Cyclist cyclist = cyclistRepository.findById(id).orElseThrow(() -> new Client4xxException("No cyclist with that id could be found"));
        return new CyclistResponse(cyclist);
    }

    //Tilføjer cyklist
    public CyclistResponse addCyclist(CyclistRequest body, int teamId) throws Exception {
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new Client4xxException("No cyclist with that id could be found"));
        Cyclist newCyclist = new Cyclist(body);
        team.addCyclist(newCyclist);
        teamRepository.save(team);
        return new CyclistResponse(newCyclist);
    }

    //Redigere cyklist
    public CyclistResponse editCyclist(CyclistRequest cyclistRequest, int id) {
        Cyclist cyclistToEdit = cyclistRepository.findById(id).orElseThrow(() -> new Client4xxException("No cyclist with that id could be found"));
        cyclistToEdit.setFullName(cyclistRequest.getFullName());
        return new CyclistResponse(cyclistRepository.save(cyclistToEdit));
    }


    //Sletter en cyklist
    public void deleteCyclist(int id) {
        cyclistRepository.deleteById(id);
    }

}