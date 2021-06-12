package universe;

import display.GamePanel;

public class Creature extends Entity {

	// Properties
	int v;	// In creatures own perspective: (x' != v + x)
	int a;
	int size;
	int age;
	
	boolean playerControls;
	Plane beenTo;
	int movement;
	
	// Constructors
	public Creature( GamePanel gp, byte color)
	{
		System.out.println("creature constructor");
		handler = gp;
		this.color = color;
		initialise();
	}
	
	// Methods
	public void initialise()
	{
		playerControls = false;
		t = 0;
		x = (int) (Math.random() * 2 * Universe1D.SIZE) - Universe1D.SIZE;
		v = 0;
		a = 0;
		size = handler.getWidth() / 10;//(int)(Math.random() * 5) + 3;
		beenTo = new Plane(Universe1D.SIZE);
		isCreature = true;
		movement = 1;
	}
	
	@Override
	public boolean contains(int xx, int tt)
	{
//		System.out.println(t + " " + tt);
		if ( t < tt)
			return getToT(tt) + size > xx && x - size < xx;
		return color == beenTo.getPixel(xx,tt);
	}
	
	public int getToT(int time)
	{
		while (t < time)
		{
			ready();
		}
		return x;
	}
	
	public void ready()
	{
		accellerate();
		move();
		t++;
		saveToSpace();
		setBeenTo();
		//	save to the space??
	}
	
	public void move()			// This method works fine
	{
		int move;
		double[] lorentzd;
		
		// calculate move variable(in perspective of handler.space.referenceFrame) with v variable(in perspective of itself) by using lorentz
		// If using lorentz transformations does not end up limiting the speed to c, remove lorentz from accelerate) and move() bit and simply make a frictive limiter.
		lorentzd = Universe1D.deLorentz( v, t, v - 1); // parameters: x' , y , velocity - 1
		move = (int) lorentzd[0];
		age += (int) lorentzd[1];
		x += move;
		
//		x += v;		// remove
	}
	
	public void accellerate()	// This method works fine
	{
		boolean[] commands = getControls();
//		System.out.print(v + " " + commands[0] + " " + commands[1] + " ");
		
		if (commands[0])
			v--;
		if (commands[1])
			v++;
		
		if (v >= Universe1D.c)
			v--;
		else if (v <= -1 * Universe1D.c)
			v++;
			
//		System.out.println(v + " - ");
	}
	
	private boolean[] getControls()
	{
		if (playerControls)
			return handler.getController();
		else
			return handler.space.entities.input.getControls( t, movement);
	}
	
	public void saveToSpace()
	{
	}
	
	public void setBeenTo()
	{
		for ( int i = x - size; i < x + size; i++)	//	for ( int j = t - size; j < t + size ; j++)
			beenTo.setPixel(i, t, color);
	}
	
	public void setPlayer(boolean b)
	{
		playerControls = b;
	}

	public void togglePlayer()
	{
		playerControls = !playerControls;
	}
	
}
