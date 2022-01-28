package google;

import java.io.IOException;
import java.util.Scanner;

public class ProblemA {

	public int solution(int n, int[] c) {

		
		return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }
        
        ProblemA p = new ProblemA(); 
        int result = p.solution(n, c);

        System.out.println(String.valueOf(result));
        

        scanner.close();
    }
	
	/*
	 * 

	 * 
	 * */
}
