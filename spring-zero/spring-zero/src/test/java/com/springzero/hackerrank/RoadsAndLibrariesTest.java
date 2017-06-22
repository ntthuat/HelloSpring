package com.springzero.hackerrank;

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
 * Test RoadsAndLibraries
 * 
 * @author Thuat T Nguyen
 * @version 06/22/2017
 */
public class RoadsAndLibrariesTest {
	
	private String workDir;
	
	@Before
	public void setUp(){
		String internalPath = this.getClass().getName().replace(".", File.separator);
		String externalPath = System.getProperty("user.dir")+File.separator+"src\\test\\java";
		String workDir = externalPath+File.separator+internalPath.substring(0, internalPath.lastIndexOf(File.separator));
		this.workDir = workDir;
	}
	
	@Test
	public void testTestCase1() throws FileNotFoundException{
		
	}
	
	/**
	 * Expected:
	 * 805
	 * 184
	 * 80
	 * 5
	 * 204
	 */
	@Test
	public void testTestCase2() throws FileNotFoundException{
		File file = new File(this.workDir + File.separator + "RoadsAndLibrariesTestCase2.txt");
		Scanner in = new Scanner(file);
		int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt(); // number of cities
            int m = in.nextInt(); // number of roads
            long clib = in.nextLong(); // price of 1 library
            long croad = in.nextLong(); // price of 1 road
            long result = 0;
            
            Map<Integer, Set<Integer>> graph = new HashMap<>();
            for (int node = 1; node <= n; node++) {
                graph.put(node, new HashSet<>());
            }
            
            for (int i = 0; i < m; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
    		
    	    result = RoadsAndLibraries.solve(n, m, clib, croad, graph);
    	    System.out.println(result);
            
        }
	}
}
