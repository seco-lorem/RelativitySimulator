package universe;

import java.awt.Graphics;

import java.util.ArrayList;

import display.GamePanel;

public class EntityManager 
{
	// Properties
	private static final int DEF_ENT_NUM = 3;
	ArrayList<Entity> entityList;
	GamePanel handler;
	Creature referenceFrame;
	Movement input;
	
	// Constructors
	public EntityManager(GamePanel handler) 
	{
		this.handler = handler;
		initialise();
		randomlyCreate();
		entityList.add(referenceFrame);
	}

	//  Methods
	private void initialise()
	{
		input = new Movement();
		entityList = new ArrayList<Entity>(); //System.out.println("ekledik");// ekledik
		referenceFrame = new Player( handler, (byte)1);
	}
	
	private void randomlyCreate()
	{
		for(int i = 0; i < DEF_ENT_NUM; i++)
		{
			System.out.println(entityList);
			entityList.add(new Creature( handler, (byte)((Math.random() * handler.space.colors.length) % (handler.space.colors.length - 1) + 1 )));
		}
		
	}

	public Creature getReferenceFrame() 
	{
		return referenceFrame;
	}

	public void ready()
	{
		for (int i = 0; i < entityList.size(); i++)
		{
			if(entityList.get(i).isCreature)
				((Creature)entityList.get(i)).ready();
		}
	}
	
	/**
	 * Not sure if needed.
	 * Manipulate the position of selected shape. Control which one lays over which
	 * 
	 */
	public void setForeGround(Entity e)
	{
		entityList.remove(entityList.indexOf(e));
		entityList.add(e);
	}

	public void go(Graphics g, int[] renderLine) 
	{
//		System.out.print("");	// reached
		for (int i = 0; i < entityList.size(); i++)
		{
//			System.out.print("b");
			entityList.get(i).go(g, renderLine);
		}
	}
	
	public void selectOnGame(int x)
	{
		for (int i = 0; i < entityList.size(); i++)
		{
			if(entityList.get(i).isCreature)	//	&& entityList.get(i).contains(x,y))
			{
				entityList.get(i);	//	TODO create a method like selectIf(x,renderLine); 
			}
		}
	}
	
	public void selectIfContains(int x, int y)
	{
		for (int i = 0; i < entityList.size(); i++)
		{
			if(entityList.get(i).isCreature && entityList.get(i).contains(x,y))
			{
				entityList.get(i).toggleSelected();
			}
		}
	}
	
	public void setReferenceFrame()
	{
		for (int i = 0; i < entityList.size(); i++)
		{
			if(entityList.get(i).isCreature && entityList.get(i).getSelected())
			{
				referenceFrame = (Creature)entityList.get(i);
				handler.space.referenceFrame = referenceFrame;
				return;
			}
		}
	}
	
	public void takeControl()
	{
		for (int i = 0; i < entityList.size(); i++)
		{
			if(entityList.get(i).isCreature && entityList.get(i).getSelected())
			{
				((Creature)entityList.get(i)).togglePlayer();
			}
		}
	}

	public void createEvent() 
	{
		double[] tmp = new double[2];
		
		for (int i = 0; i < entityList.size(); i++)
		{
			if(entityList.get(i).isCreature)
			{
				tmp = Universe1D.lorentz(entityList.get(i).x, ((double)entityList.get(i).t) / GamePanel.FPS, referenceFrame.v);
				entityList.add(new Event((int)tmp[0] , (int)tmp[1], handler));	//lorenz filan , entityList.get(i)));
			}
		}
	}
	
}
