package com.example.kata.model;

import java.time.LocalDateTime;

public class AccountOperation {
    private OperationTypeEnum operationType;
    private LocalDateTime operationDateTime;
    private Double amount;

    public AccountOperation(OperationTypeEnum operationType, Double amount) {
        this.operationType = operationType;
        this.amount = amount;
        this.operationDateTime = LocalDateTime.now();
    }

    public OperationTypeEnum getOperationType() {
        return operationType;
    }

    public LocalDateTime getOperationDateTime() {
        return operationDateTime;
    }

    public Double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return operationType.name() + " " + amount + " at " + operationDateTime.toString();
    }
}
