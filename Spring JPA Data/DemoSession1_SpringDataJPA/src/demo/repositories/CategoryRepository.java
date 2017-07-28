package demo.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import demo.entities.Category;
import demo.entities.Product;

import java.math.BigDecimal;
import java.util.*;

@Repository("categoryRepository")
public interface CategoryRepository 
	extends CrudRepository<Category, Integer> {

	
	
}
