package com.kture.spring.facade;

import java.util.List;

import com.kture.spring.entity.Product;
import com.kture.spring.entity.User;
import com.kture.spring.services.*;

public class Market implements MarketFacade {

	UserService userService;
	ProductService productService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public Market(UserService u, ProductService p) {
		userService = u;
		productService = p;
	}

	public User createUser(User user) {
		return userService.createUser(user);
	}

	public User updateUser(User user) {
		return userService.updateUser(user);
	}

	public User getUserById(long id) {
		return userService.getUserById(id);
	}

	public User getUserByEmail(String email) {
		return userService.getUserByEmail(email);
	}

	public List<User> getUsersByName(String name) {
		return userService.getUsersByName(name);
	}

	public boolean deleteUser(long id) {
		return userService.deleteUser(id);
	}

	public Product createProduct(Product product) {
		return productService.createProduct(product);
	}

	public Product updateProduct(Product product) {
		return productService.updateProduct(product);
	}

	public Product getProductById(long id) {
		return productService.getProductById(id);
	}

	public List<Product> getProductsByTitle(String title) {
		return productService.getProductsByTitle(title);
	}

	public List<Product> getProductsByUserId(long id) {
		return productService.getProductsByUserId(id);
	}

	public boolean deleteProduct(long id) {
		return productService.deleteProduct(id);
	}

	public List<User> getUsers() {
		return userService.getUsers();
	}

	public List<Product> getProducts() {
		return productService.getProducts();
	}

}
