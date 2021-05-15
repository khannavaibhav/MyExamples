package finalLeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OptimalUtilization {
	
//	Given 2 lists a and b. Each element is a pair of integers where the first integer
//	represents the unique id and the second integer represents a value. Your task is to 
//	find an element from a and an element form b such that the sum of their values is less 
//	or equal to target and as close to target as possible. Return a list of ids of selected elements. 
//	If no pair is possible, return an empty list.
	
	public static void main(String[] args) {
		OptimalUtilization g = new OptimalUtilization();

		int[][] a = {{1, 3}, {2, 5}, {3, 7}, {4, 1}};
		int[][] b = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
		g.getOptimal(a, b, 10);
	}
	
	public static void getOptimal(int[][] a, int[][] b, int k) {
		List<int[]> res = new ArrayList<int[]>();
		
		Arrays.sort(a, new Comparator<int[]>() {
			public int compare(int[] i1,int[] i2) {
				return i1[1]-i2[1];
			}
		});
		Arrays.sort(b, new Comparator<int[]>() {
			public int compare(int[] i1,int[] i2) {
				return i1[1]-i2[1];
			}
		});
		int sum = 0;
		int i = 0;
		int j = b.length -1;
		while(i< a.length && j>=0) {
			System.out.println(i);
			if(a[i][1] + b[j][1]> k) j--;
			else if(a[i][1] + b[j][1] <= k){
				if(sum<a[i][1] + b[j][1]) {
					sum = a[i][1] + b[j][1];
					res = new ArrayList<int[]>();
					res.add(new int[]{a[i][0],b[j][0]});
				}
				else if(sum == a[i][1] + b[j][1]) {
					res.add(new int[]{a[i][0],b[j][0]});
				}
				i++;
			}
		}
		for(int[] o:res) {
			System.out.println(o[0]+" "+o[1]);
		}
		
	}
	
	
	
	
	
	
	
	public static void getOptimal2(int[][] a, int[][] b, int k) {
		Arrays.sort(a, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}
		});
		Arrays.sort(b, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}
		});
		int max = 0;
		List<Integer> res = new ArrayList<Integer>();
		for(int i =0;i<a.length;i++) {
			int x = b.length-1;
			while( x>=0 && a[i][1] + b[x][1] <= k) {
				if(a[i][1] + b[x][1] > max) {
					max = a[i][1] + b[x][1];
					res = new ArrayList<Integer>();
					res.add(a[i][0]);
					res.add(b[x][0]);
				}
				else if(a[i][1] + b[x][1] == max) {
					res.add(a[i][0]);
					res.add(b[x][0]);
				}		
				x--;
			}	
		}
		System.out.println(res);
	}
	
}
