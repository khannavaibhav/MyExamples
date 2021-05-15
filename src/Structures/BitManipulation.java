package Structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class BitManipulation {

	public static void main(String[] args) {
		BitManipulation b = new BitManipulation();

//		System.out.println(b.hammingWeight(00000000000000000000000000001010));
		System.out.println(b.hammingWeight(5));
//		System.out.println(3&2);
//		System.out.println(b.hammingDistance(3, 8));
		
//		System.out.println(b.firstBadVersion(2126753390));
//		System.out.println(b.isValid("()"));
//		System.out.println(b.romanToInt("III"));
//		System.out.println(b.firstNonRepeatingChar("abczabc"));
		
		//System.out.println(b.networkDelayTime(new int[][] {{2,1,1},{2,3,1},{3,4,1}}, 4, 2));
		//test();
	}
	
	public static void swap(Integer i, Integer j)  
	   { 
	      Integer temp = new Integer(i); 
	      i = j; 
	      j = temp; 
	   } 
	   public static void test()  
	   { 
		   String s = "aaa sss dff ggjler yhre";
		   String[] c = s.split("\\ ");
	      Integer i = new Integer(10); 
	      Integer j = new Integer(20); 
	      swap(i, j); 
	      System.out.println("i = " + i + ", j = " + j); 
	   } 
	   
    /*
     * Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
		Output: 2
		
		Given times, a list of travel times as directed edges times[i] = (u, v, w), 
		where u is the source node, v is the target node, and w is the time 
		it takes for a signal to travel from source to target.
     * 
     */
    
	public class Graph{
        ArrayList<Node> node = new ArrayList<Node>();
    }
    public class Node{
        int val;
        int t;
        boolean visited ;
        Node  children;
    }
    
    public int networkDelayTime(int[][] times, int K, int N) {
        if(times.length == 0) return -1;
        Graph g = new Graph();
        for(int i = 0; i<times.length;i++){
            Node n = new Node();
            Node c = new Node();
            n.val = times[i][0];
            n.t = 0;
            c.val = times[i][1];
            c.t = times[i][2];
            n.children = c;
            g.node.add(n);
        }
        Integer count = 0;
        for(int i=0;i<g.node.size();i++){
            Node n = g.node.get(i);
            System.out.println(n.val + " = " + N);
            if(n.val == N){
                count = n.t;
                Node c = findNode(g,n.children,K,count);
                System.out.println("RES = "+count);
                if(c!= null && c.val == K) return count;
            }
        }
        
        return -1;
    }
    
    public Node findNode(Graph g, Node n, int k,Integer c){
        Node x = null;
        Integer r = c;
        r = r+n.t;
        c = r;
        System.out.println("count = " + c);
        if(n.val == k) return n;
        for(int i=0;i<g.node.size();i++){
            if(g.node.get(i).val == n.val){
               System.out.println("r = " + r + " c = "+c); 
               x= findNode(g,g.node.get(i).children,k,r);
            }
        }
        return x;
    }
////////////////////////////////////////////////////////////////
	
	 public List<Integer> topKFrequent(int[] nums, int k) {

	        HashMap<Integer,Integer> counts = new HashMap<Integer,Integer>(nums.length);
	        
	        
	        for(int i:nums){
	            counts.put(i, counts.getOrDefault(i,0) +1);
	        }
	        
	        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k,new Comparator<Integer>(){
	            
	            public int compare(Integer i1, Integer i2){
	                if(counts.get(i1) > counts.get(i2)) return 1;
	                else if(counts.get(i1) < counts.get(i2)) return -1;
	                else return 0;
	            }
	        });
	        
	        for(Integer i:counts.keySet()){
	            q.add(i);
	            if(q.size() > k){
	                q.poll();
	            }
	        }
	        
	        List<Integer> l = new ArrayList<Integer>();
	        for(int i =0;i<k;i++){
	            l.add(q.poll());
	        }
	        Collections.reverse(l);
	        return l;
	    }
	
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            // Never let i refer to the same value twice to avoid duplicates.
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
              if (nums[i] + nums[j] + nums[k] == 0) {
            	  ArrayList<Integer> l = new ArrayList<Integer>();
            	  l.add(nums[i]);l.add(nums[j]);l.add(nums[k]);
            	  res.add(l);
                ++j;
                // Never let j refer to the same value twice (in an output) to avoid duplicates
                while (j < k && nums[j] == nums[j-1]) ++j;
              } else if (nums[i] + nums[j] + nums[k] < 0) {
                ++j;
              } else {
                --k;
              }
            }
          }
        return res;
    }
	
	
	public char firstNonRepeatingChar(String s) {
		
		ArrayList q = new ArrayList(s.length());
		boolean[] contains = new boolean[256];
		
		for(int i =0;i<s.length();i++) {
			char c = s.charAt(i);
			if(!contains[c]) {
				if(q.contains(c)) {
					contains[c] = true;
					q.remove(Character.valueOf(c));
				}
				else {
					q.add(Character.valueOf(c));
				}
			}
			else {
				q.remove(Character.valueOf(c));
			}
		}
		
		return (Character)q.get(0);
	}
	
	
	public int romanToInt(String s) {
        HashMap h = new HashMap(7);
        h.put("I",1);
        h.put("V",5);
        h.put("X",10);
        h.put("L",50);
        h.put("C",100);
        h.put("D",500);
        h.put("M",1000);
        
        int sum = 0;
        for(int i=0;i<s.length();i++)
        {
            int x = (Integer)h.get(""+s.charAt(i));
            int y = (i+1 < s.length())?(Integer)h.get(""+s.charAt(i+1)):0;           
            if(y<= x) sum = sum + x;
            else{
                sum = sum + y -x;
                i++;
            }
        }
        return sum;
    }
	
	public boolean isValid(String s) {
        Stack stack = new Stack();
        for(int i =0;i<s.length();i++){
            char c =s.charAt(i);
            if( c == '{' || c=='[' || c=='('){
                stack.push(c);
            }
            if( c == '}' || c==']' || c==')'){
                if(stack.isEmpty()) return false;
                char a = (Character)stack.pop();
                if(a != c) return false;
            }
        }
        return stack.isEmpty();
    }
	
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	
	/*
	 * public boolean isSymmetric(TreeNode root) { if(root == null) return true;
	 * return isMirror(root.left,root.right); }
	 * 
	 * public boolean isMirror(TreeNode t1, TreeNode t2) { if (t1 == null && t2 ==
	 * null) return true; if (t1 == null || t2 == null) return false; return (t1.val
	 * == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right); }
	 */
	
	/*
	 * IS VALID BINARY SEARCH TREE 2 O(N2)
	 * 
	 * public boolean isValidBST(TreeNode root) { if(root == null) return true;
	 * return isValid(root,Integer.MIN_VALUE, Integer.MAX_VALUE); }
	 * 
	 * public boolean isValid(TreeNode root, int min, int max){ if(root == null)
	 * return true;
	 * 
	 * return ((root.val > min && root.val < max) && isValid(root.left, min,
	 * root.val) && isValid(root.right, root.val,max));
	 * 
	 * }
	 */
	
	
	/*
	 * IS VALID BINARY SEARCH TREE 1 O(N2)
	 * 
	 * public boolean isValidBST(TreeNode root) { if(root == null) return true;
	 * if(root.left != null){ if(root.val <= findMax(root.left).val ) return false;
	 * } if(root.right != null){ if(root.val >= findMin(root.right).val ) return
	 * false; } return isValidBST(root.left)?isValidBST(root.right):false; }
	 * 
	 * public TreeNode findMax(TreeNode head){ if(head.right == null) return head;
	 * 
	 * return findMax(head.right);
	 * 
	 * } public TreeNode findMin(TreeNode head){ if(head.left == null) return head;
	 * return findMin(head.left); }
	 */
	 
	
///////////////////////////////////////////////////////////////	
	 public int firstBadVersion(int n) {
	        return isBad(0,n);
	    }
	    
    public int isBad(int start, int end){
        if(start >= end) return isBadVersion(start)?start:0;
        int mid = (end/2) + (start/2);
        if(isBadVersion(mid)) {
        	if(isBadVersion(mid-1)) return isBad(start,mid-1);
        	else {
        		return mid;
        	}
        } 
        else{
        	if(isBadVersion(mid+1)) return mid+1;
        	else {
        		return isBad(mid+1,end);
        	}
        }
    }
    
    public boolean isBadVersion(int n) {
    	return (n>=1702766719);
    }
	
	
	//Write a function that takes an unsigned integer and return the 
	//number of '1' bits it has (also known as the Hamming weight).

	public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            System.out.println(n +" & "+ (n-1) +" "+ (n & (n-1)));
            n &= (n - 1);
        }
        return sum;
    }
	
	public int hammingDistance(int n1, int n2) 
	{ 
	    int x = n1 ^ n2; 
	    System.out.println("WEIGHT "+ hammingWeight(x));
	    
	    int setBits = 0; 
	    while (x > 0)  
	    { 
	        setBits += x & 1; 
	        x >>= 1; 
	    } 
	    
	    System.out.println("DIST   "+ setBits);
	    
	  
	    return setBits; 
	} 
	
	
	
 
}
