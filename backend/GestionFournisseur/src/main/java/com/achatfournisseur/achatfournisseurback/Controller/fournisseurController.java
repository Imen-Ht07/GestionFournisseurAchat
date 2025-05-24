package com.achatfournisseur.achatfournisseurback.Controller;
import com.achatfournisseur.achatfournisseurback.Entity.Fournisseur;
import com.achatfournisseur.achatfournisseurback.Services.IFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/fournisseurs")
@CrossOrigin(origins = "http://localhost:4200")
public class fournisseurController {
    @Autowired
    IFournisseurService fournisseurService;
    @GetMapping
    public List<Fournisseur> getAllFournisseurs(@RequestParam(required = false) String search) {
        return fournisseurService.retrieveallFournisseurs();
    }

    @GetMapping("/{id}")
    public Fournisseur getFournisseursById(@PathVariable Long id) {
        return fournisseurService.retrieveFournisseurById(id);
    }

    @PostMapping
    public Fournisseur createFournisseur(@RequestBody Fournisseur fournisseur) {
        return fournisseurService.addFournisseur(fournisseur);
    }

    @PutMapping("/{id}")
    public Fournisseur updateFournisseur(@PathVariable Long id, @RequestBody Fournisseur updatedFournisseur) {
        return fournisseurService.updateFournisseur(id, updatedFournisseur);
    }

    @DeleteMapping("/{id}")
    public void deleteFournisseur(@PathVariable Long id) {
        fournisseurService.removeFournisseur(id);
    }




}
