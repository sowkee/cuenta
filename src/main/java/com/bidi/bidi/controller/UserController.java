package com.bidi.bidi.controller;

import com.bidi.bidi.entity.User;
import com.bidi.bidi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("{accountNumber}/{initialBalance}")
    public ResponseEntity<String> createUser(@RequestBody User user,
                                             @PathVariable String accountNumber,
                                             @PathVariable BigDecimal initialBalance) {
        try {
            userService.createUserWithAccount(user, accountNumber, initialBalance);
            return ResponseEntity.ok("Usuario creado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear el usuario: " + e.getMessage());
        }
    }
}

