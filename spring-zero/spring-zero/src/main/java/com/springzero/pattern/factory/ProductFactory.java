package com.springzero.pattern.factory;

public interface ProductFactory {
	
	public Product getCurrentProduct();
	
	public Product getProduct(final String type);
}
