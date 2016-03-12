package quicksort;

import java.util.Random;
import tools.Tools;

public class Quick3way
{	
	/**
	* Sorts the elements of the specifiec array in ascending order.
	* Quick3way sort is good for sorting arrays with lots of repeating
	* elements.
	*
	* @param  a the array of a Comparable data type to be sorted
	* @throws NullPointerException if <tt>a</tt> is <tt>null</tt>
	*/
	public static void sort(Comparable[] a)
	{
		Tools.shuffle(a);
		sort(a, 0, a.length-1);
	}

	private static void sort(Comparable[] a, int lo, int hi)
	{
		if (hi <= lo) return;

		int lt = lo; 			// less than marker
		int i = lo +1; 			// cursor
		int gt = hi; 			// greater than marker
		Comparable val = a[lo]; //partition value

		// sort into 3 partitions
		/*
			a[lo, ..., lt-1] < val
			a[lt, ..., gt] = val
			a[gt+1, ..., hi] > val
		*/
		while (i <= gt )
		{
			int temp = a[i].compareTo(val);
			if (temp < 0) Tools.exch(a, lt++, i++);
			else if (temp > 0) Tools.exch(a, gt--, i);
			else i++;
		}

		// sort partitions less than or greater than val
		sort(a, lo, lt-1);
		sort(a, gt+1, hi);
	}

	public static void main(String[] args)
	{
		String[] test = {"aaa", "sss", "ddd", "fff", "ggg", "hhh"};
		sort(test);
		Tools.show(test);
	}

	
}