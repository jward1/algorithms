package elementarysorts;

import tools.Tools;

public class Shell
{
	public static void sort(Comparable[] a)
	{
		int N = a.length;
		int h = 1;  // increments for h-sort

		// set value of h
		while (h < N/3) { h = 3*h + 1; } // 1, 4, 13, 40, etc...

		// sort array
		while (h >= 1)
		{
			for (int i=h; i<N; i++)
			{
				for (int j=i; j>=h && Tools.less(a[j], a[j-h]); j -= h )
					Tools.exch(a, j, j-h);
			}
			h = h/3;	
		}
	}

	public static void main(String[] args)
	{
		String[] test1 = {"zzz", "ddd", "aaa", "bbb", "ccc", "jjj", "iii", "yyy"};
		sort(test1);
		assert Tools.isSorted(test1);
		Tools.show(test1);

		Integer[] test2 = {4, 3, 6, 1, 5, 8, 2, 7, 9, 0};
		sort(test2);
		assert Tools.isSorted(test2);
		Tools.show(test2);
	}
}