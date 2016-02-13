package unionfind;

public interface UF 
{
	/*
	 * connect to sets
	 * to be implemented in subclasses
	 * remember to decrement count (i.e., count--;)
	 */
	public void union(int p, int q);

	/* 
	 * find site p in array
	 * to be implemented in subclasses
	 */
	public int find(int p);

	/*
	 *
	 */
	public boolean connected(int p, int q);

	/*
	 *
	 */
	public int count();

}