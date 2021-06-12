package universe;

import display.GamePanel;

public class Movement
{
	// Properties
	Controls[] movements;
	
	// Constructors
	public Movement() 
	{
		movements = new Controls[5];
		for ( int i = 0; i < movements.length; i++)
			movements[i] = new Controls(i);
	}
	
	// Methods
	public boolean[] getControls( int t, int movNo)
	{
		if( t >= 1200) // TODO get rid of this temporary fix
		{
			boolean[] b = new boolean[2];
			b[0] = false;
			b[1] = false;
			return b;
		}
		return movements[movNo].control[t];	// Exception when t >= 500
	}
	
	// inner classes
	public class Controls
	{
		boolean[][] control; // [SIZE * 2 ?][2] list of left/right commands for all frames
		int startSpeed;
		
		public Controls(int i)
		{
			control = new boolean[Universe1D.SIZE * 2][2];
			
			//	Empty Controls ready for player input
			if (i == 0)
			{
				startSpeed = 0;
				for ( int j = 0; j < control.length; j++)
				{
					for ( int k = 0; k < 2; k++)
					{
						control[j][k] = false;
					}
				}
			}
			
			//	Stationary controls
			if (i == 1)
			{
				startSpeed = 0;
				for ( int j = 0; j < control.length; j++)
				{
					for ( int k = 0; k < 2; k++)
					{
						control[j][k] = false;
					}
				}
			} 
			
			//	Constant speed to the left
			if (i == 2)
			{
				startSpeed = (int)(-Universe1D.c / 2.0);
				for ( int j = 0; j < control.length; j++)
				{
					for ( int k = 0; k < 2; k++)
					{
						control[j][k] = false;
					}
				}
			}
			
			//	Constant speed to the right
			if (i == 3)
			{
				startSpeed = (int)(Universe1D.c / 2.0);
				for ( int j = 0; j < control.length; j++)
				{
					for ( int k = 0; k < 2; k++)
					{
						control[j][k] = false;
					}
				}
			}
			
			//	Zigzag
			if (i == 4)
			{
				int howLong = GamePanel.FPS;
				
				startSpeed = 0;
				for ( int j = 0; j < control.length; j++)
				{
					for ( int k = 0; k < 2; k++)
					{
						if (k == 0)
							control[j][k] = (howLong < j % (howLong / 2));
						else
							control[j][k] = (howLong > j % (howLong / 2));
					}
				}
			}
			
		}
		
	}
	
}
