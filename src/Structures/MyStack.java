package Structures;


public class MyStack<T> {
	
	private int length = 0;
	private Node top = null;
	
	class Node{
		T data;
		Node next;
		
		Node(T d) {data = d;}		
	}
	
	public void push(T val) {
		if(top == null) {
			top = new Node(val);
		}else {
			Node temp = top;
			top = new Node(val);
			top.next = temp;
		}
		length++;
	}
	
	public T pop() {
		T res = null;
		if(top == null) return null;
		else {
			res = top.data;
			Node temp = top.next;
			top = temp;
			length--;
		}
		return res;
	}
	
	public void print() {
		Node curr = top;
		String pr = "";
		while(curr != null) {
			pr = pr + curr.data + '\n';
			Node temp = curr.next;
			curr = temp;
		}
		System.out.println("STACK : \n"+pr);
	}
	
	public static void main(String[] args) {
		MyStack a = new MyStack();
		a.push(2);
		a.push(4);
		a.push(3);
		a.push(6);
		a.push(5);
		a.push(1);
		
		/*System.out.println("LEN --- "+a.length);
		System.out.println("===== " +a.pop());
		System.out.println("LEN --- "+a.length);
		
		a.print();
		System.out.println("===== " +a.pop());
		System.out.println("LEN --- "+a.length);
		a.print();
		reverseStack(a);*/
		a.print();
		
		
	}

	
//=========================================================
	
	
	
	public static void reverseStack(MyStack s) {
		
		
		if(s == null || s.top == null) return;
		int  temp = (Integer)s.pop();
		reverseStack(s);
		
		if(s != null) {
			insertAtBottom(s,temp);	
		}
	}
	
	public static void insertAtBottom(MyStack s, int t) {
	
		if(s.top == null) {
			s.push(t);
			return;
		}else {
			int temp = (Integer)s.pop();
			insertAtBottom(s,t);
			s.push(temp);
			
		}
	}

}
