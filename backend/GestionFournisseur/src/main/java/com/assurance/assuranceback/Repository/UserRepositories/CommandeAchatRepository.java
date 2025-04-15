package com.assurance.assuranceback.Repository.UserRepositories;

import com.assurance.assuranceback.Entity.UserEntity.CommandeAchat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeAchatRepository extends JpaRepository<CommandeAchat, Long> {
}
