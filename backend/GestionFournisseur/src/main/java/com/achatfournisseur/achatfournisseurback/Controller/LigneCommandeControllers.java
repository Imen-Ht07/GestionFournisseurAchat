package com.achatfournisseur.achatfournisseurback.Controller;

import com.achatfournisseur.achatfournisseurback.Entity.LigneCommandeAchat;
import com.achatfournisseur.achatfournisseurback.Services.LigneCommandeAchatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/ligneCommande")
@CrossOrigin(origins = "http://localhost:4200")
public class LigneCommandeControllers {
    @Autowired
    LigneCommandeAchatService ligneCommandeAchatService;
    @GetMapping
    public List<LigneCommandeAchat> getAllLignes(@RequestParam(required = false) String search) {
        return ligneCommandeAchatService.retrieveallLignes();
    }

    @GetMapping("/{id}")
    public LigneCommandeAchat getLigneById(@PathVariable Long id) {
        return ligneCommandeAchatService.retrieveLigneById(id);
    }

    @PostMapping
    public LigneCommandeAchat createLigne(@RequestBody LigneCommandeAchat ligneCommandeAchat) {
        return ligneCommandeAchatService.addLigne(ligneCommandeAchat);
    }

    @PutMapping("/{id}")
    public LigneCommandeAchat updateLigne(@PathVariable Long id, @RequestBody LigneCommandeAchat updatedLigne) {
        return ligneCommandeAchatService.updateLigne(id, updatedLigne);
    }

    @DeleteMapping("/{id}")
    public void deleteLigne(@PathVariable Long id) {
        ligneCommandeAchatService.removeLigne(id);
    }



}
