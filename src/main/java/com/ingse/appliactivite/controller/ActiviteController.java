package com.ingse.appliactivite.controller;

import com.ingse.appliactivite.modele.Activite;

import com.ingse.appliactivite.service.ActiviteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Api("/activite")
@RestController
@RequestMapping("/activite")
@AllArgsConstructor
public class ActiviteController {

    private final ActiviteService activiteService;

    @PostMapping("/ajouter")
    @ApiOperation(value = "Créer ou Ajouter une activité",notes = "Cette méthode permet d'enregistrer ou " +
            "d'ajouter une activité", response = Activite.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet activité crée / ajouté"),
            @ApiResponse(code =404, message = "Aucune Ajout n'a été effectuée dans la BBD"),
            @ApiResponse(code = 400, message = "L'objet activité n'est pas valide !")
    })
    public Activite ajouter(@RequestBody Activite activite){
        return activiteService.creer(activite);
    }
    /* ************************************************************************** */
    @GetMapping("/lire")
    @ApiOperation(value = "Renvoi la liste des Activités",notes = "Cette méthode permet de chercher et renvoyer " +
            "la liste des activités qui existent dans la BBD", responseContainer = "List<Activite>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des activités / une liste vide")
    })
    public List<Activite> lire(){
        return activiteService.lire();
    }
    /* ************************************************************************** */
    @GetMapping("/lireparlibelle/{libelle}")
    @ApiOperation(value = "Rechercher une activité par libellé",notes = "Cette méthode permet de chercher " +
            "une activité par son libellé", responseContainer = "List<Activite>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'activité à été trouvé dans BBD(ActiviteesDataBases)"),
            @ApiResponse(code =404, message = "Aucune activité n'existe dans la BBD avec l'IDLibelle fourni")
    })
    public List<Activite> lireparlibelle(@PathVariable String libelle, Activite activite){
        return activiteService.lireparLibelle(libelle);
    }
    /* ************************************************************************** */
    @GetMapping("/lireparidact/{idActivite}")
    @ApiOperation(value = "Rechercher une activité par son idActivite ",notes = "Cette méthode permet de chercher " +
            "une activité par son idActivite", responseContainer = "Optional<Activite>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'activité à été trouvé dans BBD(ActiviteesDataBases)"),
            @ApiResponse(code =404, message = "Aucune activité n'existe dans la BBD avec l'idActivite fourni")
    })
    public Optional<Activite> lireparidact(@PathVariable Long idActivite, Activite activite){
        return activiteService.lireparidAct(idActivite);
    }
    /* ************************************************************************** */
    @PutMapping("/modifier/{idActivite}")
    @ApiOperation(value = "Modifier une activité par son idActivite ",notes = "Cette méthode permet de modifier " +
            "une activité par son idActivite", response = Activite.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'activité à été modifié dans BBD"),
            @ApiResponse(code =404, message = "Aucune modification n'a été effectuée dans la BBD")
    })
    public Activite modifier(@PathVariable Long idActivite, @RequestBody Activite activite){
        return activiteService.modifier(idActivite,activite);
    }
    /* ************************************************************************** */
    @DeleteMapping("/supprimer/{idActivite}")
    @ApiOperation(value = "Supprimer une activité par son idActivite ",notes = "Cette méthode permet de " +
            "supprimer une activité par son idActivite", response = Activite.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'activité à été supprimé dans BBD"),
            @ApiResponse(code =404, message = "Aucune supprission n'a été effectuée dans la BBD")
    })
    public String supprimer(@PathVariable Long idActivite){
         activiteService.supprimer(idActivite);
         return "L'activité est bien supprimé";
    }
}
