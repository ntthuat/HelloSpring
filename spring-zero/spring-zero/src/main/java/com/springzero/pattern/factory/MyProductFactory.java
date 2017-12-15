package com.springzero.pattern.factory;

public class MyProductFactory implements ProductFactory{

	private String currentType = "Television";
	
	public Product getProduct(final String type) {
		if (type == null) {
			return null;
		}
		
		if (type.equalsIgnoreCase("Television")) {
			currentType = "Television";
			return new Television();
		} else if (type.equalsIgnoreCase("MPlayer")) {
			currentType = "MPlayer";
			return new MPlayer();
		}

		return null;
	}

	@Override
	public Product getCurrentProduct() {
		return getProduct(currentType);
	}
}
