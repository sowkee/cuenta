package com.bidi.bidi.service.impl;

import com.bidi.bidi.dto.response.MessageResponse;
import com.bidi.bidi.entity.Account;
import com.bidi.bidi.entity.Transaction;
import com.bidi.bidi.repository.AccountRepository;
import com.bidi.bidi.repository.TransactionRepository;
import com.bidi.bidi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TransactionImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    AccountRepository accountRepository;
    @Transactional
    @Override
    public MessageResponse createTransaction(BigDecimal amount, Long accountId) {
        Optional<Account> optionalAccount = accountRepository.findById(accountId);

        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();

            // Crear la transacción
            Transaction transaction = new Transaction();
            transaction.setAmount(amount);
            transaction.setTransactionDate(LocalDateTime.now());
            transaction.setAccount(account);
            transactionRepository.save(transaction);
        } else {
            throw new RuntimeException("No se encontró la cuenta con el ID proporcionado.");
        }
        return new MessageResponse("Ok");
    }
}
