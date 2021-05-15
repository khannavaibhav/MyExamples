package finalLeapP3;

public class StorageOptimization {

	public static void main(String[] args) {
		StorageOptimization sm = new StorageOptimization();
//		int[][] b = {{4,  5,10,15,19,20,20},
//					 {4,  9,12,15,22,23,26},
//					 {7, 11,12,20,22,27,27},
//					 {10,14,17,23,27,30,32},
//					 {11,18,19,25,28,34,39}};
		
		int n = 6; int m = 6;
		int[] h = new int[]{2,3};
		int[] v = new int[]{2};
		
		System.out.println(sm.shelving(n,m,h,v));

	}
	
	public int shelving(int row,int col,int[] WELane,int[] NSLane) {
		
		int[] h = WELane;
		int[] v = NSLane;
		int count = 1; int max = 1;
		for(int i=1;i<h.length;i++) {
			if(h[i] - h[i-1] == 1) {
				count++;
				if(count>max) max = count;
			}
			else {
				count = 1;
			}
		}
		int countV = 1; int maxV = 1;
		for(int i=1;i<v.length;i++) {
			if(v[i] - v[i-1] == 1) {
				countV++;
				if(countV>maxV) maxV = countV;
			}
			else {
				countV = 1;
			}
		}
		return max*maxV;
    }
    

}
/*
 Amazon is experimenting with a flexible storage system for their warehouses. The storage unit consists of a 
 shelving system which is one meter deep with removable vertical and horizontal separators.
  When all separators are installed, each storage space is one cubic meter (1' x 1' x 1'). 
  Determine the volume of the largest space when a series of horizontal and vertical separators are removed.

Example
n = 6
m = 6
h = [4]
v = [2]
Consider the diagram below. The left image depicts the initial 
storage unit with n = 6 horizontal and m = 6 vertical separators, where the volume of the
 largest storage space is 1 x 1 x 1. The right image depicts that unit after the fourth 
 horizontal and second vertical separators are removed. The maximum storage volume f
 or that unit is then 2 x 2 x 1 = 4 cubic meters:
 */
