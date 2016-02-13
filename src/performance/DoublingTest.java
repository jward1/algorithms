package performance;

/*
 * NEED TO IMPORT OBJECT YOU WANT TO RUN TEST ON
 * as an example, I will use ThreeSum
 */
import java.util.Random;
import java.io.PrintStream;
import algorithmanalysis.ThreeSum;

public class DoublingTest
{

	public static double timeTrial(int N)
	{
		int MAX = 1000000;
		Random rand = new Random();
		int[] a = new int[N];

		for (int i=0; i<N; i++){
			a[i] = rand.nextInt(MAX * 2) - MAX;
		}

		Stopwatch timer = new Stopwatch(); // starts timer
		int count = ThreeSum.countFasterStill(a); // UPDATE THIS METHOD FOR TESTING
		return timer.elapsedTime();
	}

	public static void main(String[] args)
	{
		System.out.println("\n[*] Press ctrl+c to terminate DoublingTest...");
		System.out.println("[*] Beginning test...\n");

		double prev = timeTrial(125); // to start doubling ratio

		for (int N = 250; true; N += N)
		{
			double time = timeTrial(N);
			System.out.printf( "[+] %8d %5.2f %5.2f\n", N, time, time/prev);
			prev = time;
		}
	}
}