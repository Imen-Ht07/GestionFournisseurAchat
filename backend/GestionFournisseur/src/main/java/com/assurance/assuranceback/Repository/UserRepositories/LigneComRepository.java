package com.assurance.assuranceback.Repository.UserRepositories;


import com.assurance.assuranceback.Entity.UserEntity.CommandeAchat;
import com.assurance.assuranceback.Entity.UserEntity.LigneCommandeAchat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneComRepository extends JpaRepository<LigneCommandeAchat, Long> {
}
