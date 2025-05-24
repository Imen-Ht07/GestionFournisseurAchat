package com.achatfournisseur.achatfournisseurback.Repository;

import com.achatfournisseur.achatfournisseurback.Entity.HistoriqueAchats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriqueAchatRepository extends JpaRepository<HistoriqueAchats, Long>  {
}
