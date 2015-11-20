package com.kture.spring.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.kture.spring.entity.Product;
import com.kture.spring.entity.User;
import com.kture.spring.services.ProductService;

public class CsvFilePaser {

	public static HashMap<String, User> parseUsers(String filePath)
			throws IOException {
		Resource rsrc = new ClassPathResource(filePath);
		HashMap<String, User> result = new HashMap<String, User>();
		BufferedReader br = null;
		String line = "";
		try {
			br = new BufferedReader(new FileReader(rsrc.getFile()
					.getAbsoluteFile()));
			while ((line = br.readLine()) != null) {
				String[] user = line.split(",");
				User u = new User(user[1], user[2], user[3]);
				u.setId(Long.parseLong(user[0]));
				result.put("user:" + user[0], u);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		if (br != null)
			br.close();
		return result;
	}

	public static HashMap<String, Product> parseProducts(String filePath)
			throws IOException {
		Resource rsrc = new ClassPathResource(filePath);
		HashMap<String, Product> result = new HashMap<String, Product>();
		BufferedReader br = null;
		String line = "";
		try {
			br = new BufferedReader(new FileReader(rsrc.getFile()
					.getAbsolutePath()));
			while ((line = br.readLine()) != null) {
				String[] product = line.split(",");
				try {
					Product p = new Product(product[1], product[2],
							Integer.parseInt(product[3]),
							Integer.parseInt(product[4]));
					p.setId(Long.parseLong(product[0]));
					result.put("product:" + product[0], p);
				} catch (NumberFormatException ex) {
					ProductService.log
							.error("Error in parsing integer value product with id = "
									+ product[0]);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		if (br != null)
			br.close();
		return result;
	}

}
