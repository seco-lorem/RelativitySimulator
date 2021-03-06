import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class SpacePanel extends JPanel
{
   
   // Properties
   boolean source;
   Space space;
   ReferenceFrame lorentzMate;
   
   // Costructors
   public SpacePanel(Space s)
   {
      super();
      setBackground(Color.WHITE);
      space = s;
      setSize( space.SPACE_SIZE * 2, space.SPACE_SIZE * 2);
      addMouseMotionListener(new MouseMotionPaint(space.colors));
      addMouseListener(new MouseClicked());
   }
   
   // Methods
   
   @Override
   public void paintComponent(Graphics g)
   {
      // OPTIMIZE THIS BIT
      for ( int i = 0; i <= 2 * space.SPACE_SIZE; i++)
      {
         for ( int j = 0; j <= 2 * space.SPACE_SIZE; j++)
         {
            g.setColor(space.colors[space.space.getPixelByIndex(i,j)]);
            g.fillRect( i, j, i, j);
         }
      }
   }
   
   public void setSpace( Space s)
   {
      space = s;
   }
   
   public Space getSpace()
   {
      return space;
   }
   
   public void setLorentzMate(Space space, int v)
   {
      lorentzMate = new ReferenceFrame(space, v, this);
   }
   
   /* A mouse listener to paint
    * @author Yekta Se?kin Sat?r
    * @date 06/04/2020
    */
   public class MouseMotionPaint implements MouseMotionListener
   {
      // Properties
      Color[] colors;
      byte color;
      
      // Constructor
      public MouseMotionPaint(Color[] c)
      {
         colors = c;
         color = 1;
         repaint();
      }
      
      // Methods
      
      @Override
      public void mouseDragged(MouseEvent e) 
      {
         space.setSquare( e.getX(), e.getY(), color);
      }
      
      @Override
      public void mouseMoved(MouseEvent e) {}
      
   }
   
   public class MouseClicked implements MouseListener
   {  
      @Override
      public void mouseReleased(MouseEvent e) 
      {
         repaint();
         lorentzMate.lorentz(space);
         lorentzMate.repaint();
      }
      
      // Unused empty MouseListener methods
      public void mousePressed(MouseEvent e) {}
      public void mouseClicked(MouseEvent e) {}
      public void mouseEntered(MouseEvent e) {}  
      public void mouseExited(MouseEvent e) {}
      
   }
   
}