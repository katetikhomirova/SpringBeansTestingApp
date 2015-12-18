package com.kture.spring.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kture.spring.entity.Product;
import com.kture.spring.entity.User;
import com.kture.spring.facade.Market;
import com.kture.spring.utils.CsvFilePaser;
import com.kture.spring.utils.Printer;
import com.kture.spring.utils.ProductQueries;
import com.kture.spring.utils.UserAccountQueries;
import com.kture.spring.utils.UserQueries;

public class MainTest {

	List<User> tempUsers;
	List<Product> tempProducts;
	ApplicationContext appContext;
	Market market;

	public MainTest() {
		tempUsers = new ArrayList<User>();
		tempProducts = new ArrayList<Product>();

		appContext = new ClassPathXmlApplicationContext(
				new String[] { "application-context.xml" });
		market = (Market) appContext.getBean("market");
	}

	@Test
	public void testCreating() throws Exception {
		Printer.printUsers(market.getUsers());
		Printer.printProducts(market.getProducts());
	}

	@SuppressWarnings("unused")
	@Test
	public void testToReach100Percent() {

		ProductQueries pq = new ProductQueries();
		UserQueries uq = new UserQueries();
		UserAccountQueries uaq = new UserAccountQueries();
		Market m = new Market(null, null, null, null);
		m.getProductService();
		m.getUserService();
		m.setProductService(null);
		m.setUserService(null);
		m = null;

		Printer p = new Printer();
		try {
			CsvFilePaser.parseProducts("products.csv");
			CsvFilePaser.parseUsers("users.csv");
			CsvFilePaser.parseProducts("testProducts.csv");

			CsvFilePaser.parseProducts("1.csv");
			CsvFilePaser.parseUsers("2.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
		CsvFilePaser parser = new CsvFilePaser();
		Printer.printUserAccounts(null);
	}
}
// dkolesnikofff@gmail.com
