package com.assurance.assuranceback.Entity.UserEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
