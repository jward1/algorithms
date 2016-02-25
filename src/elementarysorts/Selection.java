package elementarysorts;

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
				if (less( a[j], min) )
				{
					min_ix = j;
					min = a[j];
				}
			}
			exch(a, min_ix, i);
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
		String[] test1 = {"S", "O", "R", "T"};
		sort(test1);
		assert isSorted(test1);
		show(test1);

		Integer[] test2 = { 2, 3, 8, 4, 9, 5, 1};
		sort(test2);
		assert isSorted(test2);
		show(test2);
	}
}