package quicksort;

import java.util.Random;
import tools.Tools;

public class Quick 
{
	/**
	 * Sorts the elements of the specifiec array in ascending order.
	 *
	 * @param  a the array of a Comparable data type to be sorted
	 * @throws NullPointerException if <tt>a</tt> is <tt>null</tt>
	 */
	public static void sort(Comparable[] a)
	{
		shuffle(a); // shuffle array to ensure against worst-case performance
		sort(a, 0, a.length-1);
	}

	private static void sort(Comparable[] a, int lo, int hi)
	{
		if (hi <= lo) return;
		int j = partition(a, lo, hi);	// create partitions
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}

	private static int partition(Comparable[] a, int lo, int hi)
	{
		int i = lo;
		int j = hi+1;
		Comparable val = a[lo];

		while (true)
		{
			// scan from left
			while (Tools.less(a[++i], val)) if (i==hi) break;
			// scan from right
			while (Tools.less(val, a[--j])) if (j==lo) break;
			// make sure i cursor has not passed j cursor
			if (i >= j) break;
			// exchange ith and jth values
			Tools.exch(a, i, j);
		}
		// swap value to the jth position
		Tools.exch(a, lo, j);
		return j;
	}


	/**
	 * Rearranges the elements of the specified array in uniformly random order.
	 *
	 * @param  a the array to shuffle
	 * @throws NullPointerException if <tt>a</tt> is <tt>null</tt>
	 */
	private static void shuffle(Comparable[] a) {
	    if (a == null) throw new NullPointerException("argument array is null");
	    Random rand = new Random();
	    int n = a.length;
	    for (int i = 0; i < n; i++) {
	        int r = i + rand.nextInt(n-i);  // between i and n-1
	        Comparable temp = a[i];
	        a[i] = a[r];
	        a[r] = temp;
	    }
	}

	public static void main(String[] arsgs)
	{
		String[] test = {"zzz", "yyy", "xxx", "www", "ddd", "ccc", "bbb", "aaa"};
		sort(test);
		Tools.show(test);

		Integer[] test2 = {1, 4, 6, 3, 8, 10, 12, 0, -4};
		sort(test2);
		Tools.show(test2);
	}

}