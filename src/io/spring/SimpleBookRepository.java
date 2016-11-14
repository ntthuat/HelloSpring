package io.spring;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class SimpleBookRepository implements BookRepository{

	@Override
	@Cacheable("books")
	public Book getByIsbn(String isbn) {
		simulateSlowService();
        return new Book(isbn, "Some book");
	}
	
	@Override
	@CacheEvict(value="books", allEntries=true)
	public void refreshAllProducts(){
		//This method will remove all 'products' from cache, say as a result of flush API call.
	}
	
	private void simulateSlowService(){
		try {
			long time = 3000L;
			Thread.sleep(time);
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}
}
