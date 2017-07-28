package demo.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import demo.entities.Category;
import demo.entities.Product;

@Repository("productRepository")
public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	@Query("select p from Product p where p.price > :price")
	public List<Product> condition1(
			@Param("price") BigDecimal price);

	@Query(value = "select * from product where price > :price", nativeQuery = true)
	public List<Product> condition3(
			@Param("price") BigDecimal price);
	
	@Query(value = "select * from product order by price desc limit :limit", nativeQuery = true)
	public List<Product> condition4(
			@Param("limit") int limit);
	
	@Query("select sum(quantity) from Product")
	public Long sum1();
	
	@Query("select sum(price * quantity) from Product")
	public BigDecimal sum2();
	
	// Query Methods
	public List<Product> findByName(String name);
	
	public List<Product> findByNameAndFeature(String name, boolean feature);
	
}
