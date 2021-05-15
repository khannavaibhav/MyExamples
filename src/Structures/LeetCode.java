package Structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class LeetCode {

	public static void main(String[] args) {
		int n = 11111;
		LeetCode h = new LeetCode();
		//System.out.println("-----> "+h.isHappy(n));
//		int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
//		System.out.println("-----> "+h.maxSubArray(nums));
		
//		int[] nums = new int[] {1,2,3,4,5};
//		System.out.println("-----> "+h.maxProfit(nums));
	
//		System.out.println(h.backspaceCompare("a#b#","ab##"));
//		Stack stk = new Stack();
//		stk.push(1);
//		Integer x = (Integer)stk.pop();
//	   System.out.println(x.equals(1));
		
//		int[] r = h.plusOne(new int[] {9});
//		for(int i =0;i<r.length;i++) {
//			System.out.print(r[i]);
//		}
		
//		int[] r = h.twoSum(new int[] {3,2,4}, 6);
//		for(int i =0;i<r.length;i++) {
//			System.out.print(r[i]);
//		}
		
//		char[][] c = new char[][] {
//			{'.','.','.','.','5','.','.','1','.'},
//			{'.','4','.','3','.','.','.','.','.'},
//			{'.','.','.','.','.','3','.','.','1'},
//			
//			{'8','.','.','.','.','.','.','2','.'},
//			{'.','.','2','.','7','.','.','.','.'},
//			{'.','1','5','.','.','.','.','.','.'},
//			
//			{'.','.','.','.','.','2','.','.','.'},
//			{'.','2','.','9','.','.','.','.','.'},
//			{'.','.','4','.','.','.','.','.','.'}};
//		
//		System.out.println(h.isValidSudoku(c));
		
//		long l = Integer.MAX_VALUE/1463847412;
//		System.out.println(l);
//		System.out.println(Integer.MIN_VALUE);
		
//		int[] r = new int[3];
//		for(int i =0;i<r.length;i++) {
//			System.out.print(r[i]);
//		}
		//System.out.print(h.isPalindrome("0P"));
		//System.out.print(h.myAtoi("-2147483648"));
		//System.out.print(h.strStr("mississippi","issip"));
		
//		System.out.print(h.hammingWeight(00000000000000000000000000001011));
		
//		System.out.println(" -- > "+h.longestCommonPrefix(new String[] {"ssa","da"}));
		
//		int[][] c = new int[][] {
//		{1,1,1},
//		{0,1,2}};
//		h.setZeroes(c);
		
//		System.out.println(" -- > "+h.lengthOfLongestSubstring(""));
		
		//jSystem.out.println(" -- > "+h.longestPalindrome("bb"));
		Queue<String> q = (Queue<String>) new LinkedList<String>();
		q.add("A");
		System.out.println(" -- > "+q.poll());
		
		PriorityQueue pq = new PriorityQueue<>(10, new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}});
		
	}
	
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3 ) return false;
        for(int i = 0;i<nums.length-2;i++){            
           for(int j = i+1;j<nums.length-1;j++){
               while(j<nums.length-2 && nums[j] <= nums[i]) j++;
               for(int k = j+1;k<nums.length;k++){
                   while(k<nums.length-1 && nums[k] <= nums[j]) k++;
                   if(nums[i] < nums[j] && nums[j] < nums[k]) return true;
               }
           }
        }
        return false;
    }
	
	public String longestPalindrome(String s) {
        ArrayList<Integer> centers = new ArrayList<Integer>();
        if(s==null || s.length() < 2) return s;
        int maxLR = 0;
        int indexL = 0;
        int indexR = 0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1) == s.charAt(i)){
                int l = i-1;
                int r = i;
                while(l>=0 && r <s.length() && s.charAt(l) == s.charAt(r))
                {
                    if(maxLR < r-l){
                        maxLR = r-l;
                        indexL = l;
                        indexR = r;
                    }
                    l--;
                    r++;
                }
            }
            if(i+1 < s.length() && (s.charAt(i-1) == s.charAt(i+1)) ){
                int l = i-1;
                int r = i+1;
                while(l>=0 && r <s.length() && s.charAt(l) == s.charAt(r)  )
                {
                    if(maxLR < r-l){
                        maxLR = r-l;
                        indexL = l;
                        indexR = r;
                    }
                    l--;
                    r++;
                }
            }
           
        }
         return s.substring(indexL,indexR+1);
    }
	
	public int lengthOfLongestSubstring(String s) {
	       
        if(s == null) return 0;
        if(s.length() < 2) return s.length();
        char[] c = s.toCharArray();
        int max = 0;
        String r = ""+c[0];
        for(int i = 1;i<c.length;i++){
            if(r.contains(""+c[i])) {
                if(max < r.length()) max = r.length();
                r = r.substring(r.indexOf(""+c[i])+1)+c[i];
            }
            else{
                r = r+c[i];
            }
        }
        return max>r.length()?max:r.length();
    }
	
	public void setZeroes(int[][] matrix) {
		boolean firstRowZero = false;
        boolean firstColumnZero = false;
 
        //set first row and column zero or not
        for(int i=0; i<matrix.length; i++){
            if(matrix[i][0] == 0){
                firstColumnZero = true;
                break;
            }
        }
 
        for(int i=0; i<matrix[0].length; i++){
            if(matrix[0][i] == 0){
                firstRowZero = true;
                break;
            }
        }
        for(int i = 1;i<matrix.length; i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int col = 1; col<matrix[0].length; col++){
            if(matrix[0][col] == 0){
                for(int r = 0;r<matrix.length;r++){
                    matrix[r][col] = 0;
                }
            }
        }
        for(int row = 0; row<matrix.length; row++){
            if(matrix[row][0] == 0){
                for(int c = 0;c<matrix[0].length;c++){
                    matrix[row][c] = 0;
                }
            }
        }

        if(firstColumnZero){
            for(int i=0; i<matrix.length; i++)
                matrix[i][0] = 0;
        }
 
        if(firstRowZero){
            for(int i=0; i<matrix[0].length; i++)
                matrix[0][i] = 0;
        }
    }
	public String longestCommonPrefix(String[] strs) {

        String ss = "";
        int  shortest = Integer.MAX_VALUE;
        for(String s:Arrays.asList(strs)){
            if(shortest > s.length()) {
                shortest= s.length();
                ss = s;
            }
        }
        String res = "";
        boolean found = true;
        
        for(int i = 0; i<ss.length();i++){
            for(int j = i+1; j<ss.length()+1;j++){
                String c = ss.substring(i,j);
                found = true;
                for(String s:Arrays.asList(strs)){
                    if(s.indexOf(c) == -1){
                        found = false;
                        break;
                    }
                }
                if(found && c.length() > res.length()){
                    res = c;
                }
            }
            
        }
        return res;
    }
	
	public int hammingWeight(int n) {
        String s = "" + n;
        System.out.println(s);
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '1') count++;
        }
        return count;
    }
	
	public int strStr(String haystack, String needle) {
		
		if(needle == null || needle.length() == 0) return 0;
        if(haystack == null || haystack == "" ) return 0;
        else if(haystack.length() >= needle.length()){
             int p1 = -1, p2 = -1;
            int index = 0, end = needle.length();
            //char start = needle.charAt(0);
            for(int i=0;i<haystack.length();i++){
                boolean eq=false;
                if(p1==-1 && haystack.charAt(i) == needle.charAt(0)){
                    p1 = i;
                }
                else if(p2==-1 && haystack.charAt(i) == needle.charAt(0)){
                    p2 = i;
                }
                if(index < end && haystack.charAt(i) == needle.charAt(index)){
                    eq=true;
                    index++;
                }
                if(p1>-1 && index == end ) return p1;
                 else if(!eq) {
                    if(p2 > -1) {
                        i = p2-1;
                    }
                    p1 = -1;
                    p2= -1;
                    index = 0;
                } 
            }
            
        }
       return -1;
    }
	
	 public int myAtoi(String str) {
	        
	        boolean firstP = false, firstN = false, numFound = false; 
	        int x = 0;        
	        if(str == null || str == "") return 0;
	        
	        for(int i = 0;i<str.length();i++){
	            char c = str.charAt(i);
	            
	            if((firstP || firstN || numFound) && (c < '0' || c > '9' ) ){
	                break;
	            }
	            
	            if(c == ' ') continue;
	            
	            else if(!numFound && c == '+'){
	                firstP = true;
	            }
	            else if(!numFound && c == '-'){
	                firstN = true;
	            }
	            else if(!numFound && (c < '0' || c > '9' )){
	                return 0;
	            }
	            else if(c >= '0' || c <= '9'){
	                if(!numFound) numFound = true;
	                if(firstN && (-1*x < Integer.MIN_VALUE/10 || (-1*x == Integer.MIN_VALUE/10 && c > '8'))) return Integer.MIN_VALUE;
	                else if(!firstN && (x > Integer.MAX_VALUE/10 || (x == Integer.MAX_VALUE/10 && c > '7'))) return Integer.MAX_VALUE;
	                x = x*10 + (Character.getNumericValue(c));
	            }
	        }
	        return firstN?-1*x:x;
	    }
	
	
	public boolean isPalindrome(String s) {
        if(s==null || s.length() == 0) return true;
        String t = s.toUpperCase();
        int l = 0, r= t.length() -1;
        while(l<r){
        	System.out.println(t.charAt(l) +" : "+t.charAt(r));
            if((t.charAt(l) < 'A' || t.charAt(l) > 'Z') && ((t.charAt(l) < '0' || t.charAt(l) > '9'))) l++;
            else if((t.charAt(r) < 'A' || t.charAt(r) > 'Z') && (t.charAt(r) < '0' || t.charAt(r) > '9')) r--;
            else if(t.charAt(l) != t.charAt(r)) return false;
            else{
            	l++;
            	r--;
            }
            
        }
        return true;
    }
	
	public void findNext(String t, int l) {
		if(t.charAt(l) < 'A' || t.charAt(l) > 'Z') findNext(t,++l);
	}
	
	public boolean isValidSudoku(char[][] board) {
        boolean f = true;
        for(int index = 0; index <9; index++){
        	System.out.println(index);
            f = checkRow(index,board); 
            System.out.println("row");
            if(!f) return f;
            f = checkColumn(index,board);
            System.out.println("col");
            if(!f) return f;
            if(index%3 == 0){
               f= checkSUbs(index,board);
                if(!f) return f;
            }
            System.out.println("sub");
        }
        
        return f;
    }
    
    public boolean checkSUbs(int i,char[][] b){
        char[] c = new char[9];
        int ind = 0;
        for(int j = i;j<i+3;j++){
            for(int k = 0;k<3;k++){
                c[ind++] = b[j][k];
            }
        }
        
        boolean x =  isValid(c);
       
        if(!x){
            c = new char[9];
            for(int j = i;j<i+3;j++){
                for(int k = 3;k<6;k++){
                    c[ind++] = b[j][k];
                }
            }
            x =  isValid(c);
        }
        if(!x){
            c = new char[9];
            for(int j = i;j<i+3;j++){
                for(int k = 6;k<9;k++){
                    c[ind++] = b[j][k];
                }
            }
            x =  isValid(c);
        }
        return x;
    }
    
    
    public boolean checkRow(int i,char[][] b){
        char[] c = new char[9];
        int ind = 0;
        for(int j = 0;j<9;j++){
            c[ind++] = b[i][j];
        }
        return isValid(c);
        
    }
    public boolean checkColumn(int i,char[][] b){
        char[] c = new char[9];
        int ind = 0;
        for(int j = 0;j<9;j++){
            c[ind++] = b[j][i];
        }
        return isValid(c);
    }
    
    public boolean isValid(char[] c){
        Arrays.sort(c);
        for(int j = 0;j<8;j++){
            if(c[j] != '.' && c[j] == c[j+1])
                return false;
        }
        return true;
    }
	
	
//-------------------------------------------------------------------------------------------------------	
	 public int[] twoSum(int[] nums, int target) {
	        int[] res = new int[2];
	        HashMap<Integer,Integer> m = new HashMap<Integer,Integer>(nums.length);
	        
	        for(int i = 0;i<nums.length; i++){
	            m.put(target-nums[i],i);
	        }
	        for(int i = 0;i<nums.length; i++){
	            if(m.containsKey(nums[i]) && m.get(nums[i]) != i){
	                res[0] = i;
	                res[1] = m.get(nums[i]);
	                break;
	            }
	        }
	        return res;
	    }
	
	public int[] plusOne(int[] digits) {
       int[] r =  add(digits,1,digits.length-1);
        
        return r;
    }
    public int[] add(int[] d,int add, int pos){
        
        if(pos <0){
            int[] cp = new int[d.length+1];
            cp[0] = 0;
            for(int i =1;i<cp.length;i++){
                cp[i] = d[i-1];
            }
            d = cp;
            pos = 0;
        }
        int x= d[pos] + 1;
        if(x==10){
            d[pos] = 0;
            d=add(d,1,pos-1);
        }
        else{
            d[pos] = x;
        }
        return d;
        
    }
	
	 public boolean backspaceCompare(String S, String T) {
	        char[] s1 = new char[S.length()];
	        char[] t1 = new char[T.length()];

	        int position = 0;
	        for(int i = 0; i< S.length(); i++){
	            
	            if(S.charAt(i) == '#'){
	                position--;
	                s1[position] = ' ';
	            }
	            else{
	                s1[position] = S.charAt(i);
	                position++;
	            }
	        }
	        position = 0;
	        for(int i = 0; i< T.length(); i++){
	            
	            if(T.charAt(i) == '#'){
	                position--;
	                t1[position] = ' ';
	            }
	            else{
	                t1[position] = T.charAt(i);
	                position++;
	            }
	        }
	        String s = new String(s1).trim();
	        String t = new String(t1).trim();
	        System.out.println("S " + s + " T "+t );
	        if(s.length() == 0 && t.length()==0) return true;
	        return s.equals(t);
	    }
	
	public int maxProfit(int[] prices) {
        int buyPos = -1;
        int buyPrice = Integer.MAX_VALUE;
        int sellPos = -2;
        int profit = 0;
        for (int i = 0 ; i<prices.length -1; i++){
        	System.out.println(i + " B " + buyPos);
            if(prices[i] <= prices[i+1] && buyPrice >= prices[i]){
                buyPos = i;
                buyPrice = prices[i];
            }
            else if(buyPos != -1 && (prices[i] > prices[i+1] )){
                profit = profit + prices[i] - buyPrice;
                sellPos = i;
                buyPos = i+1;
                buyPrice = prices[i+1];
            }
            
        }
        if(buyPos != -1 && buyPos != prices.length-1  && buyPos > sellPos) {
        	 profit = profit + prices[prices.length-1] - buyPrice;
        }
        return profit;
    }
	
	
/*
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 *  which has the largest sum and return its sum.
 */
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0],sum = 0;
        for(int i =0;i<nums.length;i++){
            sum = Math.max(sum+nums[i],nums[i]);
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }
	
	/*
	 * A happy number is a number defined by the following process: Starting with any positive integer, 
	 * replace the number by the sum of the squares of its digits, and repeat the process until 
	 * the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. 
	 * Those numbers for which this process ends in 1 are happy numbers.
		Return True if n is a happy number, and False if not.
	 */
	public boolean isHappy(int n) {
		ArrayList  st = new ArrayList();
		return getDigit(n,st);
	}
	
	public boolean getDigit(int n,ArrayList  st) {
		
		int j = n, sum = 0;
		while(j != 0) {
			int i = j%10;
			j = j/10;
			sum = sum + (i*i);
			System.out.println(i + "   " + j);
		}
		System.out.println("SUM "+sum);
		if(sum == 1) return true;
		System.out.println("st SIZE - "+st.size());
		if(st.size() > 0 && st.contains(sum)) return false;
		System.out.println("HERE");
		
			st.add(sum);
		
		return getDigit(sum,st);
	}
	


}
