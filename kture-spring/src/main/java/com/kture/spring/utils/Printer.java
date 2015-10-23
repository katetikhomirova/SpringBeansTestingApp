package com.kture.spring.utils;

import java.util.List;

import com.kture.spring.entity.Product;
import com.kture.spring.entity.User;

public class Printer {

	public static void printUsers(List<User> users) {
		if (users != null && users.size() > 0) {
			System.out.println("Users:\nid\tname\temail\t\tphoneNumber\t");
			System.out.println("___________________________________________");
			for (User u : users) {
				if (u != null)
					System.out
							.println(u.getId() + " \t" + u.getName() + " \t"
									+ u.getEmail() + " \t" + u.getPhoneNumber()
									+ " \t");
			}
		} else
			System.out.println("No users found!");
	}

	public static void printProducts(List<Product> products) {
		if (products != null && products.size() > 0) {
			System.out.println("Products:\nid\ttitle\tdescr\tprice\tuser ID");
			System.out
					.println("______________________________________________");
			for (Product p : products) {
				if (p != null)
					System.out.println(p.getId() + "\t" + p.getTitle() + "\t"
							+ p.getDescription() + "\t" + p.getPrice() + "\t"
							+ p.getUserId() + "\t");
			}
		} else
			System.out.println("No products found!");
	}
}
