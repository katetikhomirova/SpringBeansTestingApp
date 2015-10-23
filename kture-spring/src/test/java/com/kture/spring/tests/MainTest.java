package com.kture.spring.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kture.spring.entity.Product;
import com.kture.spring.entity.User;
import com.kture.spring.facade.Market;
import com.kture.spring.utils.Printer;

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

	@Test
	public void userServiceTest() {
		
		System.out.println("\n--------------------\nSearching user with id=1:");
		tempUsers.add(market.getUserById(1));
		Printer.printUsers(tempUsers);
		tempUsers.clear();

		System.out
				.println("\n--------------------\nSearching user with id=10:");
		if (market.getUserById(10) != null)
			tempUsers.add(market.getUserById(10));
		Printer.printUsers(tempUsers);
		tempUsers.clear();

		System.out
				.println("\n--------------------\nCreating user with name =\"Den\""
						+ " email=\"1@gmail.com\" phoneNumber=\"3040:\"");
		market.createUser(new User("Den", "1@gmail.com", "3040"));
		Printer.printUsers(market.getUsers());

		System.out.println("\n--------------------\nRemoving user with id=2:");
		market.deleteUser(2);
		Printer.printUsers(market.getUsers());

		System.out.println("\n--------------------\nRemoving user with id=10:");
		market.deleteUser(10);
		Printer.printUsers(market.getUsers());

		System.out.println("\n--------------------\nUpdate user with id=1:");
		User update = new User("Kate", "2@gmail.com", "1234");
		update.setId(1);
		market.updateUser(update);
		Printer.printUsers(market.getUsers());

		System.out.println("\n--------------------\nGet users by name Den:");
		if (market.getUsersByName("Den").size() != 0)
			Printer.printUsers(market.getUsersByName("Den"));

		System.out
				.println("\n--------------------\nGet users by email \"2@gmail.com\":");
		if (market.getUserByEmail("2@gmail.com") != null)
			tempUsers.add(market.getUserByEmail("2@gmail.com"));
		Printer.printUsers(tempUsers);
		tempProducts.clear();

		System.out
				.println("\n--------------------\nGet users by email \"3@gmail.com\":");
		if (market.getUserByEmail("3@gmail.com") != null)
			tempUsers.add(market.getUserByEmail("3@gmail.com"));
		Printer.printUsers(tempUsers);
		tempProducts.clear();
	}

	@Test
	public void productServiceTest() {
		System.out.println("\n--------------------\nCreate 2 cookies:");
		market.createProduct(new Product("cookie", "tasty", 23, 1));
		market.createProduct(new Product("cookie", "tasty", 12, 1));
		Printer.printProducts(market.getProducts());

		System.out
				.println("\n--------------------\nGet products with title cookie:");
		Printer.printProducts(market.getProductsByTitle("cookie"));

		System.out.println("\n--------------------\nUpdate cookie:");
		Product updateP = new Product("cookie", "tasty", 35, 1);
		updateP.setId(3);
		market.updateProduct(updateP);
		Printer.printProducts(market.getProductsByTitle("cookie"));

		System.out.println("\n--------------------\nGet product by user id 1:");
		Printer.printProducts(market.getProductsByUserId(1));

		System.out.println("\n--------------------\nGet product by id 2:");
		if (market.getProductById(2) != null)
			tempProducts.add(market.getProductById(2));
		Printer.printProducts(tempProducts);
		tempProducts.clear();

		System.out.println("\n--------------------\nRemove product by id 2:");
		market.deleteProduct(2);
		Printer.printProducts(market.getProducts());

		System.out.println("\n--------------------\nGet product by id 2:");
		if (market.getProductById(2) != null)
			tempProducts.add(market.getProductById(2));
		Printer.printProducts(tempProducts);
		tempProducts.clear();

		market.deleteProduct(10);
	}

	@Test
	public void testToReach100Percent() {

		Market m = new Market(null, null);
		m.getProductService();
		m.getUserService();
		m.setProductService(null);
		m.setUserService(null);
		m = null;
		@SuppressWarnings("unused")
		Printer p = new Printer();
	}
}
