package com.example.stationdeski.controllers;


import com.example.stationdeski.entities.Abonnement;
import com.example.stationdeski.entities.typeAbonnement;
import com.example.stationdeski.services.IAbonnementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Table;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/abonnement")
@Tag(name="Abonnement management")
public class AbonnementRestController {
    IAbonnementService abonnementService;
    @GetMapping("/retrieve-all-abonnements")
    @Operation(description = "Retrive all abonnements")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Abonnement list found",
            content = {@Content(mediaType = "application/json",
                        schema = @Schema(implementation = Abonnement.class))})
    })
    public List<Abonnement> getAbonnements() {
        List<Abonnement> listAbonnements = abonnementService.retrieveAllAbonnements();
        return listAbonnements;
    }

    @GetMapping("/retrieve-abonnement/{abonnement-id}")
    @Operation(description = "Retrive one abonnement by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Abonnement found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Abonnement.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id",content = @Content),
            @ApiResponse(responseCode = "404",description = "Abonnement not found",content = @Content)
    })
    public Abonnement retrieveAbonnement(@PathVariable("abonnement-id") Integer idAbonnement) {
        return abonnementService.retrieveAbonnement(idAbonnement);
    }

    @PostMapping("/add-abonnement")
    @Operation(description = "Add one abonnement")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Abonnement added",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Abonnement.class))}),
            @ApiResponse(responseCode = "404",description = "Check fields",content = @Content)
    })
    public Abonnement addAbonnement(@RequestBody Abonnement a) {
        Abonnement ab = abonnementService.addAbonnement(a);
        return ab;
    }
    @DeleteMapping("/remove-abonnement/{abonnement-id}")
    @Operation(description = "Remove one abonnement by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Abonnement deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Abonnement.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id",content = @Content),
            @ApiResponse(responseCode = "404",description = "Abonnement not found",content = @Content)
    })
    public void removeAbonnement(@PathVariable("abonnement-id") Integer idAbonnement) {
        abonnementService.deleteAbonnement(idAbonnement);
    }

    @PutMapping("/update-abonnement")
    @Operation(description = "Update abonnement")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Abonnement updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Abonnement.class))}),
            @ApiResponse(responseCode = "400", description = "Check fields",content = @Content),
            @ApiResponse(responseCode = "404",description = "Abonnement not found",content = @Content)
    })
    public Abonnement updateAbonnement(@RequestBody Abonnement a) {
        Abonnement ab= abonnementService.updateAbonnement(a);
        return ab;
    }
    @GetMapping("/getAbonnementByType/{type}")
    @Operation(description = "get Abonnement By Type")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Abonnement by type found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Abonnement.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid type",content = @Content),
            @ApiResponse(responseCode = "404",description = "Abonnement type not found",content = @Content)
    })
    public Set<Abonnement> getAbonnementByType(@PathVariable("type") typeAbonnement type){
        return abonnementService.getAbonnementByType(type);
    }
}
