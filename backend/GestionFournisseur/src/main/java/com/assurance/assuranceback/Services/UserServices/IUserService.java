package com.assurance.assuranceback.Services.UserServices;
import com.assurance.assuranceback.Entity.UserEntity.*;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    ResponseEntity<?> registerUser(user user);
    ResponseEntity<?> authenticateUser(user user);
}
