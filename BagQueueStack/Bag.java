// BagQueueStack/Bag.java
import java.util.Iterator;

public class Bag<Item> implements Iterable<Item>
{
	private Node first;
	private int N = 0;

	private class Node
	{
		Item item;
		Node next;
	}

	public boolean isEmpty() { return first == null; }
	public int size() { return N; }

	public void add(Item item)
	{
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}

	public Iterator<Item> iterator()
	{
		return new BagIterator();
	}

	private class BagIterator implements Iterator<Item>
	{
		Node current = first;

		public void remove() {   }
		public boolean hasNext() { return current != null; }
		public Item next() 
		{
			Item item = current.item;
			current = current.next;
			return item;
		}
	}


	public static void main(String[] args)
	{
		Bag<Integer> b = new Bag<Integer>();

		if (b.isEmpty()) { System.out.println("SUCCESS: created an empty Bag"); }
		else { System.out.println("ERROR: failed to create an empty Bag"); }
		
		b.add(1);
		b.add(2);
		b.add(3);
		b.add(4);

		if (b.size() == 4) { System.out.println("SUCCESS: added four elements"); }
		else { System.out.println("ERROR: failed to add elements"); }

		for (int i : b) { System.out.println(i); }
	}

}