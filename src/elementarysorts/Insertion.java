package elementarysorts;

import java.util.Scanner;
import java.util.ArrayList;

public class Insertion
{
	/*
	 * Sorts array from smallest to largest
	 */
	public static void sort(Comparable[] a)
	{	
		int N = a.length;
		for (int i=1; i<N; i++)
		{
			for (int j=i; j>0 && less(a[j], a[j-1]); j-- )
			{
				exch(a, j, j-1);
			}
		}
	}

	private static boolean less(Comparable v, Comparable w)
	{ 
		return v.compareTo(w) < 0 ;
	}

	private static void exch(Comparable[] a, int v, int w)
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

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		ArrayList<String> l = new ArrayList<String>();
		while ( sc.hasNext() )
		{
			l.add(sc.next());
		}

		String[] test = l.toArray(new String[l.size()]);
		show(test);
		sort(test);
		assert isSorted(test);
		show(test);

		/*
		String[] test1 = {"E", "X", "A", "M", "P", "L", "E"};
		sort(test1);
		assert isSorted(test1);
		show(test1);

		Integer[] test2 = { 2, 3, 8, 4, 9, 5, 1};
		sort(test2);
		assert isSorted(test2);
		show(test2);

		String[] test3 = { "bbb", "zzz", "ccc", "ddd", "eee"};
		sort(test3);
		assert isSorted(test3);
		show(test3);
		*/
	}
}