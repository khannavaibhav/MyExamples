package com;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;


public class TestMatrixRotation {

	public static void main(String[] args) {
		int[][] matrix = new int[][]{{1,2,3,4},
									 {5,6,7,8},
									 {9,10,11,12},
									 {13,14,15,16}};
									 
									 print(matrix);
		System.out.println("-------------");
		int n = matrix.length;	

		for (int i = 0; i < n / 2; i++) {
			int first = i;
			int last = n-1-i;
			for(int j = first; j<last;j++) {
				int offset = j - i;
				int temp = matrix[i][j];
				matrix[i][j] = matrix[last-offset][i];
				matrix[last-offset][i] = matrix[last][last-offset];
				matrix[last][last-offset] = matrix[j][last];
				matrix[j][last] = temp;
			}
			print(matrix);
			System.out.println("-------------");
		}
		print(matrix);
	}
	static void print(int[][] c) {
		for(int i = 0;i<c.length;i++) {
			for(int j = 0;j<c[i].length;j++) {
				System.out.print(c[i][j] + " ");
			}
			System.out.println(" ");
		}
	}

}
