package Structures;

import java.util.Stack;

public class MinStack {
	
	public static void main(String[] args) {

		MinStack m = new MinStack();
		
//		["MinStack","push","push","push","getMin","pop","getMin"]
//				[[],[0],[1],[0],[],[],[]]
		m.push(0);
		m.push(1);
		m.push(0);
		System.out.println(m.getMin());
		m.pop();
		System.out.println(m.getMin());
		
	}
	
	/** initialize your data structure here. */
    Stack stk ;Stack min;
    public MinStack() {
         stk = new Stack();
         min = new Stack();
    }
    
    public void push(int x) {
        if(stk.empty()){
            
            min.push(x);
        }
        else{
            if((Integer)min.peek() >= (x)){
                min.push(x);
            }
        }
        stk.push(x);
    }
    
    public void pop() {
        if(!stk.empty()){
            Integer n = (Integer)stk.pop();
            if(min.peek().equals(n)){
                min.pop();
            }
        }
        
    }
    
    public int top() {
        Integer n = (Integer)stk.peek();
        return n.intValue();
    }
    
    public int getMin() {
        Integer n = (Integer)min.peek();
        return n.intValue();
    }

}
