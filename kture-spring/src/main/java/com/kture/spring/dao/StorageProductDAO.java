package com.kture.spring.dao;

import java.util.ArrayList;
import java.util.List;

import com.kture.spring.entity.Product;

public class StorageProductDAO extends AbstractDAO implements ProductDAO {

	public List<Product> getProducts() {
		List<Product> res = new ArrayList<Product>();
		for (String str : storage.getProducts().keySet()) {
			res.add((Product) storage.getProducts().get(str));
		}
		return res;
	}

	@Override
	public long generateId() {
		long max = 0;
		for (Product p : getProducts()) {
			if (p.getId() > max)
				max = p.getId();
		}
		max++;
		return max;
	}

	public Product create(Product item) {
		item.setId(generateId());
		storage.getProducts().put(String.valueOf(item.getId()), item);
		return item;
	}

	public Product getById(long id) {
		return (Product) storage.getProducts().get(String.valueOf(id));
	}

	public Product update(Product item) {
		if (item != null) {
			((Product) storage.getProducts().get(String.valueOf(item.getId())))
					.setDescription(item.getDescription());
			((Product) storage.getProducts().get(String.valueOf(item.getId())))
					.setPrice(item.getPrice());
			((Product) storage.getProducts().get(String.valueOf(item.getId())))
					.setTitle(item.getTitle());
			((Product) storage.getProducts().get(String.valueOf(item.getId())))
					.setUserId(item.getUserId());
		}
		return (Product) storage.getProducts()
				.get(String.valueOf(item.getId()));
	}

	public boolean delete(long id) {
		if (storage.getProducts().remove(String.valueOf(id)) != null)
			return true;
		return false;
	}

	public List<Product> getByUserId(long id) {
		List<Product> res = new ArrayList<Product>();
		for (Product p : getProducts()) {
			if (p.getUserId() == id)
				res.add(p);
		}
		return res;
	}

	public List<Product> getByTitle(String title) {
		List<Product> res = new ArrayList<Product>();
		for (Product p : getProducts()) {
			if (p.getTitle().equals(title))
				res.add(p);
		}
		return res;
	}
}
