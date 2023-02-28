package com.example.stationdeski.controllers;

import com.example.stationdeski.entities.Inscription;
import com.example.stationdeski.entities.Moniteur;
import com.example.stationdeski.services.IMoniteurService;
import com.example.stationdeski.services.IinscriptonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/inscription")
public class InscriptionRestController {

    IinscriptonService inscriptonService;
    @GetMapping("/retrieve-all-inscriptions")
    public List<Inscription> getInscriptions() {
        List<Inscription> listInscription = inscriptonService.retrieveAllInscription();
        return listInscription;
    }

    @GetMapping("/retrieve-inscription/{inscription-id}")
    public Inscription retrieveInscriptions(@PathVariable("inscription-id") Integer idInscri) {
        return inscriptonService.retrieveInscription(idInscri);
    }

    @PostMapping("/add-inscription")
    public Inscription addInscription(@RequestBody Inscription i) {
        Inscription inscription = inscriptonService.addInscription(i);
        return inscription;
    }
    @DeleteMapping("/remove-inscription/{inscription-id}")
    public void removeInscription(@PathVariable("inscription-id") Integer idInscription) {
        inscriptonService.deleteInscription(idInscription);
    }

    @PutMapping("/update-inscription")
    public Inscription updateInscription(@RequestBody Inscription i) {
        Inscription inscription= inscriptonService.updateInscription(i);
        return inscription;
    }
}
