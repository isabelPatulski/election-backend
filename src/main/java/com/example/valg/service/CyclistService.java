package com.example.valg.service;

import com.example.valg.dto.CyclistRequest;
import com.example.valg.dto.CyclistResponse;
import com.example.valg.entities.Cyclist;
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

    public List<CyclistResponse> getAllCyclist(String name){
        List <Cyclist> cyclists;
        if(name != null){
            cyclists = cyclistRepository.findCyclistByTeam_Name(name);
        } else {
            cyclists = cyclistRepository.findAll();
        }
        //return candidates.stream().map(CandidateResponse::new).collect(Collectors.toList());
        return cyclists.stream().map((cyclist) -> new CyclistResponse(cyclist)).collect(Collectors.toList());
    }

}

    /*public CyclistResponse getCyclist(int id,boolean all) throws Exception {
        Cyclist cyclist = cyclistRepository.findById(id).orElseThrow(()->new Client4xxException("No cyclist with this id exists"));
        return new CyclistResponse(cyclist,false);
    }

    public CyclistResponse addCyclist(CyclistRequest body){
        Cyclist cyclistNew = cyclistRepository.save(new Cyclist(body.getName(), body.getTeam()));
        return new CyclistResponse(cyclistNew);

    }

    public CyclistResponse editCyclist(CyclistRequest cyclistToEdit, int cyclistId){
        Cyclist cyclist = cyclistRepository.findById(cyclistId).orElseThrow(()-> new Client4xxException("No cyclist with provided ID found"));
        cyclist.setTeam(cyclistToEdit.getTeam());
        cyclist.setName(cyclistToEdit.getName());
        CyclistResponse candidateResponseEdit = new CyclistResponse(cyclistRepository.save(cyclist));
        return candidateResponseEdit;
    }

}

 public List<CyclistResponse> getCyclists(String team) {
        List<Cyclist> cyclists;
        if(team != null){
            cyclists = cyclistRepository.findCyclistByTeam_Name(team);
        } else {
            cyclists = cyclistRepository.findAll();
        }
        //return candidates.stream().map(CandidateResponse::new).collect(Collectors.toList());
        return cyclists.stream().map((cyclist)->new CyclistResponse(cyclist)).collect(Collectors.toList());
    }
*/