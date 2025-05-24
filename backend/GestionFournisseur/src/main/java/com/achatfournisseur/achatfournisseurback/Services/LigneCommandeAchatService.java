package com.achatfournisseur.achatfournisseurback.Services;

import com.achatfournisseur.achatfournisseurback.Entity.LigneCommandeAchat;
import com.achatfournisseur.achatfournisseurback.Repository.LigneComRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigneCommandeAchatService implements ILigneCommandeService {
@Autowired
    LigneComRepository ligneComRepository;
    @Override
    public List<LigneCommandeAchat> retrieveallLignes() {
        return ligneComRepository.findAll();
    }

    @Override
    public LigneCommandeAchat retrieveLigneById(long id) {
        return ligneComRepository.findById(id).orElse(null);
    }

    @Override
    public LigneCommandeAchat addLigne(LigneCommandeAchat ligne) {
        return ligneComRepository.save(ligne);
    }
    @Override
    public void removeLigne(long id) {
ligneComRepository.deleteById(id);
    }

    @Override
    public LigneCommandeAchat updateLigne(Long id, LigneCommandeAchat ligne) {
        LigneCommandeAchat existingLigne = ligneComRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("LigneCommandeAchat non trouvée avec l'id : " + id));

        existingLigne.setProduit(ligne.getProduit());
        existingLigne.setQuantite(ligne.getQuantite());
        existingLigne.setPrixUnitaire(ligne.getPrixUnitaire());

        if (ligne.getCommande() != null) {
            existingLigne.setCommande(ligne.getCommande());
        }

        return ligneComRepository.save(existingLigne);
    }

}
