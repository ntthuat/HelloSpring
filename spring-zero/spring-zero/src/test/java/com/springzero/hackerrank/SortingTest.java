package com.springzero.hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

/**
 * Test SortingTest
 * 
 * @author Thuat T Nguyen
 * @version 06/23/2017
 */
public class SortingTest {

	private String workDir;

	@Before
	public void setUp() {
		String internalPath = this.getClass().getName().replace(".", File.separator);
		String externalPath = System.getProperty("user.dir") + File.separator + "src\\test\\java";
		String workDir = externalPath + File.separator
				+ internalPath.substring(0, internalPath.lastIndexOf(File.separator));
		this.workDir = workDir;
	}

	@Test
	public void testBigSorting() throws FileNotFoundException {
		File file = new File(this.workDir + File.separator + "BigSortingTestCase1.txt");
		Scanner in = new Scanner(file);
		int n = in.nextInt();
		String[] unsorted = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            unsorted[unsorted_i] = in.next();
        }
        // your code goes here
        Sorting.bubbleSort(unsorted);
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            System.out.println(unsorted[unsorted_i]);
        }
	}
}
