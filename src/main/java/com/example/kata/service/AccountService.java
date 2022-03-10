package com.example.kata.service;

import com.example.kata.model.Account;
import com.example.kata.model.AccountOperation;
import com.example.kata.model.OperationTypeEnum;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    public double deposit(Account account, double amount) {
        account.setBalance(account.getBalance() + amount);
        account.addOperation(new AccountOperation(OperationTypeEnum.DEPOSIT, amount));
        System.out.println(account);
        return account.getBalance();
    }

    public double withdraw(Account account, double amount) {
        if (account.getBalance() < amount) {
            throw new IllegalArgumentException("Balance is not sufficient to withdraw");
        }
        account.setBalance(account.getBalance() - amount);
        account.addOperation(new AccountOperation(OperationTypeEnum.WITHDRAW, amount));
        System.out.println(account);
        return account.getBalance();
    }

    public void printOperationsHistory(Account account) {
        System.out.println("******** Print operations history of the account ********");
        account.getOperationHistory().forEach(System.out::println);
        System.out.println("******** End print ********");
    }
}
