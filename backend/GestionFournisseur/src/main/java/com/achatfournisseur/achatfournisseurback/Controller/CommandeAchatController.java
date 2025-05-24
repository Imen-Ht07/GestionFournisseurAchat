package com.achatfournisseur.achatfournisseurback.Controller;
import com.achatfournisseur.achatfournisseurback.Entity.CommandeAchat;
import com.achatfournisseur.achatfournisseurback.Services.ICommandeAchatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/commandes")
public class CommandeAchatController {
    @Autowired
    ICommandeAchatService commandeAchatService;

    @GetMapping
    public List<CommandeAchat> getAllCommandes(@RequestParam(required = false) String search) {
        return commandeAchatService.retrieveallCommandes();
    }

    @GetMapping("/{id}")
    public CommandeAchat getCommandeById(@PathVariable Long id) {
        return commandeAchatService.retrieveCommandeById(id);
    }

    @PostMapping
    public CommandeAchat createCommande(@RequestBody CommandeAchat commandeAchat) {
        return commandeAchatService.addCommande(commandeAchat);
    }

    @PutMapping("/{id}")
    public CommandeAchat updateCommande(@PathVariable Long id, @RequestBody CommandeAchat updatedCommande) {
        return commandeAchatService.updateCommande(id, updatedCommande);
    }

    @DeleteMapping("/{id}")
    public void deleteCommande(@PathVariable Long id) {
        commandeAchatService.removeCommande(id);
    }

    @PutMapping("/{commandeId}/fournisseur/{fournisseurId}")
    public CommandeAchat affecterFournisseur(
            @PathVariable Long commandeId,
            @PathVariable Long fournisseurId) {
        return commandeAchatService.affecterFournisseurACommande(commandeId, fournisseurId);
    }
}
