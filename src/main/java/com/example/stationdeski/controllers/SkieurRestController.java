package com.example.stationdeski.controllers;

import com.example.stationdeski.entities.Piste;
import com.example.stationdeski.entities.Skieur;
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
}
