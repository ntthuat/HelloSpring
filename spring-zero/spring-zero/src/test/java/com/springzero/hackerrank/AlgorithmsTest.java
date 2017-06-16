package com.springzero.hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.springzero.hackerrank.Algorithms;

/**
 * Test lgorithms
 * 
 * @author Thuat T Nguyen
 * @version 06/13/2017
 */
public class AlgorithmsTest {

	private String workDir;
	
	@Before
	public void setUp(){
		String internalPath = this.getClass().getName().replace(".", File.separator);
		String externalPath = System.getProperty("user.dir")+File.separator+"src\\test\\java";
		String workDir = externalPath+File.separator+internalPath.substring(0, internalPath.lastIndexOf(File.separator));
		this.workDir = workDir;
	}
	
	@Test
	public void testAddValueFrom2ListToMap() throws FileNotFoundException {
		File file = new File(this.workDir + File.separator + "testCase1.txt");
		Map<Integer, Set> map = new HashMap<>();
		Scanner sc = new Scanner(file);
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		while (sc.hasNextInt()) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list1.add(x);
			list2.add(y);
		}
		while (list1.size()>0) {
			Algorithms.addValueFrom2ListToMap(map, list1, list2);
		}
		System.out.println(map);
	}
}
