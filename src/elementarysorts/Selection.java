package elementarysorts;

import tools.Tools;

public class Selection
{	
	/*
	 * Sorts array from smallest to largest
	 */
	public static void sort(Comparable[] a)
	{	
		for (int i=0; i<a.length; i++)
		{	
			Comparable min = a[i];
			int min_ix = i;
			for (int j = i+1; j<a.length; j++)
			{
				if (Tools.less( a[j], min) )
				{
					min_ix = j;
					min = a[j];
				}
			}
			Tools.exch(a, min_ix, i);
		}
	}

	public static void main(String[] args)
	{
		String[] test1 = {"S", "O", "R", "T"};
		sort(test1);
		assert Tools.isSorted(test1);
		Tools.show(test1);

		Integer[] test2 = { 2, 3, 8, 4, 9, 5, 1};
		sort(test2);
		assert Tools.isSorted(test2);
		Tools.show(test2);
	}
}