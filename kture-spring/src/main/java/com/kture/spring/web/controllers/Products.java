package com.kture.spring.web.controllers;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kture.spring.entity.Product;
import com.kture.spring.entity.UserAccount;
import com.kture.spring.exceptions.InsufficientFundsException;
import com.kture.spring.exceptions.OwnProductByingException;
import com.kture.spring.market.MarketFactory;

@Controller
public class Products {

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String getProducts(Model model) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			model.addAttribute("products", MarketFactory.getMarket()
					.getProducts());
			makeProductView(auth, model);
		}
		return "products";
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public String addProduct(Model model) {
		return "addProduct";
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String createProduct(@RequestParam String title,
			@RequestParam String price, @RequestParam String description,
			Model model) {
		Product product = new Product();
		product.setTitle(title);
		product.setDescription(description);
		product.setPrice(Integer.parseInt(price));
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			UserAccount u = MarketFactory.getMarket().getUserAccountByUserName(
					userDetail.getUsername());
			product.setUserId(u.getUserId());
		}
		MarketFactory.getMarket().createProduct(product);
		makeProductView(auth, model);
		return "products";
	}

	@RequestMapping(value = "/buyProduct/{id}", method = RequestMethod.POST)
	public String buyProduct(@PathVariable String id, Model model) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			UserAccount u = MarketFactory.getMarket().getUserAccountByUserName(
					userDetail.getUsername());
			try {
				MarketFactory.getMarket().buyProduct(u.getUserId(),
						Integer.parseInt(id));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (InsufficientFundsException e) {
				e.printStackTrace();
			} catch (OwnProductByingException e) {
				e.printStackTrace();
			} catch (Exception e) {

			}
		}
		makeProductView(auth, model);
		return "products";
	}

	private void makeProductView(Authentication auth, Model model) {
		model.addAttribute("products", MarketFactory.getMarket().getProducts());
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		UserAccount u = MarketFactory.getMarket().getUserAccountByUserName(
				userDetail.getUsername());
		model.addAttribute("userAccount", u);
	}

}