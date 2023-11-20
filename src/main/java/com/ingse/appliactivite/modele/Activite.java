package com.ingse.appliactivite.modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor  @NoArgsConstructor
@Data
public class Activite {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActivite;
    private Long idProjet;//id_projet
    private String libelle;
    private String nomActivite;
    private String description;//description
    private int tjm_ht; //tarif journalier moyen(TJM) HT //tjm_ht en miniscule
    private int tva;

}
   /* Le calcul du TJM freelance
        TJM freelance = (Salaire net annuel espéré -
        charges annuelles -
        impôt sur le revenu) /
        nombre de jours travaillés et facturés.*/