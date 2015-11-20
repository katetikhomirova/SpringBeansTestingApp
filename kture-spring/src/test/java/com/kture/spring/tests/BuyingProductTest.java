package com.kture.spring.tests;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kture.spring.facade.Market;
import com.kture.spring.utils.Printer;

public class BuyingProductTest {

	ApplicationContext appContext;
	Market market;

	public BuyingProductTest() {
		appContext = new ClassPathXmlApplicationContext(
				new String[] { "application-context.xml" });
		market = (Market) appContext.getBean("market");
	}

	@Test
	public void buyingProductTest() {
		System.out
				.println("\n--------------------\nTrying to buy own product:");
		try {
			market.buyProduct(1, 1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Printer.printUserAccounts(market.getUserAccounts());
		Printer.printProducts(market.getProducts());
		System.out
				.println("\n--------------------\nTrying to buy 1 product buy user id 3:");
		try {
			market.buyProduct(3, 1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out
				.println("\n--------------------\nTrying to buy 3 product buy user id 4:");
		try {
			market.buyProduct(4, 3);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Printer.printUserAccounts(market.getUserAccounts());
		Printer.printProducts(market.getProducts());
	}

}
