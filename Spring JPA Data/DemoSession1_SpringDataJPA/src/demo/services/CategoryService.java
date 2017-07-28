package demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import demo.repositories.*;
import demo.entities.*;
import java.util.*;

@Service("categoryService")
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public Iterable<Category> findAll() {
		return categoryRepository.findAll();
	}
	
	public Category find(Integer id) {
		return categoryRepository.findOne(id);
	}
	// JPQL, HQL
	public void save(Category category) {
		categoryRepository.save(category);
	}
	
	public void delete(Integer id) {
		categoryRepository.delete(id);
	}
	
}
