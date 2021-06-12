package universe;

import display.GamePanel;

public class Event extends Entity
{
	// Properties
	int radius;
	
	// Constructors
	public Event(int xx, int tt, GamePanel gp)
	{
		handler = gp;
		x = xx;
		t = tt;
		radius = 10;
	}
	
	// Methods
	@Override
	public boolean contains( int x, int y)
	{
		if ( Math.pow( ( x - (this.x + radius)) , 2) + Math.pow( y - (this.t + radius) , 2 )  <  Math.pow(radius , 2))
			return true;
		else
			return false;
	}
	
}