package finalLeapP3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitStringIntoUniquePrimes {

	public static void main(String[] args) {
		SplitStringIntoUniquePrimes s = new SplitStringIntoUniquePrimes();
		
		System.out.println(s.solution().toString());
	}

	/**
	 * @return
	 */
	public String solution() {

		getAllPrimes();
		String s = "3175";  //[[3, 17, 5], [31, 7, 5], [317, 5]]
		System.out.println(convertToNumeric(s));
		System.out.println(isPrime(117));
		
		List<List<String>> lst = new ArrayList<>();
		List<String> l = new ArrayList<>();
		dfs(s,lst,l);
		System.out.println(lst);
		
		
        return "" ;
        
    }
	
	void dfs(String s, List<List<String>> lst,List<String> l) {
		
		
		for(int j = 1;j<=s.length();j++) {
			String x = s.substring(0,j);
			if(x.length()<4 && isPrime(convertToNumeric(x))) {
				System.out.println("--------- "+x);
				l.add(x);
				dfs(s.substring(j),lst,l);
				l.remove(l.size()-1);
			}
			
		}
		if(s.length() == 0) {
			lst.add(new ArrayList<String>(l));
			System.out.println(l.toString());
		}
		//[[3, 17, 5], [31, 7, 5], [317, 5]]
	}
	
	int convertToNumeric(String s) {
		
		int curr = 0;
		int mul = 10;
		for(char c:s.toCharArray()) {
			curr = mul*curr + (c - '0');
		}
		return curr;
	}
	boolean isPrime(int n) {
		
//		if(n<2) return false;
//		else if(n<4) return true;
//		for(int i = 2;i<=n/i;i++) {
//			if(n%i == 0) return false;
//		}
//		return true;
		return primes[n];
	}
	
	static int maxn = 1000;
	static boolean[] primes = new boolean[maxn+1];
	 
	// Sieve of Eratosthenes
	static void getAllPrimes()
	{
	    Arrays.fill(primes, true);
	    primes[0] = false;
	    primes[1] = false;
	     
	    for(int i = 2; i * i <= maxn; i++)
	    {
	        if (primes[i])
	        {
	            for(int j = i * i;j <= maxn; j += i)
	                primes[j] = false;
	        }
	    }
	}
	
}


/*
Given a string made up of integers 0 to 9, count the number of ways to split the string into prime numbers in the range of 2 to 1000 inclusive, using up all the characters in the string.

Each prime number, pn, must not contain leading 0s, and 2 <= pn <= 1000.

Constraints
The input string does not contain any leading 0s.

Examples
Example 1:
Input: "31173"
Output: 6
Explanation:
The string "31173" can be split into prime numbers in 6 ways:

[3, 11, 7, 3]
[3, 11, 73]
[31, 17, 3]
[31, 173]
[311, 7, 3]
[311, 73]
 * */
 