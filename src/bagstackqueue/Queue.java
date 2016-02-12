package bagstackqueue;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item>
{
	private Node first; // node at the front of the queue
	private Node last; // last node added to queue
	private int N = 0; // number of nodes in queue

	private class Node
	{
		Item item;
		Node next;
	}

	public boolean isEmpty() { return first == null; }
	public int size() { return N; }

	public void enqueue(Item item) 
	{
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) { first = last; }
		else { oldLast.next = last; }
		N++;
	}

	public Item dequeue()
	{
		Item item = first.item;
		first = first.next;
		N--;
		if (isEmpty()) { last = null; }
		return item;
	}


	// implement Iterator
	public Iterator<Item> iterator()
	{
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<Item>
	{
		private Node current = first;

		public void remove() {  }
		public boolean hasNext() { return current != null; }
		public Item next()
		{
			Item item = current.item;
			current = current.next;
			return item;
		} 
	}


	// test the Queue class implementation
	public static void main(String[] args)
	{
		Queue<String> q = new Queue<String>();

		if (q.isEmpty()) { System.out.println("SUCCESS: created an empty Queue"); }
		else { System.out.println("ERROR: failed to create an empty Queue"); }
		
		q.enqueue("first");
		q.enqueue("second");
		q.enqueue("third");

		if (q.size() == 3) { System.out.println("SUCCESS: added three elements"); }
		else { System.out.println("ERROR: failed to add elements"); }

		for (String s : q) { System.out.println(s); }

		if (!q.dequeue().equals("first")) { System.out.println("ERROR: expected 'first' but found something else."); }
		if (!q.dequeue().equals("second")) { System.out.println("ERROR: expected 'second' but found something else."); }

		if (q.size() == 1) { System.out.println("SUCCESS: removed items from Queue"); }
		else {System.out.println("ERROR:failed to remove items from Queue"); }

		if (!q.dequeue().equals("third")) { System.out.println("ERROR: expected 'third' but found something else."); }		

		if (q.isEmpty()) { System.out.println("SUCCESS: emptied Queue"); }
		else {System.out.println("ERROR: failed to empty Queue"); }
	}

}