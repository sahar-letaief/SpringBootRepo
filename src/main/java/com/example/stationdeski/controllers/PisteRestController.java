package com.example.stationdeski.controllers;

import com.example.stationdeski.entities.Abonnement;
import com.example.stationdeski.entities.Cours;
import com.example.stationdeski.entities.Piste;
import com.example.stationdeski.services.ICoursService;
import com.example.stationdeski.services.IPisteService;
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
@RequestMapping("/piste")
@Tag(name="Psite management")
public class PisteRestController {
    IPisteService pisteService;
    @GetMapping("/retrieve-all-pistes")
    @Operation(description = "List all pistes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Piste list found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Piste.class))})
    })
    public List<Piste> getPistes() {
        List<Piste> listePiste = pisteService.retrieveAllPistes();
        return listePiste;
    }

    @GetMapping("/retrieve-piste/{piste-id}")
    @Operation(description = "Retrive one piste by id")
    public Piste retrievePiste(@PathVariable("piste-id") Integer idPiste) {
        return pisteService.retrievePiste(idPiste);
    }

    @PostMapping("/add-piste")
    @Operation(description = "Add piste ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Piste found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Abonnement.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id",content = @Content),
            @ApiResponse(responseCode = "404",description = "Piste not found",content = @Content)
    })
    public Piste addPiste(@RequestBody Piste p) {
        Piste piste = pisteService.addPiste(p);
        return piste;
    }

    @DeleteMapping("/remove-piste/{piste-id}")
    @Operation(description = "Remove one piste by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Piste deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Piste.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id",content = @Content),
            @ApiResponse(responseCode = "404",description = "Piste not found",content = @Content)
    })
    public void removePiste(@PathVariable("piste-id") Integer idPiste) {
        pisteService.deletePiste(idPiste);
    }

    @PutMapping("/update-piste")
    @Operation(description = "Update piste ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Piste updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Abonnement.class))}),
            @ApiResponse(responseCode = "400", description = "Check fields",content = @Content),
            @ApiResponse(responseCode = "404",description = "Piste not found",content = @Content)
    })
    public Piste updatePiste(@RequestBody Piste p) {
        Piste piste= pisteService.updatePiste(p);
        return piste;
    }
}
