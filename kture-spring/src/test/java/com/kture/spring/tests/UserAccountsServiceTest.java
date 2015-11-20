package com.kture.spring.tests;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kture.spring.exceptions.InsufficientFundsException;
import com.kture.spring.facade.Market;
import com.kture.spring.utils.Printer;

public class UserAccountsServiceTest {
	ApplicationContext appContext;
	Market market;

	public UserAccountsServiceTest() {
		appContext = new ClassPathXmlApplicationContext(
				new String[] { "application-context.xml" });
		market = (Market) appContext.getBean("market");
	}

	@Test
	public void userAccountServiceTest() {
		Printer.printUserAccounts(market.getUserAccounts());
		System.out
				.println("\n--------------------\nUpdating id 1 user account fund = 10 and id 3 user fund = 100:");
		try {
			market.updateUserAccountFund(1, 10);
			market.updateUserAccountFund(3, 100);
		} catch (InsufficientFundsException e) {
			System.out.println(e.getMessage());
		}
		Printer.printUserAccounts(market.getUserAccounts());
		System.out.println("\n--------------------\nTrying to set fund < 0:");
		try {
			market.updateUserAccountFund(1, -25);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
