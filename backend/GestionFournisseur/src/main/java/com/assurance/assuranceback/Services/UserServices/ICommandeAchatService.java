package com.assurance.assuranceback.Services.UserServices;

import com.assurance.assuranceback.Entity.UserEntity.CommandeAchat;
import com.assurance.assuranceback.Entity.UserEntity.Fournisseur;

import java.util.List;

public interface ICommandeAchatService {
    public List<CommandeAchat> retrieveallCommandes();
    public CommandeAchat retrieveCommandeById(long id);
    public CommandeAchat addCommande(CommandeAchat commandeAchat);
    public void removeCommande(long id);
    public CommandeAchat updateCommande(Long id, CommandeAchat commandeAchat);
    public CommandeAchat affecterFournisseurACommande(Long commandeId, Long fournisseurId);
}
