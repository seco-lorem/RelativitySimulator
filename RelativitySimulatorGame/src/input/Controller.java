package input;

import display.GamePanel;

public class Controller
{
	// Properties
	
	/* Controller array.
	 * 
	 * Index-Button	-Function
	 *
	 *1-)Movement Keys
	 *	0	-Left/A	-move
	 *	1	-Rght/D	-move
	 *
	 *2-)CommandKeys
	 *	2	-Esc	-Pause
	 *	3	-up/W	-TakeControl
	 *	4	-Down/S	-SetReferenceFrame
	 *	5	-Space	-CreateEvent
	 *	6	-Mouse	-setSelected
	 */
	final static byte NUM_OF_KEYS = 2;
	
	GamePanel handler;
	KeyManager keyboard;
	MouseManager mouse;
	
	// Constructors
	
	public Controller(GamePanel gamePanel)
	{
		handler = gamePanel;
		initialise();
	}
	
	public void initialise()
	{
		keyboard = new KeyManager(handler);
		mouse = new MouseManager(handler);
	}
	
	public void ready()
	{
		mouse.ready();
		keyboard.ready();
	}

	public void go()
	{
		keyboard.go();
	}

	/* Controller array.
	 * 
	 * Index-Button		-Function
	 *
	 *	0	-Left/A		-move
	 *	1	-Rght/D		-move
	 */
	public boolean[] getCommands()
	{
		boolean[] toReturn;
		
		toReturn = new boolean[NUM_OF_KEYS];
		toReturn[0] = keyboard.aLeft || keyboard.left;
		toReturn[1] = keyboard.aRight || keyboard.right;
		
		return toReturn;
	}
	
}
