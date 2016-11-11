package com.websystique.spring.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.websystique.spring.model.Product;

@Service("productService")
public class ProductServiceImpl implements ProductService{

	@Override
	@Cacheable("products")
	public Product getByName(String name) {
		showLookupOperation();
		return new Product(name, 100);
	}

	@CacheEvict(value="products", allEntries=true)
	public void refreshAllProducts(){
		//This method will remove all 'products' from cache, say as a result of flush API call.
	}
	
	public void showLookupOperation(){
		try {
			long time = 5000L;
			Thread.sleep(time);
		} catch (InterruptedException e) {
			throw new IllegalStateException();
		}
	}
}
