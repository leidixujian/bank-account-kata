package com.example.kata;

import com.example.kata.model.Account;
import com.example.kata.model.OperationTypeEnum;
import com.example.kata.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class KataApplicationTests {

	@Autowired
	private AccountService accountService;

	@Test
	void givenAccountBalance10_depositAmount10_returnAccountBalance20 () {
		Account account = new Account(10);
		assertThat(accountService.deposit(account,10)).isEqualTo(20);
	}

	@Test
	void givenAccountBalance10_withdrawAmount10_returnAccountBalance0 (){
		Account account = new Account(10);
		assertThat(accountService.withdraw(account,10)).isEqualTo(0);
	}

	@Test
	void givenAccountBalance0_withdrawAmount10_throwIllegalArgsException (){
		Account account = new Account(0);
		assertThatThrownBy(() -> accountService.withdraw(account,10))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("Balance is not sufficient to withdraw");
	}

	@Test
	void givenAccountBalance0_depositAmount20_withdrawAmount10_inspectAccountOperationHistory_returnAllOperationsOfAccount() {
		Account account = new Account(10);
		accountService.deposit(account,20);
		accountService.withdraw(account,10);
		assertThat(account.getOperationHistory().size()).isEqualTo(2);
		assertThat(account.getOperationHistory().get(0).getAmount()).isEqualTo(20);
		assertThat(account.getOperationHistory().get(0).getOperationType()).isEqualTo(OperationTypeEnum.DEPOSIT);
		assertThat(account.getOperationHistory().get(0).getOperationDateTime()).isNotNull();
		assertThat(account.getOperationHistory().get(1).getAmount()).isEqualTo(10);
		assertThat(account.getOperationHistory().get(1).getOperationType()).isEqualTo(OperationTypeEnum.WITHDRAW);
		assertThat(account.getOperationHistory().get(1).getOperationDateTime()).isNotNull();
	}
}
