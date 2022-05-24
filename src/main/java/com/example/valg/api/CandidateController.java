package com.example.valg.api;

import com.example.valg.dto.CandidateResponse;
import com.example.valg.service.CandidateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/candidates")
public class CandidateController {

    CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping
    public List<CandidateResponse> getAllCandidates(@RequestParam(value="party", required = false) String party){
        return candidateService.getAllCandidates(party);
    }

}
