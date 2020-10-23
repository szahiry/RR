import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//import LinkedList.Node;

public class RoundRobin {
	
	private class Node{
		private int A ; int B;
		private Node next, prev;
		private Node (int A, int B, Node next, Node prev) {
			this.A = A;
			this.B = B;
			this.next = next;
			this.prev = prev;
		}
	}
	
	private Node cursor;
	private long size;
	
	public RoundRobin() {
		cursor = new Node(0, 0, null,null);
		this.cursor.next = this.cursor;
		this.cursor.prev = this.cursor;
		this.size = 0;
	}
	
	public void addFirst(int A, int B) {
		Node newNode = new Node(A, B, this.cursor.prev, this.cursor);
		this.cursor.prev = newNode;
		//this.cursor.next = newNode;
		this.size ++;
	}
	
	public void addLast(int A,int B) {
		Node newNode = new Node(A,B,this.cursor.prev, this.cursor);
		this.cursor.prev.next = newNode;
		//this.cursor.prev = newNode;
		this.size++;
	}
	
	public int[] removeFirst() {
		if(this.size == 0)
			return null;
		
		int[] Array; int A; int B;
		Node cur = this.cursor.next;
		int A = cur.A;
		this.cursor.next = cur.next;
		cur.next.prev = this.cursor;
		this.size--;
		return Array ;
	}
	
	public Object removeLast() {
		if (this.size == 0) {
			return null;
		}
		
		int[] Array; int A; int B;
		Node cur = this.cursor.prev;
		int B = cur.B;
		cur.prev.next = this.cursor;
		this.cursor.prev = cur.prev;
		this.size--;
		return Array;
	}
	
	public boolean isEmpty() {
		return this.cursor == this.cursor.next;
	}
	
	@Override
	public String toString() {

		String newString = "";

		for (Node cur = this.cursor.next; cur != this.cursor; cur = cur.next) {

			newString += String.valueOf(cur.A) + " ";
		}
		return newString;
	}

	
	
	public static void main(String[] args) throws FileNotFoundException{
		RoundRobin linkedList = new RoundRobin();
		
		String fileName = "data.txt";

		RoundRobin.fillArray(fileName, 5);
		//System.out.println("Please enter the file name.");
		System.out.println(linkedList);
		
		
	}
	public static void fillArray(String fileName, int runTime) throws FileNotFoundException {
		Scanner newFile = new Scanner(new File(fileName));//variable that will take in file
		//ArrayList<Integer> numbers = new ArrayList<Integer>();

		while(newFile.hasNext()){
			String element = newFile.nextLine();
			//add(element);
			//int currentNum = newFile.nextInt();
			//numbers.add(currentNum);
		}
		newFile.close();
		//return numbers;

	}//end of fillArray method.


	
	
}
	
