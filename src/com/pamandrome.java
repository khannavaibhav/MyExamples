package com;

import java.io.IOException;

public class pamandrome {
	
	 public static void main(String[] args) throws IOException {

        String p = "ABBAcXCABBA";
        
        char[] c = p.toCharArray();
       // p.getChars(0, c.length, c, 0);
        
        boolean isPalandrome = true;
        for(int i =0,j=c.length-1;i<j;i++,j--) {
        	if(c[i] != c[j]) {
        		isPalandrome = false;
        		break;
        	}
        }
        System.out.println("IS PALANDROME "+ isPalandrome);

    }

}
