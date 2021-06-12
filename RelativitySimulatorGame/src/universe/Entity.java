package universe;

import java.awt.Graphics;

import display.GamePanel;

public abstract class Entity implements Selectable 
{
	// Properties
	boolean selected;
	boolean isCreature;
	int x;
	int t;
	byte color;
	GamePanel handler;
	
	// Methods
	public abstract boolean contains(int x, int t);	// Check if @param is in the entity
	
	/**
	 * WARNING!	-First x1 Must be smaller than x2 in int[] renderLine as follows x1, y1, x2, y2
	 * @param g
	 * @param renderLine
	 */
	public void go(Graphics g, int[] renderLine)
	{
		if ( handler.space.referenceFrame == this)
			return;
//		System.out.println(x);
		boolean onLine;
		if (contains(renderLine[0], renderLine[1]))
			onLine = true;
		else
			onLine = false;
		double iFactor = (double)(renderLine[2] - renderLine[0] ) / ((double)Universe1D.SIZE);
		double jFactor = (double)(renderLine[3] - renderLine[1] ) / ((double)Universe1D.SIZE);
		boolean found;
		int beginning = 0;
		int ending = 0;
		double factor =  (double)Universe1D.SIZE / ((double)(renderLine[2] - renderLine[0] ));
		
//		System.out.println(renderLine[0] + " " + renderLine[1] + " " + renderLine[2] + " " + renderLine[3]);	Outputs -250 0 -250 0... -250 1 -250 1... ...
//		System.out.println("geldik");
		double j = renderLine[1];
		for ( double i = renderLine[0]; i < renderLine[2]; i += iFactor)		//TODO Fix this for loop
		{
			
//			System.out.println("girdik");	// Girdik

			if (contains( (int)i, (int)j) && !onLine)
			{
				beginning = (int)(i * factor);
				onLine = true;
			}
			
			if (!contains( (int)i, (int)j) && onLine)
			{
				ending = (int)(i * factor);
				i = renderLine[2];	// Quit the loop
			}
			
//			System.out.println("e");
			// Why is this bit inside the for loop but not outside?	
			// It crashed when I took it outside!
			j = j + jFactor;
		}
//		System.out.print(handler);//.space.colors[color]);
		System.out.println("ending & beginning : " + ending + " " + beginning);
		g.setColor(handler.space.colors[color]);
		g.fillRect(beginning + Universe1D.SIZE, 0, ending - beginning, handler.space.getThickness());
	}
	
	@Override
	public void setSelected(boolean b)
	{
		selected = b;
		isCreature = false;
	}
	
	public boolean getSelected()
	{
		return selected;
	}
	

	@Override
	public void toggleSelected()
	{
		selected = !selected;
	}
	
}
