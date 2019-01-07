package de.ngxa.restaurant.entity;

public enum ShopType {
	SHOP(1, "shop"), RESTAURANT(2, "restaurant");

	private final int id;
	private final String label;

	private ShopType(int id, String label) {
		this.id = id;
		this.label = label;
	}

	public int getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}
}
