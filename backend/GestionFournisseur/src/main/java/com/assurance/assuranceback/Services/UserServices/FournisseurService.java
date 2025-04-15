package com.assurance.assuranceback.Services.UserServices;

import com.assurance.assuranceback.Entity.UserEntity.Fournisseur;
import com.assurance.assuranceback.Repository.UserRepositories.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
        return null;
    }
}
