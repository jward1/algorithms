package mergesort;

import elementarysorts.ElementarySort;

public class MergeBottomUp
{
	private static Comparable[] aux;

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
			else if (ElementarySort.less(aux[i], aux[j])) { a[k] = aux[i++]; }
			else { a[k] = aux[j++]; }
		}
	}

	public static void sort(Comparable[] a)
	{
		int N = a.length;
		aux = new Comparable[N];
		for (int sz=1; sz<N; sz=2*sz)
			for (int lo=0; lo<N-sz; lo += sz+sz)
				merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
	}

	public static void main(String[] args)
	{
		String[] test = {"zzz", "aaa", "yyy", "bbb", "xxx", "ccc", "www", "ddd"};
		sort(test);
		ElementarySort.show(test);
	}
}