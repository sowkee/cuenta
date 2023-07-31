package com.bidi.bidi.controller;

import com.bidi.bidi.entity.Account;
import com.bidi.bidi.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        return optionalAccount.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
