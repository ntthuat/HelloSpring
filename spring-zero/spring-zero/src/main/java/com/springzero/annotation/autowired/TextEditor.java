package com.springzero.annotation.autowired;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author thuat nguyen
 * @version 10/17/2017
 */
public class TextEditor {

	@Autowired
	private DataSource jdbcDataSource;
	
	public TextEditor() {
		System.out.println("Inside TextEditor constructor.");
	}

	@Autowired // Ví dụ 2 đặt autowired ở hàm property
	private SpellChecker spellChecker;

	/*@Autowired*/ // Ví dụ 1 đặt autowired ở hàm set
	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	public void spellCheck() {
		spellChecker.checkSpelling();
	}
}
