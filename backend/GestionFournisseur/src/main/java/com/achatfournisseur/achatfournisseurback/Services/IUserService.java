package com.achatfournisseur.achatfournisseurback.Services;
import com.achatfournisseur.achatfournisseurback.Entity.user;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    ResponseEntity<?> registerUser(user user);
    ResponseEntity<?> authenticateUser(user user);
}
