package algorithmanalysis;

import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

import binarysearch.BinarySearch;

public class ThreeSum
{	
	private static final int BOUND = 100000;
	
	private static int[] genRandomUniqueIntArray(int sz)
	{
		int[] randUniq = new int[sz];

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i=-BOUND; i<=BOUND; i++){
			list.add(new Integer(i));
		}
		Collections.shuffle(list); // can also specify source of randomness, if wanted
		for (int j=0; j<sz; j++) {
			randUniq[j] = list.get(j);
		}
		return randUniq; 
	}

	public static int count(int[] b)
	{
		int N = b.length;
		int cnt = 0; // number of triples that sum to zero
		for (int i = 0; i<N; i++) {
			for (int j=i+1; j<N; j++) {
				for (int k=j+1; k<N; k++) {
					if (b[i] + b[j] + b[k] == 0) {
						cnt++;
					}
				}
			}
		}
		return cnt;
	}

	public static int countFast(int[] b)
	{
		int N = b.length;
		int cnt = 0;
		Arrays.sort(b);
		for (int i=0; i<N; i++) {
			for (int j=i+1; j<N; j++) {
				// make sure new "k" is greater than 'j' to avoid double counting
				if (BinarySearch.rank(-b[i]-b[j], b) > j) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static int countFasterStill(int[] b)
	{
		int N = b.length;
		int cnt = 0;
		Arrays.sort(b);
		int ix = N - 1; //start search index in last element of array
		for (int i=0; i<N; i++){
			while (ix >= 0 - b[i] ){
				if (b[i] - b[ix] == 0) { 
					cnt++; 
				}
				ix++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IllegalArgumentException
	{
		int N = Integer.parseInt(args[0]);

		if (N > BOUND) { 
			throw new IllegalArgumentException("Please enter a number smaller than " + BOUND); 
		}

		int[] a = genRandomUniqueIntArray(N);

		// with count method
		long start1 = System.currentTimeMillis();
		int c1 = count(a);
		long finish1 = System.currentTimeMillis();
		System.out.println(c1 + " triples " + (finish1 - start1)/1000.0 + " seconds with count");

		// with countFast method
		long start2 = System.currentTimeMillis();
		int c2 = countFast(a);
		long finish2 = System.currentTimeMillis();
		System.out.println(c2 + " triples " + (finish2 - start2)/1000.0 + " seconds with countFast");

		// with countFasterStill method
		long start3 = System.currentTimeMillis();
		int c3 = countFast(a);
		long finish3 = System.currentTimeMillis();
		System.out.println(c3 + " triples " + (finish3 - start3)/1000.0 + " seconds with countFasterStill");
	}
}