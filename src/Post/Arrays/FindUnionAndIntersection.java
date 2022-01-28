package Post.Arrays;

import java.util.Arrays;

public class FindUnionAndIntersection {

	public static void main(String[] args) {
		FindUnionAndIntersection s = new FindUnionAndIntersection();
		
		System.out.println(s.solution().toString());
	}

	/**
	 * @return
	 */
	public String solution() {
		int[] a = new int[] {85, 25, 1, 32, 54, 6};
		int[] b = new int[] {85, 2};
		int n = a.length;
		int m = b.length;
		int aaa = Integer.MIN_VALUE;
		Math.min(10, 20);
		Arrays.sort(a);
        Arrays.sort(b);
        int i = 0, j = 0,k=0,l=0;
        Integer[] intersection = new Integer[Math.min(n,m)];
        Integer[] unionA = new Integer[n+m];
        int isn = 0;
        int prev = a[0]+b[0];
        while(i<n && j<m){
            if(a[i]==b[j]){
                if(prev!=a[i]){
                    intersection[k++] =a[i];
                    unionA[l++] = a[i];
                    prev=a[i];
                }
                i++;j++;
            }
            else if(a[i]<b[j]){
                if(prev!=a[i]){
                    unionA[l++] = a[i];
                    prev = a[i];
                }
                i++;
            }
            else {
                 if(prev!=b[j]){ 
                     unionA[l++] = b[j];
                     prev=b[j];
                 }
                 j++;
            }
        }
        while(i<n){
            if(prev!=a[i]) unionA[l++] = a[i];
             prev = a[i++];
        }
        while(j<m){
            if(prev!=b[j]) unionA[l++] = b[j];
            prev=b[j++];
        }
        
        System.out.println("INTERSECTION");
        for(Integer x:intersection) {
        	System.out.print(x + " ");
        }
        System.out.println("\nUNION");
        for(Integer x:unionA) {
        	System.out.print(x + " ");
        }
		return "END ";
    }
	
}


/*

 * */
 