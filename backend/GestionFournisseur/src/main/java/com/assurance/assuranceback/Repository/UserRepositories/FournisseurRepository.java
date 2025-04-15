package com.assurance.assuranceback.Repository.UserRepositories;

import com.assurance.assuranceback.Entity.UserEntity.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository extends JpaRepository <Fournisseur, Long> {
}
