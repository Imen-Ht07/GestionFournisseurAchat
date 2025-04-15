package com.assurance.assuranceback.Services.UserServices;

import com.assurance.assuranceback.Entity.UserEntity.CommandeAchat;
import com.assurance.assuranceback.Entity.UserEntity.Fournisseur;
import com.assurance.assuranceback.Repository.UserRepositories.CommandeAchatRepository;
import com.assurance.assuranceback.Repository.UserRepositories.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommandeAchatService implements ICommandeAchatService {
@Autowired
    CommandeAchatRepository commandeAchatRepository;
    @Autowired
    private FournisseurRepository fournisseurRepository;
    @Override
    public List<CommandeAchat> retrieveallCommandes() {
        return commandeAchatRepository.findAll();
    }

    @Override
    public CommandeAchat retrieveCommandeById(long id) {
        return commandeAchatRepository.findById(id).orElse(null);

    }

    @Override
    public CommandeAchat addCommande(CommandeAchat commandeAchat) {
        return commandeAchatRepository.save(commandeAchat);
    }

    @Override
    public void removeCommande(long id) {
commandeAchatRepository.deleteById(id);
    }

    @Override
    public CommandeAchat updateCommande(Long id, CommandeAchat commandeAchat) {
        return null;
    }

    public CommandeAchat affecterFournisseurACommande(Long commandeId, Long fournisseurId) {
        CommandeAchat commande = commandeAchatRepository.findById(commandeId)
                .orElseThrow(() -> new RuntimeException("Commande non trouvée"));
        Fournisseur fournisseur = fournisseurRepository.findById(fournisseurId)
                .orElseThrow(() -> new RuntimeException("Fournisseur non trouvé"));
        commande.setFournisseur(fournisseur);
        return commandeAchatRepository.save(commande);
    }
}
