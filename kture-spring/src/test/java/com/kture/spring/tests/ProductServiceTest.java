package com.kture.spring.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kture.spring.entity.Product;
import com.kture.spring.facade.Market;
import com.kture.spring.utils.Printer;

public class ProductServiceTest {

	List<Product> tempProducts;
	ApplicationContext appContext;
	Market market;

	public ProductServiceTest() {
		tempProducts = new ArrayList<Product>();

		appContext = new ClassPathXmlApplicationContext(
				new String[] { "application-context.xml" });
		market = (Market) appContext.getBean("market");
	}

	@Test
	public void testProductService() {
		System.out.println("\n--------------------\nCreate 2 cookies:");
		market.createProduct(new Product("cookie", "tasty", 23, 1));
		market.createProduct(new Product("cookie", "tasty", 12, 1));
		market.commit();
		Printer.printProducts(market.getProducts());

		System.out
				.println("\n--------------------\nGet products with title cookie:");
		Printer.printProducts(market.getProductsByTitle("cookie"));

		System.out.println("\n--------------------\nUpdate cookie:");
		Product updateP = new Product("cookie", "tasty", 35, 1);
		updateP.setId(3);
		market.updateProduct(updateP);
		Printer.printProducts(market.getProducts());

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

}
