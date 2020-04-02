package Structures;

public class BinaryNode {
	
	BinaryNode left, right;
	
	Integer data;
	
	public void insert(int val){
		if(data == null || data == val) data = val;
		else if(val < data) {
			if(left == null ) {
				left = new BinaryNode();
			}
			left.insert(val);
		}
		else{
			if(right == null ) right = new BinaryNode();
			right.insert(val);
		}
	}
	
	public boolean contains(int val){
		
		if(data == null) return false;
		else if(data == val) return true;
		else if(val < data){
			if(left == null ) return false;
			else return left.contains(val);
		}
		else{
			if(right == null ) return false;
			else return right.contains(val);
		}
	}
	
	public void printAsc(){
		if(left != null) left.printAsc(); 
		System.out.println(data);
		
		if(right != null){
			right.printAsc();
		}
	}
	
	public void printDec(){
		if(right != null) right.printDec(); 
		System.out.println(data);
		
		if(left != null){
			left.printDec();
		}
	}
	
	public static void main(String[] args){
		BinaryNode a = new BinaryNode();
		a.insert(10);
		a.insert(8);
		a.insert(6);
		a.insert(12);
		a.insert(2);
		a.insert(15);
		
		System.out.println(a.contains(6));
		System.out.println(a.contains(1));
		System.out.println("Accending-------------");
		a.printAsc();
		System.out.println("Decending-------------");
		a.printDec();
	}

}
