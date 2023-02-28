package com.example.stationdeski.controllers;


import com.example.stationdeski.entities.Cours;
import com.example.stationdeski.entities.Inscription;
import com.example.stationdeski.services.ICoursService;
import com.example.stationdeski.services.IinscriptonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/cours")
public class CoursRestController {
    ICoursService coursService;
    @GetMapping("/retrieve-all-cours")
    public List<Cours> getCours() {
        List<Cours> listCours = coursService.retrieveAllCours();
        return listCours;
    }

    @GetMapping("/retrieve-cours/{cours-id}")
    public Cours retrieveCours(@PathVariable("cours-id") Integer idCours) {
        return coursService.retrieveCours(idCours);
    }

    @PostMapping("/add-cours")
    public Cours addCours(@RequestBody Cours c) {
        Cours cours = coursService.addCours(c);
        return cours;
    }
    @DeleteMapping("/remove-cours/{cours-id}")
    public void removeCours(@PathVariable("cours-id") Integer idCours) {
        coursService.deleteCours(idCours);
    }

    @PutMapping("/update-cours")
    public Cours updateCours(@RequestBody Cours c) {
        Cours cours= coursService.updateCours(c);
        return cours;
    }
}
