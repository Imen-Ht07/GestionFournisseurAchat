package com.achatfournisseur.achatfournisseurback.Services;

import com.achatfournisseur.achatfournisseurback.Entity.LigneCommandeAchat;

import java.util.List;

public interface ILigneCommandeService {
    public List<LigneCommandeAchat> retrieveallLignes();
    public LigneCommandeAchat retrieveLigneById(long id);
    public LigneCommandeAchat addLigne(LigneCommandeAchat ligne);
    public void removeLigne(long id);
    public LigneCommandeAchat updateLigne(Long id, LigneCommandeAchat ligne);
}
