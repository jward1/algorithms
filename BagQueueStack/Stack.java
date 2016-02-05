import java.util.Iterator;
import java.io.*;

public class Stack<Item> implements Iterable<Item>
{
	private Node first;
	private int N = 0;
	
	// Node class
	private class Node
	{
		Item item;
		Node next;
	}

	// implement Stack class
	public int size() { return N; }
	public boolean isEmpty() { return first == null; }

	public void push(Item item)
	{
		Node newNext = first;
		first = new Node();
		first.item = item;
		first.next = newNext;
		N++;
	}

	public Item pop()
	{
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}

	public Item peek()
	{
		return first.item;
	}


	// implement Iterator
	public Iterator<Item> iterator()
	{
		return new StackIterator();
	}

	private class StackIterator implements Iterator<Item>
	{
		private Node current = first;

		public boolean hasNext() { return current != null; }
		public void remove() {  }
		public Item next() 
		{
			Item item = current.item;
			this.current = current.next;
			return item;
		}
	}


	// test the class implementation
	public static void main(String[] args)
	{
		Stack<String> a = new Stack<String>();
		
		if (a.isEmpty()) { System.out.println("SUCCESS: created an empty Stack"); }
		else { System.out.println("ERROR: failed to create an empty Stack"); }
		
		a.push("world");
		a.push("hello");

		if (a.size() == 2) { System.out.println("SUCCESS: added two elements"); }
		else { System.out.println("ERROR: failed to add elements"); }

		for (String s : a) { System.out.println(s); }


		if (!a.pop().equals("hello")) { System.out.println("ERROR: expected 'hello' but found something else."); }
		if (!a.pop().equals("world")) { System.out.println("ERROR: expected 'world' but found something else."); }

		if (a.size() == 0) { System.out.println("SUCCESS: removed items from Stack"); }
		else {System.out.println("ERROR:failed to remove items from Stack"); }

		if (a.isEmpty()) { System.out.println("SUCCESS: emptied Stack"); }
		else {System.out.println("ERROR: failed to empty Stack"); }

	}

}