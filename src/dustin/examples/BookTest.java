package dustin.examples;

import java.util.GregorianCalendar;

public class BookTest {

	public static void main(String[] args) {
		Book book = new Book.Builder("Effective Java", "Joshua Bloch")
		    .setPublishDate(new GregorianCalendar(2008, 05, 28)).build();
		
		System.out.println(book);
	}
}
