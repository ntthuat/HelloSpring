package com.springzero.java8.repeatingannotations;

public class App {
	public static void main(String[] args) {
		PopRockSong song = new PopRockSong();
		Genre[] genres = song.getClass().getAnnotationsByType(Genre.class);

		for (Genre genre : genres) {
			System.out.println(genre.value());
		}
	}
}
