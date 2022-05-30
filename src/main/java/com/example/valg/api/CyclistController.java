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
    CyclistRepository cyclistRepository;

    public CyclistController(CyclistService cyclistService) {
        this.cyclistService = cyclistService;
    }

    @GetMapping
    public List<CyclistResponse> getAllCyclist(@RequestParam(value = "team", required = false) String name) {
        return cyclistService.getAllCyclist(name);
    }
}

