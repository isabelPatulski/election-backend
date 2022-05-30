package com.example.valg.api;


import com.example.valg.dto.CyclistRequest;
import com.example.valg.dto.CyclistResponse;
import com.example.valg.entities.Cyclist;
import com.example.valg.entities.Team;
import com.example.valg.repositories.CyclistRepository;
import com.example.valg.service.CyclistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/cyclist")
public class CyclistController {

    CyclistService cyclistService;

    public CyclistController(CyclistService cyclistService) {
        this.cyclistService = cyclistService;
    }

    @GetMapping
    public List<CyclistResponse> getCyclists(){
        return cyclistService.getCyclists();
    }

    @GetMapping("/{id}")
    public CyclistResponse getCyclist(@PathVariable int id) throws Exception {
        return cyclistService.getCyclist(id);
    }

    //Adds a new racer to DB
    @PostMapping("/{id}")
    public CyclistResponse addCyclist(@RequestBody CyclistRequest body, @PathVariable int id) throws Exception {
        return cyclistService.addCyclist(body, id);
    }

    @PutMapping("/{id}")
    public CyclistResponse editCyclist(@RequestBody CyclistRequest body, @PathVariable int id) {
        return cyclistService.editCyclist(body, id);
    }


    @DeleteMapping("/{id}")
    public void deleteCyclist(@PathVariable int id) {
        cyclistService.deleteCyclist(id);
    }
}

