package com.achatfournisseur.achatfournisseurback.Repository;
import com.achatfournisseur.achatfournisseurback.Entity.user;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<user, Long> {

    Optional<user> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
