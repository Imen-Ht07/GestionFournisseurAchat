package com.achatfournisseur.achatfournisseurback.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter

public class LigneCommandeAchat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String produit;
    private Integer quantite;
    private Double prixUnitaire;
    @ManyToOne
    @JoinColumn(name = "commande_id")
    private CommandeAchat commande;
}
