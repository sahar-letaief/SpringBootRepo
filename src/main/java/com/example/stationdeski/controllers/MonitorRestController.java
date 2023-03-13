package com.example.stationdeski.controllers;

import com.example.stationdeski.entities.Abonnement;
import com.example.stationdeski.entities.Moniteur;
import com.example.stationdeski.services.IMoniteurService;
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
@RequestMapping("/moniteur")
@Tag(name="Moniteur management")
public class MonitorRestController {

    IMoniteurService moniteurService;
    @GetMapping("/retrieve-all-moniteurs")
    @Operation(description = "Retrive All monitors")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Moniteur list found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Moniteur.class))})
    })
    public List<Moniteur> getMoniteurs() {
        List<Moniteur> listMoniteurs = moniteurService.retrieveAllMoniteurs();
        return listMoniteurs;
    }

    @GetMapping("/retrieve-moniteur/{moniteur-id}")
    @Operation(description = "Retrive one monitor by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Monitor found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Abonnement.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id",content = @Content),
            @ApiResponse(responseCode = "404",description = "Monitor not found",content = @Content)
    })
    public Moniteur retrieveMoniteur(@PathVariable("moniteur-id") Integer idMoniteur) {
            return moniteurService.retrieveMoniteur(idMoniteur);
}

    @PostMapping("/add-moniteur")
    @Operation(description = "Add monitor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Monitor added",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Abonnement.class))}),
            @ApiResponse(responseCode = "404",description = "Check fields",content = @Content)
    })
    public Moniteur addMoniteur(@RequestBody Moniteur m) {
        Moniteur moniteur = moniteurService.addMoniteur(m);
        return moniteur;
    }
    @DeleteMapping("/remove-moniteur/{moniteur-id}")
    @Operation(description = "Remove one monitor by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Monitor deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Moniteur.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id",content = @Content),
            @ApiResponse(responseCode = "404",description = "Monitor not found",content = @Content)
    })
    public void removeMoniteur(@PathVariable("moniteur-id") Integer idMoniteur) {
        moniteurService.deleteMoniteur(idMoniteur);
    }

    @PutMapping("/update-moniteur")
    @Operation(description = "Update one monitor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Monitor updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Moniteur.class))}),
            @ApiResponse(responseCode = "400", description = "Check fields",content = @Content),
            @ApiResponse(responseCode = "404",description = "Monitor not found",content = @Content)
    })
    public Moniteur updateMoniteur(@RequestBody Moniteur m) {
        Moniteur moniteur= moniteurService.updateMoniteur(m);
        return moniteur;
    }

    @PostMapping("/addMoniteurToCours")
    @Operation(description = "add Moniteur And Assign To Cours")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Monitor added and assigned to course",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Moniteur.class))}),
            @ApiResponse(responseCode = "404",description = "Check valid course",content = @Content)
    })
    public Moniteur addMoniteurAndAssignToCours(@RequestBody Moniteur m){
        Moniteur moniteur=moniteurService.addMoniteurAndAssignToCours(m);
        return moniteur;
    }
}
