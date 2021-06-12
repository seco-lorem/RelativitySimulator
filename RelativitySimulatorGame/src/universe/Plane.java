package universe;

public class Plane
{
	// Properties
	byte[][] pixels;
	int size;
	
	// Constructors
	public Plane(int size)
	{
		this.size = size;
		pixels = new byte[size * 2 + 1][size * 2 + 1];
	}
	
	// Methods
	public byte getPixel( int x, int y)
	{
		if( x >= -size && x <= size && y >= 0 && y <= size * 2)
			return pixels[x + size][size * 2 - y];
		else
		{
//			System.out.println("No pixel was returned in universe.Universe1D.Plane.getPixel()");
			return (byte)0;
		}
	}
	
	public void setPixel( int x, int y, byte color) 
	{
		if(x >= -size && x <= size && y >= 0 && y <= size * 2)
			pixels[x + size][size * 2 - y] = color;
	}

	public byte getPixelByIndex( int x, int y)
	{
		if( x >= 0 && x <= size * 2 && y >= 0 && y <= size * 2)
			return pixels[x][y];
		else
		{
			System.out.println("No pixel was returned in universe.Universe1D.Plane.getPixelByIndex()");
			return (byte)0;
		}
	}
	
	public void setPixelByIndex(int x, int y, byte color) 
	{
		if(x >= 0 && x <= size * 2 && y >= 0 && y <= size * 2)
			pixels[x][y] = color;
		else
			System.out.println("No pixel was changed in universe.Universe1D.Plane.setPixelByIndex()"); // Learn to throw an exception instead?
	}
	
	
}