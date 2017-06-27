package com.springzero.hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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
	public void testBigSorting1() throws FileNotFoundException {
		File file = new File(this.workDir + File.separator + "BigSortingTestCase1.txt");
		Scanner in = new Scanner(file);
		int n = in.nextInt();
		List<String> list = new ArrayList<>();
		String[] unsorted = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            list.add(in.next());
        }
        // your code goes here
        list.sort(new Comparator<String>() {
        	@Override
        	public int compare(String s1, String s2) {
        		if (s1.length() < s2.length()) return -1;
        		if (s1.length() > s2.length()) return 1;
        		for (int i = 0; i < s1.length(); i++)
                {
        			char c1 = s1.charAt(i);
        			char c2 = s2.charAt(i);
        			if (c1 < c2) return -1;
        			if (c1 > c2) return 1;
                }
        		return 0;
        	}
        });
        for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	@Test
	public void testInsertionSort2(){
		int[] array = {1, 4, 3, 5, 6, 2};
		Sorting.insertionSort2(array);
	}
	
	@Test
	public void testQuickSort(){
		int[] array = {0, -3, 6, 4, -10, 8, -5, 2, -7};
		Sorting.qsort(array,0,4);
		Sorting.printArray(array);
	}
}
