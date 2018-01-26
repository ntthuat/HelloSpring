package com.springzero.core.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class CompareTextTest {
	
	private String name1 = "T_ELEMENTS";
	private String name2 = "T_INTERVENANTS";
	
	private String workDir;
	
	private final String fileName1 = "columnname" + File.separator + name1 + ".txt";
	private final String fileName2 = "columnname" + File.separator + name2 + ".txt";
	
	@Before
	public void setUp(){
		String internalPath = this.getClass().getName().replace(".", File.separator);
		String externalPath = System.getProperty("user.dir")+File.separator+"src\\test\\java";
		String workDir = externalPath+File.separator+internalPath.substring(0, internalPath.lastIndexOf(File.separator));
		this.workDir = workDir;
	}
	
	@Test
	public void testCase() throws FileNotFoundException {
		name1 = "T_ELEMENTS";
		name2 = "T_INTERVENANTS";
		testCompare2File(name1, name2);
	}
	
	@Test
	public void testCase2() throws FileNotFoundException {
		name1 = "T_ELEMENTS";
		name2 = "G_INDIVIDU";
		testCompare2File(name1, name2);
	}
	
	public void testCompare2File(String name1, String name2) throws FileNotFoundException {
		File file1 = new File(this.workDir + File.separator + fileName1);
		File file2 = new File(this.workDir + File.separator + fileName2);
		Scanner scanner1 = new Scanner(file1);
		while (scanner1.hasNextLine()) {
			String line1 = scanner1.nextLine();
			Scanner scanner2 = new Scanner(file2);
			while (scanner2.hasNextLine()) {
				String line2 = scanner2.nextLine();
				if (line1.equals(line2)) {
					System.out.println(line1);
					break;
				}
			}
			scanner2.close();
		}
		
		scanner1.close();
	}
}
