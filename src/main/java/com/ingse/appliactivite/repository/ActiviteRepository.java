package com.ingse.appliactivite.repository;

import com.ingse.appliactivite.modele.Activite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActiviteRepository extends JpaRepository<Activite,Long> {

    List<Activite> findActiviteByLibelle(String libelle);
}
