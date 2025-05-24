package com.achatfournisseur.achatfournisseurback.Services;

import com.achatfournisseur.achatfournisseurback.Entity.CommandeAchat;
import com.achatfournisseur.achatfournisseurback.Entity.Fournisseur;
import com.achatfournisseur.achatfournisseurback.Repository.CommandeAchatRepository;
import com.achatfournisseur.achatfournisseurback.Repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        CommandeAchat existing = commandeAchatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commande introuvable avec id : " + id));

        existing.setDate(commandeAchat.getDate());
        existing.setMontant(commandeAchat.getMontant());
        existing.setStatut(commandeAchat.getStatut());

        // Assurez-vous que le fournisseur avec cet ID existe
        if (commandeAchat.getFournisseur() != null) {
            existing.setFournisseur(commandeAchat.getFournisseur());
        }

        return commandeAchatRepository.save(existing);
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
