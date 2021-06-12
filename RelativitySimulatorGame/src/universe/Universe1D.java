package universe;

import java.awt.Color;
import java.awt.Graphics;
//import java.awt.Point;

import display.GamePanel;

public class Universe1D {
	
	// Properties
	final static int SIZE = 600;//250;
	private static final int THICKNESS = 100;
	static double c = 100;
	
	int inGameTime; // in units of (1 / FPS) seconds
	Plane spaceTime;
	public Color[] colors;
	GamePanel handler;
	public EntityManager entities;
	public Creature referenceFrame;
	
	// Constructors
	public Universe1D(GamePanel p)
	{
		handler = p;
		initialise();
	}
	
	public Universe1D(GamePanel p, int c)
	{
		setC(c);
		handler = p;
		initialise();
	}
	
	// Methods
	public void initialise()
	{
		inGameTime = 0;
		spaceTime = new Plane(SIZE);
		colors = new Color[8];
		
		colors[1] = Color.WHITE;
		colors[0] = Color.BLACK;
		colors[2] = Color.ORANGE;
		colors[3] = Color.MAGENTA;
		colors[4] = Color.CYAN;
		colors[5] = Color.GREEN;
		colors[6] = Color.RED;
		colors[7] = Color.BLUE;
	}
	
	public void ready()
	{
		entities.ready();
		inGameTime++;
		
	}

	public void go(Graphics g) 
	{
		entities.go( g, renderLine());
	}
	
	private int[] renderLine()
	{
		double[] tmp;
		int[] points = new int[4];	// x1, y1, x2, y2

		tmp =  lorentz( -Universe1D.SIZE, (double) referenceFrame.t / GamePanel.FPS, (double)referenceFrame.v);
		points[0] = (int)tmp[0];
		points[1] = (int)tmp[1];
		
		tmp =  lorentz( Universe1D.SIZE, (double) referenceFrame.t / GamePanel.FPS, (double)referenceFrame.v);
		points[2] = (int)tmp[0];
		points[3] = (int)tmp[1];
		
		System.out.println( points[0] + " " + points[1] + " " + points[2] + " " + points[3]);	// Works I guess	//	Outputs -250 0 -250 0... -250 1 -250 1... ...

		return points;
	}
	
	
	// Static methods
	public static void setC(int lightSpeed)
	{
		c = lightSpeed;
	}
	
	/**
	 * @param y = t in seconds
	 * 
	 */
	public static double[] lorentz( double xx, double y, double velocity) // y in seconds! not in inGametime
	{
		double[] tmp = new double[2];
		double x = xx;
		double t = y;
		double v = velocity;
		double gama = 1.0 / Math.sqrt(1 - v * v / (c * c));

		tmp[0] = gama * ( x - v * t);
		tmp[1] = gama * ( t - v * x / (c * c));

		return tmp;
	}
	
	public static int getSize()
	{
		return SIZE;
	}

	public int getThickness() 
	{
		return THICKNESS;
	}
	public static int getThicknessStatic() 
	{
		return THICKNESS;
	}

	public static double[] deLorentz(double xx, double t, double v) 
	{
		double[] tmp = new double[2];
		
		// Apply the formula in 1design-TODO-readMe folder's deLorentz.png
		double gama = 1.0 / Math.sqrt(1 - v * v / (c * c));
		tmp[0] = (xx + v * t) / gama;
		tmp[1] = gama * ( t - (v * tmp[0] / (c * c)));
		
		return tmp;
	}
	
}
