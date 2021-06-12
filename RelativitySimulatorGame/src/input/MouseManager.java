package input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import display.GamePanel;

public class MouseManager implements MouseListener
{
	// Properties
	GamePanel handler;
	boolean clicked;
	MouseEvent event;
	
	public MouseManager(GamePanel gp) 
	{
		handler = gp;
		handler.addMouseListener(this);
		clicked = false;
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		clicked = true;
		event = e;
	}
	
	public void ready()
	{
		if (clicked)
			handler.space.entities.selectIfContains(event.getX(), event.getY());	// TODO check here, if in selectIfContains, getPixel() or getPixelByIndex() should be called

		clicked = false;
	}
	
	@Override public void mouseEntered(MouseEvent arg0) {}
	@Override public void mouseExited(MouseEvent arg0) {}
	@Override public void mousePressed(MouseEvent arg0) {}
	@Override public void mouseReleased(MouseEvent arg0) {}
	
}