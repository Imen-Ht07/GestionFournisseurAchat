package com.achatfournisseur.achatfournisseurback.Services;

import com.achatfournisseur.achatfournisseurback.Entity.Fournisseur;

import java.util.List;

public interface IFournisseurService {
    public List<Fournisseur> retrieveallFournisseurs();
    public Fournisseur retrieveFournisseurById(long id);
    public Fournisseur addFournisseur(Fournisseur fournisseur);
    public void removeFournisseur(long id);
    public Fournisseur updateFournisseur(Long id, Fournisseur fournisseur);


}
