package com.kture.spring.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kture.spring.entity.User;
import com.kture.spring.facade.Market;
import com.kture.spring.utils.Printer;

public class UserServiceTest {

	List<User> tempUsers;
	ApplicationContext appContext;
	Market market;

	public UserServiceTest() {
		tempUsers = new ArrayList<User>();
		appContext = new ClassPathXmlApplicationContext(
				new String[] { "application-context.xml" });
		market = (Market) appContext.getBean("market");
	}

	@Test
	public void testUserService() {
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
		market.commit();
		System.out.println("\n--------------------\nRemoving user with id=2:");
		market.deleteUser(2);
		Printer.printUsers(market.getUsers());

		System.out.println("\n--------------------\nRemoving user with id=10:");
		market.deleteUser(10);
		Printer.printUsers(market.getUsers());
		market.commit();
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
		tempUsers.clear();

		System.out
				.println("\n--------------------\nGet users by email \"3@gmail.com\":");
		if (market.getUserByEmail("3@gmail.com") != null)
			tempUsers.add(market.getUserByEmail("3@gmail.com"));
		Printer.printUsers(tempUsers);
		// System.out.println("\n--------------------\nReverse changes:");
		try {
			market.reverse();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Printer.printUsers(market.getUsers());
	}

}
