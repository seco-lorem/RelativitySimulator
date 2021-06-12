package display;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import input.Controller;
import universe.Creature;
import universe.EntityManager;
import universe.Universe1D;

/**
 * @author yekta
 *
 */
public class GamePanel extends JPanel 
{
	// Properties
	private static final long serialVersionUID = 1L;	// Because IDE says so
	public static final int FPS = 50;
	
	public GameFrame frame;
	public Universe1D space;
	Controller controller;
	Timer frameTicker;
	boolean paused;
	
	// Constructors
	public GamePanel(GameFrame f)
	{
		super();
		frame = f;
		initialise();
	}
	
	// Methods
	public void initialise()
	{		
		setSize( Universe1D.getSize() * 2, Universe1D.getThicknessStatic());
		space = new Universe1D(this);
		space.entities = new EntityManager(this);
		space.referenceFrame = space.entities.getReferenceFrame();
		setBackground(space.colors[0]);
		controller = new Controller(this);
		startTimer();
		paused = false;
	}
	
	public void startTimer() 
	{
		ActionListener newFrame = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				ready();
				go();
			}
		};
		frameTicker = new Timer(1000 / FPS, newFrame);
		frameTicker.start();
	}
	
	public boolean[] getController()
	{
		return controller.getCommands();
	}
	
	/**
	 * Do the calculations and get ready for the next Frame
	 * 
	 */
	public void ready()
	{
		space.ready();
		controller.ready();	
	}
	
	/**
	 * Render the new Frame
	 * 
	 */
	public void go()
	{
		repaint();
	}
	
	public void pause()
	{
		frameTicker.stop();
		go();
		paused = true;
		
	}
	
	public void resume()
	{
		frameTicker.start();
		paused = false;
	}
	
	public void togglePaused()
	{
		if(paused)
			resume();
		else
			pause();
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
//		System.out.print("PaintComponent");	// Gets called
		space.go(g);
		controller.go();
	}

	public Creature getReferenceFrame()
	{
		return space.referenceFrame;
	}
}
