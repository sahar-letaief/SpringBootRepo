package com.example.stationdeski.controllers;

import com.example.stationdeski.entities.Cours;
import com.example.stationdeski.entities.Piste;
import com.example.stationdeski.services.ICoursService;
import com.example.stationdeski.services.IPisteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/piste")
public class PisteRestController {
    IPisteService pisteService;
    @GetMapping("/retrieve-all-pistes")
    public List<Piste> getPistes() {
        List<Piste> listePiste = pisteService.retrieveAllPistes();
        return listePiste;
    }

    @GetMapping("/retrieve-piste/{piste-id}")
    public Piste retrievePiste(@PathVariable("piste-id") Integer idPiste) {
        return pisteService.retrievePiste(idPiste);
    }

    @PostMapping("/add-piste")
    public Piste addPiste(@RequestBody Piste p) {
        Piste piste = pisteService.addPiste(p);
        return piste;
    }

    @DeleteMapping("/remove-piste/{piste-id}")
    public void removePiste(@PathVariable("piste-id") Integer idPiste) {
        pisteService.deletePiste(idPiste);
    }

    @PutMapping("/update-piste")
    public Piste updatePiste(@RequestBody Piste p) {
        Piste piste= pisteService.updatePiste(p);
        return piste;
    }
}
