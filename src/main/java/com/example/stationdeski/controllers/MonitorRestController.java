package com.example.stationdeski.controllers;

import com.example.stationdeski.entities.Moniteur;
import com.example.stationdeski.services.IMoniteurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/moniteur")
public class MonitorRestController {

    IMoniteurService moniteurService;
    @GetMapping("/retrieve-all-moniteurs")
    public List<Moniteur> getMoniteurs() {
        List<Moniteur> listMoniteurs = moniteurService.retrieveAllMoniteurs();
        return listMoniteurs;
    }

    @GetMapping("/retrieve-moniteur/{moniteur-id}")
    public Moniteur retrieveMoniteur(@PathVariable("moniteur-id") Integer idMoniteur) {
            return moniteurService.retrieveMoniteur(idMoniteur);
}

    @PostMapping("/add-moniteur")
    public Moniteur addMoniteur(@RequestBody Moniteur m) {
        Moniteur moniteur = moniteurService.addMoniteur(m);
        return moniteur;
    }
    @DeleteMapping("/remove-moniteur/{moniteur-id}")
    public void removeMoniteur(@PathVariable("moniteur-id") Integer idMoniteur) {
        moniteurService.deleteMoniteur(idMoniteur);
    }

    @PutMapping("/update-moniteur")
    public Moniteur updateMoniteur(@RequestBody Moniteur m) {
        Moniteur moniteur= moniteurService.updateMoniteur(m);
        return moniteur;
    }

    @PostMapping("/addMoniteurToCours")
    public Moniteur addMoniteurAndAssignToCours(@RequestBody Moniteur m){
        Moniteur moniteur=moniteurService.addMoniteurAndAssignToCours(m);
        return moniteur;
    }
}
