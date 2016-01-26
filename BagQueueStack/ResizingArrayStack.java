import java.util.Iterator;
import java.io.*;

public class ResizingArrayStack<Item> implements Iterable<Item>
{
	private Item[] a = (Item[]) new Object[1]; //must case object array to be array of type Item
	private int N = 0; // number of items in array

	public boolean isEmpty() { return N == 0; }
	public int size() { return N; }

	private void resize(int max)
	{	// resize stack
		Item[] temp = (Item[]) new Object[max];
		for (int i=0; i<N; i++){
			temp[i] = a[i];
		}
		a = temp;
	}

	private void push(Item item)
	{	// add item to the top of the stack
		if (N == a.length) { resize(a.length*2); }
		a[N++] = item; 	// NOTE: N++ uses current value of N for the array assignment
						// and then adds one to N, e.g., a[0], N=N+1
	}

	private Item pop()
	{	// remove item from the top of the stack
		Item item = a[--N]; // decrease N by one, and then grab item at N'
		a[N] = null; // to avoid loitering data
		if (N > 0 && N == a.length/4) { resize(a.length/2); }
		return item;
	}

	public Iterator<Item> iterator()
	{
		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator implements Iterator<Item>
	{
		private int i = N;
		public boolean hasNext() { return i > 0; }
		public Item next() { return a[--i]; }
		public void remove() { } // intentionally left empty
	}

	public static void main(String[] args)
	{
		ResizingArrayStack<String> s = new ResizingArrayStack<String>();
		String test = "Hello, World! This is a test string.";
		String[] t = test.split(" ");
		for (String word : t){
			s.push(word);
		}

		for (String item : s){
			System.out.println(item);
		}

	}
}