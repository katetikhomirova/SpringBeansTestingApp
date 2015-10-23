package com.kture.spring.entity;

public class Product {

	private long id;
	private String title;
	private String description;
	private int price;
	private long userId;

	public Product(String title, String description, int price, int userId) {
		this.title = title;
		this.description = description;
		this.price = price;
		this.userId = userId;
	}

	public Product(String productString) {
		productString = productString.replaceAll("[\\{\\}]", "");
		String[] fields = productString.split(",");
		for (String str : fields) {
			String[] field = str.split(":");
			setField(field[0], field[1]);
		}
	}

	private void setField(String fieldId, String fieldValue)
			throws NumberFormatException {
		if (fieldId.equals("id"))
			this.id = Long.parseLong(fieldValue);
		else if (fieldId.equals("title"))
			this.title = fieldValue;
		else if (fieldId.equals("description"))
			this.description = fieldValue;
		else if (fieldId.equals("price"))
			this.price = Integer.parseInt(fieldValue);
		else if (fieldId.equals("userId"))
			this.userId = Long.parseLong(fieldValue);
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "{id:" + id + ",title:" + title + ",description:" + description
				+ ",price:" + price + ",userId:" + userId + "}";
	}
}
