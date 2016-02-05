import java.io.*;
import java.util.Random;

public class ThreeSum
{
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

	public static void main(String[] args) throws FileNotFoundException
	{
		int N = Integer.parseInt(args[0]);
		Random rand = new Random();

		int[] a = new int[N]; // first line of file contains number of ints
		for (int i=0; i<a.length; i++){
			a[i] = rand.nextInt(2000000)-1000000; // generates rand int between -1000000 and 1000000
		}

		long start = System.currentTimeMillis();
		int c = count(a);
		long finish = System.currentTimeMillis();

		System.out.println(c + " triples " + (finish - start)/1000.0 + " seconds");
	}
}