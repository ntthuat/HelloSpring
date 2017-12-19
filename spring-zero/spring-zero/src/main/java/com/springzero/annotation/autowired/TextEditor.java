package com.springzero.annotation.autowired;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 
 * @author thuat nguyen
 * @version 10/17/2017
 */
public class TextEditor {

	@Autowired
	private DriverManagerDataSource jdbcDataSource;
	
	public TextEditor() {
		System.out.println("Inside TextEditor constructor.");
	}

	@Autowired // Ví dụ 2 đặt autowired ở hàm property (cái này là theo name)
	private SpellChecker spellChecker;

	/*@Autowired*/ // Ví dụ 1 đặt autowired ở hàm set
	/*public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}*/

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	public void spellCheck() {
		spellChecker.checkSpelling();
	}
	
	public DriverManagerDataSource getDriverManagerDataSource() {
		return jdbcDataSource;
	}
}
