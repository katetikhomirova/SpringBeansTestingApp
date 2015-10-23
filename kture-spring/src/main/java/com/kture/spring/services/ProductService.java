package com.kture.spring.services;

import java.util.ArrayList;
import java.util.List;

import com.kture.spring.dao.StorageProductDAO;
import com.kture.spring.entity.Product;

public class ProductService extends AbstractService<StorageProductDAO> {

	public Product createProduct(Product product) {
		log.info("Create product " + product.toString());
		return dao.create(product);
	}

	public Product updateProduct(Product product) {
		log.info("Update product " + product.toString());
		return dao.update(product);
	}

	public Product getProductById(long id) {
		return dao.getById(id);
	}

	public List<Product> getProductsByTitle(String title) {
		return dao.getByTitle(title);
	}

	public List<Product> getProductsByUserId(long id) {
		return dao.getByUserId(id);
	}

	public boolean deleteProduct(long id) {
		log.info("Remove product with id=" + id);
		return dao.delete(id);
	}

	public List<Product> getProducts() {
		List<Product> res = new ArrayList<Product>();
		for (Product p : dao.getProducts().values())
			res.add(p);
		return res;
	}

}
