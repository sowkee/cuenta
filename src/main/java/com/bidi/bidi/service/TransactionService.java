package com.bidi.bidi.service;

import com.bidi.bidi.dto.response.MessageResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface TransactionService {
    MessageResponse createTransaction(BigDecimal amount, Long accountId);
}
