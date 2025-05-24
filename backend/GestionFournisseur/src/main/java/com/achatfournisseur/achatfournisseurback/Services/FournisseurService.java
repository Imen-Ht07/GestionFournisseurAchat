package com.achatfournisseur.achatfournisseurback.Services;

import com.achatfournisseur.achatfournisseurback.Entity.Fournisseur;
import com.achatfournisseur.achatfournisseurback.Repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurService implements IFournisseurService {

   @Autowired
   FournisseurRepository fournisseurRepository;

    @Override
    public List<Fournisseur> retrieveallFournisseurs() {
        return fournisseurRepository.findAll();
    }

    @Override
    public Fournisseur retrieveFournisseurById(long id) {
        return fournisseurRepository.findById(id).orElse(null);
    }

    @Override
    public Fournisseur addFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public void removeFournisseur(long id) {
fournisseurRepository.deleteById(id);
    }

    @Override
    public Fournisseur updateFournisseur(Long id, Fournisseur fournisseur) {
        Fournisseur existing = fournisseurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fournisseur non trouvé avec id : " + id));

        existing.setNom(fournisseur.getNom());
        existing.setContact(fournisseur.getContact());
        existing.setQualiteService(fournisseur.getQualiteService());
        existing.setNote(fournisseur.getNote());

        return fournisseurRepository.save(existing);
    }

}
