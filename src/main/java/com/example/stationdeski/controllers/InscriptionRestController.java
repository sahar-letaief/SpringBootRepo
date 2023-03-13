package com.example.stationdeski.controllers;

import com.example.stationdeski.entities.Abonnement;
import com.example.stationdeski.entities.Inscription;
import com.example.stationdeski.entities.Moniteur;
import com.example.stationdeski.services.IMoniteurService;
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
@RequestMapping("/inscription")
@Tag(name="Inscprition management")
public class InscriptionRestController {

    IinscriptonService inscriptonService;
    @GetMapping("/retrieve-all-inscriptions")
    @Operation(description = "Get All inscriptions")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Inscription list found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Inscription.class))})
    })
    public List<Inscription> getInscriptions() {
        List<Inscription> listInscription = inscriptonService.retrieveAllInscription();
        return listInscription;
    }

    @GetMapping("/retrieve-inscription/{inscription-id}")
    @Operation(description = "Retrive one inscription by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Inscription found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Inscription.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id",content = @Content),
            @ApiResponse(responseCode = "404",description = "inscription not found",content = @Content)
    })
    public Inscription retrieveInscriptions(@PathVariable("inscription-id") Integer idInscri) {
        return inscriptonService.retrieveInscription(idInscri);
    }

    @PostMapping("/add-inscription")
    @Operation(description = "Add inscription")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Inscription added",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Inscription.class))}),
            @ApiResponse(responseCode = "404",description = "Check fields",content = @Content)
    })

    public Inscription addInscription(@RequestBody Inscription i) {
        Inscription inscription = inscriptonService.addInscription(i);
        return inscription;
    }
    @DeleteMapping("/remove-inscription/{inscription-id}")
    @Operation(description = "Remove one inscription by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Inscription deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Inscription.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id",content = @Content),
            @ApiResponse(responseCode = "404",description = "Inscription not found",content = @Content)
    })
    public void removeInscription(@PathVariable("inscription-id") Integer idInscription) {
        inscriptonService.deleteInscription(idInscription);
    }

    @PutMapping("/update-inscription")
    @Operation(description = "Update inscprition")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Inscription updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Abonnement.class))}),
            @ApiResponse(responseCode = "400", description = "Check fields",content = @Content),
            @ApiResponse(responseCode = "404",description = "Inscription not found",content = @Content)
    })
    public Inscription updateInscription(@RequestBody Inscription i) {
        Inscription inscription= inscriptonService.updateInscription(i);
        return inscription;
    }
}
