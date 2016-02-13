package unionfind;

import java.util.Scanner;

public class UFQuickFind implements UF
{
	private int[] id;  // access to component id
	private int num; // number of components

	public UFQuickFind(int N)
	{
		this.num = N;
		this.id = new int[N];
		for (int i = 0; i<N; i++)
			this.id[i] = i;
	}

	public void union(int p, int q)
	{
		int pID = find(p);
		int qID = find(q);

		if (pID == qID) { return; }

		for (int i=0; i<this.id.length; i++)
			if (this.id[i] == pID) { this.id[i] = qID; }

		this.num--;
	}

	public int find(int p)
	{
		return this.id[p];
	}

	public boolean connected(int p, int q) { return find(p) == find(q); }
	public int count() { return num; }

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(); // get number of sites to read

		UF uf = new UFQuickFind(N);
		while(in.hasNextInt())
		{
			int p = in.nextInt();
			int q = in.nextInt();
			if (uf.connected(p, q)) { continue; }
			uf.union(p, q);
			System.out.println(p + " " + q);
		}

		System.out.println(uf.count() + " components");
	}
}