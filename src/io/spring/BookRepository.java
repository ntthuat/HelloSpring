package io.spring;

public interface BookRepository {
	Book getByIsbn(String isbn);
	void refreshAllProducts();
}
