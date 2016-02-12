package binarysearch;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch
{

	public static int rank(int key, int[] a)
	{
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi)
		{
			int mid = lo + (hi - lo) / 2;
			if 		(key < a[mid]) hi = mid - 1;
			else if (key > a[mid]) lo = mid + 1;
			else return mid;
		}
		return -1;
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner s = new Scanner(new File(args[0]));
		int[] whitelist = new int[s.nextInt()]; // first line of file contains number of ints
		for (int i=0; i<whitelist.length; i++){
			whitelist[i] = s.nextInt();
		}
		Arrays.sort(whitelist);

		Scanner in = new Scanner(System.in);
		while (in.hasNextInt())
		{
			int key = in.nextInt();
			System.out.println(key);
			if (rank(key, whitelist) == -1){
				System.out.println(key);
			}
		}
	}

}