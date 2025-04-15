package com.assurance.assuranceback.Repository.UserRepositories;

import com.assurance.assuranceback.Entity.UserEntity.HistoriqueAchats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriqueAchatRepository extends JpaRepository<HistoriqueAchats, Long>  {
}
