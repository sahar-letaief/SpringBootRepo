package com.example.stationdeski.controllers;

import com.example.stationdeski.entities.Abonnement;
import com.example.stationdeski.entities.Piste;
import com.example.stationdeski.entities.Skieur;
import com.example.stationdeski.entities.typeAbonnement;
import com.example.stationdeski.services.IPisteService;
import com.example.stationdeski.services.ISkieurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/skieur")
public class SkieurRestController {
    ISkieurService skieurService;

    @GetMapping("/retrieve-all-skieurs")
    public List<Skieur> getSkieurs() {
        List<Skieur> listeSkieur = skieurService.retrieveAllSkieurs();
        return listeSkieur;
    }

    @GetMapping("/retrieve-skieur/{skieur-id}")
    public Skieur retrieveSkieur(@PathVariable("skieur-id") Integer idSkieur) {
        return skieurService.retrieveSkieur(idSkieur);
    }

    @PostMapping("/add-skieur")
    public Skieur addSkieur(@RequestBody Skieur s) {
        Skieur skieur = skieurService.addSkieur(s);
        return skieur;
    }

    @DeleteMapping("/remove-skieur/{piste-id}")
    public void removeSkieur(@PathVariable("skieur-id") Integer idSkieur) {
        skieurService.deleteSkieur(idSkieur);
    }

    @PutMapping("/update-skieur")
    public Skieur updateSkieur(@RequestBody Skieur s) {
        Skieur skieur= skieurService.updateSkieur(s);
        return skieur;
    }
    @PutMapping("/assignSkieurToPiste/{numSkieur}/{numPiste}")
    public Skieur assignSkieurToPiste(@PathVariable("numSkieur")Long numSkieur,
                                      @PathVariable("numPiste") Long numPiste)
    {
        Skieur s=skieurService.assignSkieurToPiste(numSkieur,numPiste);
        return s;
    }
    @PostMapping("/addSkieurAndAssignToCours/{numCours}")
    public Skieur addSkieurAndAssignToCours(@RequestBody Skieur skieur, @PathVariable("numCours") Long numCours){
        Skieur s=skieurService.addSkieurAndAssignToCours(skieur,numCours);
        return s;
    }
    @GetMapping("/retrieve-skieurs/{typeAbon}")
    public List<Skieur> retrieveSkieursByAbonnementType(@PathVariable("typeAbon") typeAbonnement typeAbon) {

        return skieurService.retrieveSkieursByAbonnementType(typeAbon);
    }
}
