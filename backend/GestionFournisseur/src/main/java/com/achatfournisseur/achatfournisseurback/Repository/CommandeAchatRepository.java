package com.achatfournisseur.achatfournisseurback.Repository;

import com.achatfournisseur.achatfournisseurback.Entity.CommandeAchat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeAchatRepository extends JpaRepository<CommandeAchat, Long> {
}
