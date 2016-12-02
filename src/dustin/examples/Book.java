package dustin.examples;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Book {

	public enum Genre {
		FICTION, NONFICTION, TECHNOLOGY, SELFHELP, BUSINESS, SPORT
	};

	private String title;
	private String author;
	private Genre genre;
	private GregorianCalendar publishDate;
	private String ISBN;

	public static class Builder {

		// required params
		private String title;
		private String author;
		// optional params
		private Genre genre = Genre.FICTION;
		private GregorianCalendar publishDate = new GregorianCalendar(1900, 1, 1);
		private String ISBN = "000000000";

		public Builder(String title, String author) {
			this.title = title;
			this.author = author;
		}

		public Builder setGenre(Genre val) {
			this.genre = val;
			return this;
		}

		public Builder setPublishDate(GregorianCalendar val) {
			this.publishDate = val;
			return this;
		}

		public Builder setISBN(String val) {
			this.ISBN = val;
			return this;
		}

		public Book build() {
			return new Book(this);
		}
	}

	public Book(Builder builder) {
		title = builder.title;
		author = builder.author;
		genre = builder.genre;
		publishDate = builder.publishDate;
		ISBN = builder.ISBN;
	}

	@Override
	public String toString() {
		return "Title: " + title + ", author: " + author + ", genre: " + genre.toString() + ", publish year: "
		        + publishDate.get(Calendar.YEAR) + ", ISBN: " + ISBN;
	}

}
