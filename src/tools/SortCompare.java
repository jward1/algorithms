package tools;

import elementarysorts.Insertion;
import elementarysorts.Selection;
import elementarysorts.Shell;
import mergesort.Merge;
import mergesort.MergeBottomUp;
import quicksort.Quick;
import quicksort.Quick3way;
import priorityqueues.Heapsort;

import java.util.Random;

public class SortCompare
{
	public static double time(String alg, Double[] a)
	{
		Stopwatch timer = new Stopwatch(); // starts timer
		if (alg.equals("Insertion")) Insertion.sort(a);
		if (alg.equals("Selection")) Selection.sort(a);
		if (alg.equals("Shell")) 	 Shell.sort(a);
		if (alg.equals("Merge"))	 Merge.sort(a);
		if (alg.equals("MergeBottomUp")) MergeBottomUp.sort(a);
		if (alg.equals("Quick")) Quick.sort(a);
		if (alg.equals("Quick3way")) Quick3way.sort(a);
		if (alg.equals("Heapsort")) Heapsort.sort(a);
		return timer.elapsedTime();
	}

	public static double timeRandomInput(String alg, int N, int T)
	{
		// use alg to sort T random arrays of length N
		double totalTime = 0.0;
		Double[] a = new Double[N];
		Random rand = new Random(42);

		for (int t=0; t<T; t++)
		{
			for (int i=0; i<N; i++)
			{
				a[i] = rand.nextDouble();
			}
			totalTime += time(alg, a);
		}
		return totalTime;
	}

	public static void main(String[] args)
	{
		String algo1 = args[0];
		String algo2 = args[1];
		int N = Integer.parseInt(args[2]);
		int T = Integer.parseInt(args[3]);
		double t1 = timeRandomInput(algo1, N, T);
		double t2 = timeRandomInput(algo2, N, T);
		System.out.printf("For %d random Doubles...\n", N);
		System.out.printf("%s took an average of %.3f seconds\n", algo1, t1/T);
		System.out.printf("%s took an average of %.3f seconds\n", algo2, t2/T);
		if ( t1 < t2 ) {
			System.out.printf("%s is %.2f times faster than %s\n", algo1, t2/t1, algo2);
		} else {
			System.out.printf("%s is %.2f times faster than %s\n", algo2, t1/t2, algo1);
		}
	}
}