package com.bidi.bidi.service;

import com.bidi.bidi.dto.response.MessageResponse;
import com.bidi.bidi.entity.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface UserService {
    MessageResponse createUserWithAccount(User user, String accountNumber, BigDecimal initialBalance);
}
