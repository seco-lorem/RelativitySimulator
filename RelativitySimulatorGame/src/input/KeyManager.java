package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import display.GamePanel;

public class KeyManager implements KeyListener {
	
	private boolean[] keys, justPressed, cantPress;
	public boolean left, right, aLeft, aRight;
	public boolean  up, down, esc, space;
	
	GamePanel handler;
	
	public KeyManager(GamePanel gp)
	{
		handler = gp;
		keys = new boolean[256];
		justPressed = new boolean[keys.length];
		cantPress = new boolean[keys.length];
		handler.frame.addKeyListener(this);
		System.out.print("qq");
	}
	
	public void go()
	{
		for(int i = 0;i < keys.length;i++)
		{
			if(cantPress[i] && !keys[i])
				cantPress[i] = false;
			else if(justPressed[i])
			{
				cantPress[i] = true;
				justPressed[i] = false;
			}
			if(!cantPress[i] && keys[i])
				justPressed[i] = true;
		}
		
		// Temporarily removing here to check
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		aLeft = keys[KeyEvent.VK_LEFT];
		aRight = keys[KeyEvent.VK_RIGHT];
		// Temporarily removing  this bit to check
	}
	
	public boolean keyJustPressed(int keyCode){
		if(keyCode < 0 || keyCode >= keys.length)
			return false;
		return justPressed[keyCode];
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		// Temporarily adding this bit to check
//		System.out.print("BASTIK");
//		if (e.getKeyCode() == KeyEvent.VK_LEFT)
//		{
//			aLeft = true;
//			System.out.print("Sol");
//		}
//		else if (e.getKeyCode() == KeyEvent.VK_A)
//		{
//			left = true;
//			System.out.print("A");
//		}
//		else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
//		{
//			aRight = true;
//			System.out.print("SAÐ");
//		}
//		else if (e.getKeyCode() == KeyEvent.VK_D)
//		{
//			right = true;
//			System.out.print("D");
//		}
		// Temporarily adding this bit to check
		
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;
		keys[e.getKeyCode()] = true;
		
		setCommandKeys();
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// Temporarily adding this bit to check
//		System.out.print("KALDIRDIK");
//		if (e.getKeyCode() == KeyEvent.VK_LEFT)
//		{
//			aLeft = false;
//			System.out.print("Sol");
//		}
//		else if (e.getKeyCode() == KeyEvent.VK_A)
//		{
//			left = false;
//			System.out.print("A");
//		}
//		else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
//		{
//			aRight = false;
//			System.out.print("SAÐ");
//		}
//		else if (e.getKeyCode() == KeyEvent.VK_D)
//		{
//			right = false;
//			System.out.print("D");
//		}
		// Temporarily adding this bit to check
		
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	public void ready()
	{
		if (up)
			handler.space.entities.takeControl();
		if (down)
			handler.space.entities.setReferenceFrame();
		if (esc)
			handler.togglePaused();
		if (space)
			handler.space.entities.createEvent();
	}
	
	private void setCommandKeys()
	{
		up = keys[KeyEvent.VK_W] || keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_S] || keys[KeyEvent.VK_DOWN] ;
		esc = keys[KeyEvent.VK_ESCAPE];
		space = keys[KeyEvent.VK_SPACE];
	}

}
