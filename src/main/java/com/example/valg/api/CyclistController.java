package com.example.valg.api;


import com.example.valg.dto.CyclistRequest;
import com.example.valg.dto.CyclistResponse;
import com.example.valg.entities.Team;
import com.example.valg.service.CyclistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/cyclists")
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
    public CyclistResponse getCar(@PathVariable int id) throws Exception {
        return cyclistService.getCyclist(id,false);
    }

    @PostMapping
    public CyclistResponse addCar(@RequestBody CyclistRequest body){
        return cyclistService.addCyclist(body);
    }

    @PutMapping("/{id}")
    public CyclistResponse editCyclist(@RequestBody CyclistRequest body, @PathVariable int id){
        return cyclistService.editCyclist(body,id);
    }

    @DeleteMapping("/{id}")
    public void deleteCyclist(@PathVariable int id){}

}

    //@GetMapping
    //public List<CyclistResponse> getAllCyclist(@RequestParam(value="team", required = false) String team){
        //return cyclistService.getCyclists(team);





