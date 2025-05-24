package com.achatfournisseur.achatfournisseurback.Repository;


import com.achatfournisseur.achatfournisseurback.Entity.LigneCommandeAchat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneComRepository extends JpaRepository<LigneCommandeAchat, Long> {
}
