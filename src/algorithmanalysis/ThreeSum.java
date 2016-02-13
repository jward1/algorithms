package algorithmanalysis;

import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

import binarysearch.BinarySearch;

public class ThreeSum
{	
	private static final int BOUND = 1000000;
	
	private static int[] genRandomUniqueIntArray(int sz)
	{
		int[] randUniq = new int[sz]; 
		// create a list of integers from lower bound to upper bound
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i=-BOUND; i<=BOUND; i++){
			list.add(new Integer(i));
		}
		// randomly shuffle the list; can also create a Random object 
		// if you want to specify the source of randomness
		Collections.shuffle(list);
		// grab the first N numbers to get a random, unique list of ints
		for (int j=0; j<sz; j++) {
			randUniq[j] = list.get(j);
		}
		return randUniq; 
	}

	public static int count(int[] b)
	{
		// BRUTE FORCE SEARCH
		// runs in N^3 time

		int N = b.length;
		int cnt = 0; // number of triples that sum to zero
		
		// brute force search
		for (int i = 0; i<N; i++) 
			for (int j=i+1; j<N; j++) 
				for (int k=j+1; k<N; k++) 
					if (b[i] + b[j] + b[k] == 0) { cnt++; }
		return cnt;
	}

	public static int countFast(int[] b)
	{
		int N = b.length;
		int cnt = 0;
		Arrays.sort(b); // array must be sorted in order to use BinarySearch
		for (int i=0; i<N; i++)
			for (int j=i+1; j<N; j++)
				// make sure new "k" is greater than 'j'
				if (BinarySearch.rank(-b[i]-b[j], b) > j) { cnt++; }
		return cnt;
	}


	public static int countFasterStill(int[] b)
	{
		int N = b.length;
		int cnt = 0;
		Arrays.sort(b);
		
		for (int i=0; i<N; i++)
		{ 
			int k = N - 1;
			
			for (int j=i+1; j<N; j++)
			{
				/*
				System.out.println("i: " + i);
				System.out.println("j: " + j);
				System.out.println("k: " + k);
				System.out.println("i: " + i + " b[i]: " + b[i]);
				System.out.println("j: " + j + " b[j]: " + b[j]);
				System.out.println("k: " + k + " b[k]: " + b[k]);
				int temp = b[i] + b[j] + b[k];
				System.out.println("sum: " + temp);
				System.out.println();
				*/
				
				while ( (b[k] > -(b[i] + b[j])) && (j < k) ) { k--; }
				if (b[i] + b[j] + b[k] == 0 ) { cnt++; }
			}

		}
		return cnt;
	}

	public static void main(String[] args) throws IllegalArgumentException
	{
		int N = Integer.parseInt(args[0]);
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
		int c3 = countFasterStill(a);
		long finish3 = System.currentTimeMillis();
		System.out.println(c3 + " triples " + (finish3 - start3)/1000.0 + " seconds with countFasterStill");
	}
}