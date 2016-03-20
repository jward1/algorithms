package priorityqueues;

public class MaxPQ<Key extends Comparable<Key>>
{
	private Key[] pq;	// heap-ordered complete binary tree
	private int N = 0;	// number of entries

	/**
	 * 
	 * @param maxN The maximum number of elements that can be passed to the priority queue
	 */
	public MaxPQ(int maxN)
	{
		this.pq = (Key[]) new Comparable[maxN+1];
	}

	public boolean isEmpty()
	{
		return this.N == 0;
	}

	public int size()
	{
		return this.N;
	}

	public void insert(Key v)
	{
		pq[++N] = v;
		swim(N);
	}

	public Key delMax()
	{
		Key max = this.pq[1];
		exch(1, this.N--); 			// decrease counter by 1
		this.pq[this.N+1] = null	// ensure removal of max
		sink(1);					// restore ordering in heap
		return max;					// return max to user
	}

	private boolean less(int i, int j)
	{
		return this.pq[i].compareTo(this.pq[j]) < 0 ;
	}

	private void exch(int i, int j)
	{
		Key temp = this.pq[i];
		this.pq[i] = this.pq[j];
		this.pq[j] = temp;
	}

	private void swim(int k)
	{
		while (k > 1 && less(k/2, k) )
		{
			exch(k/2, k);
			k = k/2;
		}
	}

	private void sink(int k)
	{
		while (2*k <= N)
		{
			int j = 2*k;
			if ( j<N && less(j, j+1) ) 	j++ ; 	// find bigger of two children
			if ( !less(k, j) ) break;			// k > children, stop sink
			exch(k, j);
			k = j
		}
	}

}