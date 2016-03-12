package tools;

import java.util.Random;

public class Tools
{
	public static boolean less(Comparable v, Comparable w)
	{ 
		return v.compareTo(w) < 0 ;
	}

	public static void exch(Comparable[] a, int v, int w)
	{
		Comparable temp = a[v];
		a[v] = a[w];
		a[w] = temp;
	}

	public static boolean isSorted(Comparable[] a)
	{
		for (int i=1; i<a.length; i++) 
		{
			if (less(a[i], a[i-1])) { return false; }
		}
		return true;
	}

	public static void show(Comparable[] a)
	{
		for (int i=0; i<a.length; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	/**
	 * Rearranges the elements of the specified array in uniformly random order.
	 *
	 * @param  a the array to shuffle
	 * @throws NullPointerException if <tt>a</tt> is <tt>null</tt>
	 */
	public static void shuffle(Comparable[] a) {
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
}