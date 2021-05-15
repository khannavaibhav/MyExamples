package finalLeapP1;

public class StorageOptimization {

	public static void main(String[] args) {
		StorageOptimization sm = new StorageOptimization();
//		int[][] b = {{4,  5,10,15,19,20,20},
//					 {4,  9,12,15,22,23,26},
//					 {7, 11,12,20,22,27,27},
//					 {10,14,17,23,27,30,32},
//					 {11,18,19,25,28,34,39}};
		
		int n = 6; int m = 6;
		int[] h = new int[]{1,4,5};
		int[] v = new int[]{2,5,6};
		
		System.out.println(sm.shelving(n,m,h,v));

	}
	
	public int shelving(int n,int m,int[] h,int[] v) {
	
		boolean[] hb = new boolean[n+1];
		boolean[] vb = new boolean[m+1];
		
		for(int i:h) {
			hb[i] = true;
		}
		for(int i:v) {
			vb[i] = true;
		}
		int currH = 0, maxH=0;
		for(boolean x:hb) {
			if(x) {
				currH+=1;
				if(maxH<currH) maxH= currH;
			}
			else {
				
				currH = 0;
			}
		}
		int currV = 0, maxV=0;
		for(boolean x:vb) {
			if(x) {
				currV+=1;
				if(maxV<currV) maxV= currV;
			}
			else {
				currV = 0;
			}
		}
	    
	    return (maxH+1)*(maxV+1);
    }
    

}
/*
 Amazon is experimenting with a flexible storage system for their warehouses. The storage unit consists of a shelving system which is one meter deep with removable vertical and horizontal separators. When all separators are installed, each storage space is one cubic meter (1' x 1' x 1'). Determine the volume of the largest space when a series of horizontal and vertical separators are removed.

Example
n = 6
m = 6
h = [4]
v = [2]
Consider the diagram below. The left image depicts the initial storage unit with n = 6 horizontal and m = 6 vertical separators, where the volume of the largest storage space is 1 x 1 x 1. The right image depicts that unit after the fourth horizontal and second vertical separators are removed. The maximum storage volume for that unit is then 2 x 2 x 1 = 4 cubic meters:
 */
