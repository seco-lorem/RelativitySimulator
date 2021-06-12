package universe;

public abstract class Static extends Entity
{
	// Properties
	int[] edges;	// x1 , t1 , x2 , t2

	// Constructors
	public Static()
	{
		edges = new int[4];
	}
	
	// Methods
	@Override
	public boolean contains(int x, int t)
	{
		return Math.abs(edges[0] - x) == Math.abs(edges[2] - x) && Math.abs(edges[1] - t) == Math.abs(edges[3] - t);
	}
	
}
