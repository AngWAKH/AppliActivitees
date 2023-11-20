package com.ingse.appliactivite.service;

import com.ingse.appliactivite.modele.Activite;

import java.util.List;
import java.util.Optional;

public interface ActiviteService {

    Activite creer(Activite activite);

    List<Activite> lire();

    Optional<Activite> lireparidAct(Long id);

    List<Activite> lireparLibelle(String Libelle);

    Activite modifier(Long id, Activite activite);

    String supprimer(Long id);
}
