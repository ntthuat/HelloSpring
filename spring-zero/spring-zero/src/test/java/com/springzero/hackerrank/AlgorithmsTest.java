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
		// step 1: Lấy dữ liệu cho 2 list
		Map<Integer, Set> map = new HashMap<>();
		Scanner scanner = new Scanner(file);
		int n = scanner.nextInt();
        int k = scanner.nextInt();
        int m = scanner.nextInt();
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		for(int a0 = 0; a0 < k; a0++){
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			list1.add(x);
			list2.add(y);
		}
		// step 2: nhóm các giá trị thay thế được cho nhau thành từng nhóm riêng lẻ
		while (list1.size()>0) {
			Algorithms.addValueFrom2ListToMap(map, list1, list2);
		}
		System.out.println(map);
		
		// lấy giá trị cần tính toán vào 1 array
		int[] array = new int[m];
        for(int a_i=0; a_i < m; a_i++){
        	array[a_i] = scanner.nextInt();
        }
        for (int i = 0; i < array.length; i++) {
			for (Integer key: map.keySet()) {
				Set<Integer> s = map.get(key);
				for (Integer integer : s) {
					if (array[i] == (int)integer) {
						array[i] = (int)key;
					}
				}
				
			}
		}
		int result = Algorithms.lengthLongestPalindromicSubsequence(array);
		System.out.println(result);
	}
	
	@Test
	public void testWrong() throws FileNotFoundException {
		File file = new File(this.workDir + File.separator + "testCase2.txt");
		// step 1: Lấy dữ liệu cho 2 list
		Map<Integer, Set> map = new HashMap<>();
		Scanner scanner = new Scanner(file);
		int n = scanner.nextInt();
        int k = scanner.nextInt();
        int m = scanner.nextInt();
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		for(int a0 = 0; a0 < k; a0++){
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			list1.add(x);
			list2.add(y);
		}
		// step 2: nhóm các giá trị thay thế được cho nhau thành từng nhóm riêng lẻ
		while (list1.size()>0) {
			Algorithms.addValueFrom2ListToMap(map, list1, list2);
		}
		System.out.println(map);
	}
}
