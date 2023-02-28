package com.example.stationdeski.controllers;


import com.example.stationdeski.entities.Abonnement;
import com.example.stationdeski.services.IAbonnementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/abonnement")
public class AbonnementRestController {
    IAbonnementService abonnementService;
    @GetMapping("/retrieve-all-abonnements")
    public List<Abonnement> getAbonnements() {
        List<Abonnement> listAbonnements = abonnementService.retrieveAllAbonnements();
        return listAbonnements;
    }

    @GetMapping("/retrieve-abonnement/{abonnement-id}")
    public Abonnement retrieveAbonnement(@PathVariable("abonnement-id") Integer idAbonnement) {
        return abonnementService.retrieveAbonnement(idAbonnement);
    }

    @PostMapping("/add-abonnement")
    public Abonnement addAbonnement(@RequestBody Abonnement a) {
        Abonnement ab = abonnementService.addAbonnement(a);
        return ab;
    }
    @DeleteMapping("/remove-abonnement/{abonnement-id}")
    public void removeAbonnement(@PathVariable("abonnement-id") Integer idAbonnement) {
        abonnementService.deleteAbonnement(idAbonnement);
    }

    @PutMapping("/update-moniteur")
    public Abonnement updateMoniteur(@RequestBody Abonnement a) {
        Abonnement ab= abonnementService.updateAbonnement(a);
        return ab;
    }
}
