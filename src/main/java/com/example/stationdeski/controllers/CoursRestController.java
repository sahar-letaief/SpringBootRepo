package com.example.stationdeski.controllers;


import com.example.stationdeski.entities.Abonnement;
import com.example.stationdeski.entities.Cours;
import com.example.stationdeski.entities.Inscription;
import com.example.stationdeski.services.ICoursService;
import com.example.stationdeski.services.IinscriptonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/cours")
@Tag(name="Cours management")
public class CoursRestController {
    ICoursService coursService;
    @GetMapping("/retrieve-all-cours")
    @Operation(description = "Retrive all courses")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Courses list found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Cours.class))})
    })
    public List<Cours> getCours() {
        List<Cours> listCours = coursService.retrieveAllCours();
        return listCours;
    }

    @GetMapping("/retrieve-cours/{cours-id}")
    @Operation(description = "Retrive one course by id")
    public Cours retrieveCours(@PathVariable("cours-id") Integer idCours) {
        return coursService.retrieveCours(idCours);
    }

    @PostMapping("/add-cours")
    @Operation(description = "Add course")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Course added",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Cours.class))}),
            @ApiResponse(responseCode = "404",description = "Check fields",content = @Content)
    })

    public Cours addCours(@RequestBody Cours c) {
        Cours cours = coursService.addCours(c);
        return cours;
    }
    @DeleteMapping("/remove-cours/{cours-id}")
    @Operation(description = "Remove one course by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Course deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Cours.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id",content = @Content),
            @ApiResponse(responseCode = "404",description = "Course not found",content = @Content)
    })
    public void removeCours(@PathVariable("cours-id") Integer idCours) {
        coursService.deleteCours(idCours);
    }

    @PutMapping("/update-cours")
    @Operation(description = "Update one course")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Course updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Cours.class))}),
            @ApiResponse(responseCode = "400", description = "Check fields",content = @Content),
            @ApiResponse(responseCode = "404",description = "Course not found",content = @Content)
    })
    public Cours updateCours(@RequestBody Cours c) {
        Cours cours= coursService.updateCours(c);
        return cours;
    }
}
