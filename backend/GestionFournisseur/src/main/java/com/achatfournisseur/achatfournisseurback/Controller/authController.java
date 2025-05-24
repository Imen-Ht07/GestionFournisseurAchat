package com.achatfournisseur.achatfournisseurback.Controller;

import com.achatfournisseur.achatfournisseurback.Entity.user;
import com.achatfournisseur.achatfournisseurback.Services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/auth")
public class authController {
    @Autowired
    private IUserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody user user) {
        return userService.registerUser(user);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody user user) {
        return userService.authenticateUser(user);
    }
}
