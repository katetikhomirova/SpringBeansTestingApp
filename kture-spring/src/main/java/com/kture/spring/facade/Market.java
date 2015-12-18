package com.kture.spring.facade;

import java.io.IOException;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kture.spring.entity.Product;
import com.kture.spring.entity.Role;
import com.kture.spring.entity.User;
import com.kture.spring.entity.UserAccount;
import com.kture.spring.exceptions.InsufficientFundsException;
import com.kture.spring.exceptions.OwnProductByingException;
import com.kture.spring.services.*;

public class Market implements MarketFacade {

	private UserService userService;
	private ProductService productService;
	private UserAccountService userAccountService;
	private UserRoleService userRoleService;

	public UserAccountService getUserAccountService() {
		return userAccountService;
	}

	public void setUserAccountService(UserAccountService userAccountService) {
		this.userAccountService = userAccountService;
	}

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

	public UserRoleService getUserRoleService() {
		return userRoleService;
	}

	public void setUserRoleService(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}

	public Market(UserService u, ProductService p, UserAccountService a,
			UserRoleService uR) {
		userService = u;
		productService = p;
		userAccountService = a;
		userRoleService = uR;
	}

	public User createUser(User user) {
		User createdUser = userService.createUser(user);
		userRoleService.createUserRole(createdUser.getId(),
				createdUser.getUserName(), Role.USER);
		if (createdUser != null)
			userAccountService.createUserAccount(createdUser.getId());
		return createdUser;
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
		boolean wasAllRemoved = true;
		for (Product p : productService.getProductsByUserId(id)) {
			wasAllRemoved = productService.deleteProduct(p.getId());
		}
		return userAccountService.deleteUserAccount(id)
				&& userService.deleteUser(id) && wasAllRemoved;
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

	public void commit() {
		userService.commit();
		productService.commit();
	}

	public void reverse() throws IOException {
		userService.reverse();
		productService.reverse();
	}

	public List<UserAccount> getUserAccounts() {
		return userAccountService.getUserAccounts();
	}

	public UserAccount updateUserAccountFund(long userId, int fund)
			throws InsufficientFundsException {
		return userAccountService.updateUserAccountFund(userId, fund);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Throwable.class)
	public boolean buyProduct(long buyerId, long productId)
			throws InsufficientFundsException, OwnProductByingException {
		Product p = productService.getProductById(productId);
		if (p.getUserId() == buyerId)
			throw new OwnProductByingException("Can't buy own product!");
		if (userAccountService.getUserAccount(buyerId).getFund() < p.getPrice())
			throw new InsufficientFundsException("Insufficient funds!");
		UserAccount seller = userAccountService.updateUserAccountFund(
				p.getUserId(), p.getPrice());
		UserAccount buyer = userAccountService.updateUserAccountFund(buyerId,
				-p.getPrice());
		boolean flag = (seller != null) && (buyer != null)
				&& productService.deleteProduct(productId);
		return flag;
	}

	@Override
	public UserAccount getUserAccountByUserName(String username) {
		User u = userService.getUserByUsername(username);
		return userAccountService.getUserAccount(u.getId());
	}

	@Override
	public void updateFunds(String username, int delta) {
		User u = userService.getUserByUsername(username);
		try {
			userAccountService.updateUserAccountFund(u.getId(), delta);
		} catch (InsufficientFundsException e) {
			e.printStackTrace();
		}
	}
}
