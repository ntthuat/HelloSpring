package demo.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import demo.entities.Account;
import demo.entities.Category;
import demo.entities.Product;

import java.math.BigDecimal;
import java.util.*;

@Repository("accountRepository")
public interface AccountRepository 
	extends CrudRepository<Account, String> {

	public List<Account> findByFullNameNQ(
		@Param("fullname") String fullname);
	
}
