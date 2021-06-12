package universe;

import display.GamePanel;

public class Player extends Creature 
{
	boolean savingMovement;
	Movement movement;
	
	public Player( GamePanel gp, byte color)
	{
		super(gp,color);
		playerControls = true;
	}
	/*@Override	public void ready()	{		super.ready();	}	/*if(savingMovement)	saveMovement();	}	/*	public void saveMovement(){}	public void startSaving(){}	public void stopSaving(){}*/

}
