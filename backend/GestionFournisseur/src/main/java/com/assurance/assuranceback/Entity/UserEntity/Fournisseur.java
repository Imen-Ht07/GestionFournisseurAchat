package com.assurance.assuranceback.Entity.UserEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;


@Setter
@Getter
@Entity

public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @Column(nullable = false)
    private String contact;

    private String qualiteService;

    private Double note;

    @OneToMany(mappedBy = "fournisseur")
    @JsonIgnore
    private List<CommandeAchat> commandes;

    @OneToMany(mappedBy = "fournisseur", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<HistoriqueAchats> historiqueAchats;
}
