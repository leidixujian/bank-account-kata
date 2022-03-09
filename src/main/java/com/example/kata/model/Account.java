package com.example.kata.model;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private double balance;
    private final List<AccountOperation> accountOperations;

    public Account(double balance) {
        this.balance = balance;
        this.accountOperations = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<AccountOperation> getOperationHistory() {
        return this.accountOperations;
    }

    public void addOperation(AccountOperation accountOperation) {
        this.accountOperations.add(accountOperation);
        System.out.println(accountOperation);
    }

    @Override
    public String toString() {
        return "current balance of account is " + balance;
    }
}
