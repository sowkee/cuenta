package com.bidi.bidi.service.impl;

import com.bidi.bidi.dto.response.MessageResponse;
import com.bidi.bidi.entity.Account;
import com.bidi.bidi.entity.User;
import com.bidi.bidi.repository.AccountRepository;
import com.bidi.bidi.repository.UserRepository;
import com.bidi.bidi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AccountRepository accountRepository;
    @Override
    public MessageResponse createUserWithAccount(User user, String accountNumber, BigDecimal initialBalance) {
        User savedUser = userRepository.save(user);

        // Crear la cuenta asociada al usuario
        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setBalance(initialBalance);
        account.setUser(savedUser);
        accountRepository.save(account);

        // Asignar la cuenta al usuario
        savedUser.setAccount(account);
        userRepository.save(savedUser);

        return new MessageResponse("ok");
    }
}
