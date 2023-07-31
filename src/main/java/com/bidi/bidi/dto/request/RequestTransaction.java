package com.bidi.bidi.dto.request;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class RequestTransaction {
    private BigDecimal amount;
    private Long accountId;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
