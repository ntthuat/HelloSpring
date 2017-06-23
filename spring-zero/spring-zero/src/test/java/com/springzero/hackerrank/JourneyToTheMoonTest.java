package com.springzero.hackerrank;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

/**
 * TestJourneyToTheMoon
 * 
 * @author Thuat T Nguyen
 * @version 06/23/2017
 */
public class JourneyToTheMoonTest {
	
	private String workDir;
	
	@Before
	public void setUp(){
		String internalPath = this.getClass().getName().replace(".", File.separator);
		String externalPath = System.getProperty("user.dir")+File.separator+"src\\test\\java";
		String workDir = externalPath+File.separator+internalPath.substring(0, internalPath.lastIndexOf(File.separator));
		this.workDir = workDir;
	}
	
	/**
	 * Test phép tính giai thừa
	 */
	@Test
	public void testFactorial(){
		long number = 5;
		assertEquals(120, JourneyToTheMoon.factorial(number));
		number = 1;
		assertEquals(1, JourneyToTheMoon.factorial(number));
		number = 0;
		assertEquals(1, JourneyToTheMoon.factorial(number));
		number = -2;
		assertEquals(1, JourneyToTheMoon.factorial(number));
		number = 10; //3628800
		assertEquals(3628800, JourneyToTheMoon.factorial(number));
	}
	
	/**
	 * Test phép tính giai thừa
	 */
	@Test
	public void testCombination(){
		long n = 3, k =2;
		assertEquals(3, JourneyToTheMoon.combination(n, k));
		n=10; k =4;
		assertEquals(210, JourneyToTheMoon.combination(n, k));
	}
	
	@Test
	public void testTestCase1() throws FileNotFoundException{
		File file = new File(this.workDir + File.separator + "JourneyToTheMoonTestCase1.txt");
		Scanner in = new Scanner(file);
		int N = in.nextInt(); // number of astronauts
		int P = in.nextInt(); // number of connection
		long result = 0;

		Map<Integer, Set<Integer>> graph = new HashMap<>();
		for (int node = 0; node < N; node++) {
			graph.put(node, new HashSet<>());
		}

		for (int i = 0; i < P; i++) {
			int astronauts1 = in.nextInt();
			int astronauts2 = in.nextInt();
			graph.get(astronauts1).add(astronauts2);
			graph.get(astronauts2).add(astronauts1);
		}

		result = JourneyToTheMoon.solve(N, graph);
		System.out.println(result);
	}
}
