package com.assurance.assuranceback.Controller.UserController;

import com.assurance.assuranceback.Entity.UserEntity.Fournisseur;
import com.assurance.assuranceback.Services.UserServices.FournisseurService;
import com.assurance.assuranceback.Services.UserServices.IFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



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
