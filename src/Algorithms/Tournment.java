package Algorithms;

public class Tournment {

	public static void main(String[] args) {
		Tournment t = new Tournment();
		int[] ar = new int[] {38,27,43,30,9,82,10};
		//int[] ar = new int[] {38,27,43};
		
		int winner = t.tournament(ar,0,ar.length-1);
		System.out.println(" END "+ winner);
		
	}
	int max = 0;
	private int tournament(int[] ar,int s,int e) {
		
		int m = 0;
		m = (s+e)/2;
		if(s<m) {
			
			max = Math.max(tournament(ar,s,m), tournament(ar,m+1,e));
		}
		System.out.println(s+ " "+ e + " "+ m+" "+ max+ " "+ar[m]);
		if(ar[m] > max) {
			max = ar[m];
		}
		return max;
	}
}
