package elementarysorts;

import java.util.Scanner;
import java.util.ArrayList;

import tools.Tools;

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
			Comparable temp = a[i];
			int ix = i;
			for (int j=i-1; j>=0 && Tools.less(temp, a[j]); j-- )
			{
				a[j+1] = a[j];
				ix = j;
			}
			a[ix] = temp;
		}
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
		Tools.show(test);
		sort(test);
		assert Tools.isSorted(test);
		Tools.show(test);

		
		String[] test1 = {"E", "X", "A", "M", "P", "L", "E"};
		sort(test1);
		assert Tools.isSorted(test1);
		Tools.show(test1);

		Integer[] test2 = { 2, 3, 8, 4, 9, 5, 1};
		sort(test2);
		assert Tools.isSorted(test2);
		Tools.show(test2);

		String[] test3 = { "bbb", "zzz", "ccc", "ddd", "eee"};
		sort(test3);
		assert Tools.isSorted(test3);
		Tools.show(test3);
	}
}