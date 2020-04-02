package Structures;

public class LinkedList<T> {

	Node head;
	
	class Node{
		T data;
		Node next;
		
		Node(T d) {data = d;}		
	}
	
	public void add(T newData) {
		
		Node newNode = new Node(newData);
		newNode.next = null;
		
		if(this.head == null ) {
			this.head = newNode;
		}
		else {
			Node n = head;
			while(n.next != null) {
				n = n.next;
			}
			n.next = newNode;
		}
	}
	
	public void put(T newData) {
		
		Node newNode = new Node(newData);
		newNode.next = null;
		
		if(this.head == null ) {
			this.head = newNode;
		}
		else {			
			Node comp = head;
			head = newNode;
			head.next = comp;
			
		}
	}
	
	
	public void delete(T val) {
	
		if(this.head == null) return;
		if(this.head.data == val && this.head.next == null) {
			this.head = null;
		}
		else if(this.head.next == null) return;
		else if(head.data == val){
			Node x = head.next;
			head = x;
			
		}else {
			Node n = head;
			while(n != null) {
				if(n.next.data == val ) {
					Node x = n.next.next;
					n.next = x;
				}
				n = n.next;
			}
			
		}
	}
	
	public int length() {
		int len = 0;
		Node currentNode = this.head;
		while(currentNode != null) {
			System.out.println(currentNode.data);
			len++;
			currentNode = currentNode.next;
		}
		return len;
	}
	
	public static void main(String[] args) {
		LinkedList a = new LinkedList();
		a.add(1);
		a.add(2);
		a.add(3);
		a.put(4);
		a.put(5);
		a.put(6);
		
		a.delete(3);
		
		System.out.println("LEN --- "+a.length());
		
		//System.out.println(a.contains(6));
		//System.out.println(a.contains(1));
		//System.out.println("Accending-------------");
		//a.printAsc();
		//System.out.println("Decending-------------");
		//a.printDec();
	}

}
