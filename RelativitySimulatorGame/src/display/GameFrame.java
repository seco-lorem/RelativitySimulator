package display;

import javax.swing.JFrame;

import universe.Universe1D;

public class GameFrame extends JFrame
{
	// Properties
	private static final long serialVersionUID = 1L;	// Because IDE says so
	
	GamePanel gamePanel;
	
	// constructors
	public GameFrame()
	{
		super();
		gamePanel = new GamePanel(this); 
		add(gamePanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize( Universe1D.getSize() * 2, Universe1D.getThicknessStatic() + 23);
		setVisible( true);
	}
}
