package unionfind;

import java.util.Scanner;
import tools.Stopwatch;

public class WeightedQuickUnion implements UF 
{
	private int[] id;  // access to component id
	private int[] sz;  // size of associated component
	private int num;   // number of components
	
	public WeightedQuickUnion(int N)
	{
		if (N < 0) { throw new IllegalArgumentException(); }
		num = N;
		id = new int[N];
		sz = new int[N];
		for (int i = 0; i<N; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}

	public void union(int p, int q)
	{
		int i = find(p);
		int j = find(q);
		if (i == j) return;
		// check size; add smaller num to larger num
		if (sz[i] <= sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} 
		else {
			id[j] = i;
			sz[i] += sz[j];
		}
		num--;
	}

	public int find(int p)
	{
		validate(p);
		while (p != id[p]) p = id[p];
		return p;
	}

	public boolean connected(int p, int q) { return find(p) == find(q); }
	public int count() { return num; }

	private void validate(int p) throws IndexOutOfBoundsException
	{
		int N = id.length;
		if (p < 0 || p >= N) {
			throw new IndexOutOfBoundsException("Index " + p + " is not between 0 and " + (N-1));
		}
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(); // get number of sites to read

		Stopwatch timer = new Stopwatch(); // starts timer
		UF uf = new WeightedQuickUnion(N);
		while(in.hasNextInt())
		{
			int p = in.nextInt();
			int q = in.nextInt();
			if (uf.connected(p, q)) { continue; }
			uf.union(p, q);
			//System.out.println(p + " " + q);
		}

		System.out.println(uf.count() + " components");
		System.out.println("WeightedQuickUnion took " + timer.elapsedTime() + " seconds.");
	}
}