package com.bidi.bidi.controller;

import com.bidi.bidi.entity.Transaction;
import com.bidi.bidi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping
    public ResponseEntity<String> createTransaction(@RequestBody Transaction transaction,
                                                    @RequestParam Long accountId) {
        try {
            transactionService.createTransaction(transaction.getAmount(), accountId);
            return ResponseEntity.ok("Transacción creada exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear la transacción: " + e.getMessage());
        }
    }


}
