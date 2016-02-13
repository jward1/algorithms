package unionfind;

import java.util.Scanner;
import performance.Stopwatch;

public class UFQuickUnion implements UF 
{
	private int[] id;  // access to component id
	private int num; // number of components

	public UFQuickUnion(int N)
	{
		this.num = N;
		this.id = new int[N];
		for (int i = 0; i<N; i++)
			this.id[i] = i;
	}

	public void union(int p, int q)
	{
		int i = find(p);
		int j = find(q);
		if (i == j) return; 
		id[i] = j;
		this.num--;
	}

	public int find(int p)
	{
		while (p != id[p]) p = id[p];
		return p;
	}

	public boolean connected(int p, int q) { return find(p) == find(q); }
	public int count() { return num; }

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(); // get number of sites to read

		Stopwatch timer = new Stopwatch(); // starts timer
		UF uf = new UFQuickUnion(N);
		while(in.hasNextInt())
		{
			int p = in.nextInt();
			int q = in.nextInt();
			if (uf.connected(p, q)) { continue; }
			uf.union(p, q);
			//System.out.println(p + " " + q);
		}

		System.out.println(uf.count() + " components");
		System.out.println("QuickUnion took " + timer.elapsedTime() + " seconds.");
	}
}