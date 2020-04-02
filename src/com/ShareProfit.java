package com;

import java.util.Collections;
import java.util.PriorityQueue;


public class ShareProfit {

	public static void main(String[] args) {
		int[] prices = new int[] {5,11,3,50,10,14,15,14,60,90};
		int k = 100;
		findMaxProfit(prices, k);
	}
	
	public static void findMaxProfit(int[] p, int k) {
		
		int buy =-1,lastBuy=-1,sell=-1,lastSell=-1;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10, Collections.reverseOrder());
		int lastChange = -1;
		for(int i =1;i<p.length;i++) {
			if(p[i-1] <= p[i]) {
				if(lastChange == -1 )
					buy = i-1;
				sell = i;
				lastChange = 0;
			}
			else {
				lastChange = -1;
			}
			
			if (lastBuy !=-1 && lastSell!=-1 && sell!= -1) {
				if(p[lastBuy]<p[buy] && p[lastSell] < p[sell]) {
					buy = lastBuy;
				}
			}
			if(sell != -1 && (sell == p.length -1 || p[sell+1] <p[sell]) ) {
				pq.add((p[sell]- p[buy]));
				lastBuy = buy;
				buy = -1;
				lastSell = sell;
				sell = -1;
			}
			
		}
		System.out.println(pq.size());
		int j = 0,l= pq.size();
		
		for(int i=0;i<(k<=l?k:l);i++) {
			j+= pq.poll();
			System.out.println(j);
		}
		System.out.println(j);
	}

}
