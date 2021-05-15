package Algorithms;

public class SortAlgo {

	public static void main(String[] args) {
		
		int[] ar = new int[] {2,5,3,9,7,1,4};

		//bubbleSort(ar);
		//selectionSort(ar);
		insertionSort(ar);
		
	}

	private static void insertionSort(int[] ar) {
		
		for(int i = 1;i<ar.length;i++) {
			int tmp = ar[i];
			int j = i;
			while(j>0 && ar[j-1] > tmp) {
				ar[j] = ar[j-1];
				j--;
			}
			ar[j] = tmp;
		}
		
		for(int i = 0;i<ar.length;i++) {
			System.out.print(ar[i] + " ");
		}
	}
	
	private static void selectionSort(int[] ar) {
		int max = 0;
		for(int i = 0;i<ar.length;i++) {
			max = 0;
			for(int j = 1; j<ar.length-i;j++) {
				if(ar[max] < ar[j]) {
					max = j;
				}
			}
			int tmp = ar[max];
			ar[max] = ar[ar.length-i-1];
			ar[ar.length-i-1] = tmp;
		}
		
		for(int i = 0;i<ar.length;i++) {
			System.out.print(ar[i] + " ");
		}
	}
	private static void bubbleSort(int[] ar) {
		for(int i = 0;i<ar.length;i++) {
			boolean isSwapped = false;
			for(int j = 0; j<ar.length-i-1;j++) {
				if(ar[j] > ar[j+1]) {
					int tmp = ar[j];
					ar[j] = ar[j+1];
					ar[j+1] =tmp;
					isSwapped = true;
				}
			}
			if(!isSwapped) {
				break;
			}
		}
		for(int i = 0;i<ar.length;i++) {
			System.out.print(ar[i] + " ");
		}
	}

}
