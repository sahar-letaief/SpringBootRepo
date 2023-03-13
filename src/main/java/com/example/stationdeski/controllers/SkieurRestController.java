package com.example.stationdeski.controllers;

import com.example.stationdeski.entities.Abonnement;
import com.example.stationdeski.entities.Piste;
import com.example.stationdeski.entities.Skieur;
import com.example.stationdeski.entities.typeAbonnement;
import com.example.stationdeski.services.IPisteService;
import com.example.stationdeski.services.ISkieurService;
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
@RequestMapping("/skieur")
@Tag(name="Skieur management")
public class SkieurRestController {
    ISkieurService skieurService;

    @GetMapping("/retrieve-all-skieurs")
    @Operation(description = "List all skieurs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Skieur list found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Skieur.class))})
    })
    public List<Skieur> getSkieurs() {
        List<Skieur> listeSkieur = skieurService.retrieveAllSkieurs();
        return listeSkieur;
    }

    @GetMapping("/retrieve-skieur/{skieur-id}")
    @Operation(description = "Retrieve skieur by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Skieur found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Skieur.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id",content = @Content),
            @ApiResponse(responseCode = "404",description = "Skieur not found",content = @Content)
    })
    public Skieur retrieveSkieur(@PathVariable("skieur-id") Integer idSkieur) {
        return skieurService.retrieveSkieur(idSkieur);
    }

    @PostMapping("/add-skieur")
    @Operation(description = "Add skieur")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Skieur added",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Skieur.class))}),
            @ApiResponse(responseCode = "404",description = "Check fields",content = @Content)
    })
    public Skieur addSkieur(@RequestBody Skieur s) {
        Skieur skieur = skieurService.addSkieur(s);
        return skieur;
    }

    @DeleteMapping("/remove-skieur/{skieur-id}")
    @Operation(description = "Remove skieur")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Skieur deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Skieur.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id",content = @Content),
            @ApiResponse(responseCode = "404",description = "Skieur not found",content = @Content)
    })
    public void removeSkieur(@PathVariable("skieur-id") Integer idSkieur) {
        skieurService.deleteSkieur(idSkieur);
    }

    @PutMapping("/update-skieur")
    @Operation(description = "Update one skieur")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Skieur updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Skieur.class))}),
            @ApiResponse(responseCode = "400", description = "Check fields",content = @Content),
            @ApiResponse(responseCode = "404",description = "Skieur not found",content = @Content)
    })
    public Skieur updateSkieur(@RequestBody Skieur s) {
        Skieur skieur= skieurService.updateSkieur(s);
        return skieur;
    }
    @PutMapping("/assignSkieurToPiste/{numSkieur}/{numPiste}")
    @Operation(description = "assign Skieur To Piste")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Assign Skieur To Piste successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Skieur.class))}),
            @ApiResponse(responseCode = "400", description = "Check fields",content = @Content),
            @ApiResponse(responseCode = "404",description = "Piste not found",content = @Content)
    })
    public Skieur assignSkieurToPiste(@PathVariable("numSkieur")Long numSkieur,
                                      @PathVariable("numPiste") Long numPiste)
    {
        Skieur s=skieurService.assignSkieurToPiste(numSkieur,numPiste);
        return s;
    }
    @PostMapping("/addSkieurAndAssignToCours/{numCours}")
    @Operation(description = "add Skieur And Assign To Cours")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "add Skieur And Assign To Cours successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Skieur.class))}),
            @ApiResponse(responseCode = "400", description = "Check fields",content = @Content),
            @ApiResponse(responseCode = "404",description = "Course not found",content = @Content)
    })
    public Skieur addSkieurAndAssignToCours(@RequestBody Skieur skieur, @PathVariable("numCours") Long numCours){
        Skieur s=skieurService.addSkieurAndAssignToCours(skieur,numCours);
        return s;
    }
    @GetMapping("/retrieve-skieurs/{typeAbon}")
    @Operation(description = "retrieve Skieurs ByAbonnement Type")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "retrieve Skieurs By Abonnement Type successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Skieur.class))}),
            @ApiResponse(responseCode = "400", description = "Check fields",content = @Content),
            @ApiResponse(responseCode = "404",description = "Abonnement type not found",content = @Content)
    })

    public List<Skieur> retrieveSkieursByAbonnementType(@PathVariable("typeAbon") typeAbonnement typeAbon) {

        return skieurService.retrieveSkieursByAbonnementType(typeAbon);
    }
}
