package mergesort;

import tools.Tools;

public class Merge 
{
	private static Comparable[] aux;

	/*
	 * Merge sort. Takes sorts arrays of a datatype that implements the Comparable
	 * class (e.g., String, Interger, Double). This implementation uses a top-down
	 * approach and uses an auxillary array to help in the sorting. That is, it takes
	 * twice the Memory as sorting the array in-place. It runs NlogN.
	 * @params a Takes an (unsorted) array of a Comparable data type
	 */
	public static void sort(Comparable[] a)
	{
		aux = new Comparable[a.length]; // allocates space for auxillary array
		sort(a, 0, a.length-1);
	}

	private static void sort(Comparable[] a, int lo, int hi)
	{	// recurively sort and merge subarrays
		if (hi <= lo) { return; }
		int mid = lo + (hi - lo)/2;
		sort(a, lo, mid);
		sort(a, mid+1, hi);
		merge(a, lo, mid, hi);
	}

	private static void merge(Comparable[] a, int lo, int mid, int hi)
	{
		int i = lo;
		int j = mid+1;

		// copy to auxillary array
		for (int k=lo; k<=hi; k++)
			aux[k] = a[k];

		// merge results back to a[]
		for (int k=lo; k<=hi; k++)
		{
			if (i > mid) { a[k] = aux[j++]; } // left array is exhausted
			else if (j > hi) { a[k] = aux[i++]; } // right array is exhausted
			else if (Tools.less(aux[i], aux[j])) { a[k] = aux[i++]; }
			else { a[k] = aux[j++]; }
		}
	}

	public static void	main(String[] args)
	{
		String[] test = {"zzz", "aaa", "yyy", "bbb", "xxx", "ccc", "www", "ddd"};
		sort(test);
		Tools.show(test);
	}

}