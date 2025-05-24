package com.achatfournisseur.achatfournisseurback.Repository;

import com.achatfournisseur.achatfournisseurback.Entity.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository extends JpaRepository <Fournisseur, Long> {
}
