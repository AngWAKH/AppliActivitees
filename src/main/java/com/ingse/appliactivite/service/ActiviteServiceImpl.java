package com.ingse.appliactivite.service;

import com.ingse.appliactivite.modele.Activite;

import com.ingse.appliactivite.repository.ActiviteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ActiviteServiceImpl implements ActiviteService {

    private final ActiviteRepository activiteRepository;
    @Override
    public Activite creer(Activite activite) {
        return activiteRepository.save(activite) ;
    }

    @Override
    //@Transactional(readOnly= true)
    public List<Activite> lire() {
        return activiteRepository.findAll();
    }

    @Override
    public Optional<Activite> lireparidAct(Long idActivite) {
        return activiteRepository.findById(idActivite);
    }

    @Override
    public List<Activite> lireparLibelle(String libelle) {
        return activiteRepository.findActiviteByLibelle(libelle);
    }

    @Override
    public Activite modifier(Long idActivite, Activite activite) {
        return activiteRepository.findById(idActivite)
                .map(act -> {
                    act.setIdProjet(activite.getIdProjet());
                    act.setDescription(activite.getDescription());
                    act.setNomActivite(activite.getNomActivite());
                    act.setLibelle(activite.getLibelle());
                    act.setTjm_ht(activite.getTjm_ht());
                    act.setTva(activite.getTva());
                    return activiteRepository.save(act);
                } ).orElseThrow(()-> new RuntimeException("Activité non touvé !"));
    }

    @Override
    public String supprimer(Long idActivite) {
         activiteRepository.deleteById(idActivite);
         return "Activité supprimé";

    }
}
