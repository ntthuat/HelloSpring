package demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import demo.repositories.*;
import demo.entities.*;

import java.math.BigDecimal;
import java.util.*;

@Service("productService")
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}
	
	public List<Product> condition1(BigDecimal price) {
		return productRepository.condition1(price);
	}
	
}
