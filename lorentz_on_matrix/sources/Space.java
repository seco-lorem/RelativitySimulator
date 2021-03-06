import javax.swing.*;
import java.awt.*;

/* PROBLEM: You are giving too big numbers as a parameter for time(y) in lorentz function. 
 * You act as if we care about (c * seconds / meter) size of seconds. However we only do care for a few seconds, thus graph becomes 1D as y axis becomes invisibly small.
 * dividing y axis input by c^3 makes y axis visible but, it is neither mathematically correct norr outputs a clear graph.
 * 
 * TODO: An inner class to hold the byte[][] variable space and transform it to regular x-t coordinates when called
 */
public class Space
{
   // Properties
   final static int SPACE_SIZE = 250;
   
   SpacePanel p;
   Plane space;
   Color[] colors;
   static double c = 100;
   
   // Constructors
   public Space( double c, boolean matrix, SpacePanel p)
   {
      initialise();
      
      this.c = c;
      this.p = p;
      
      if ( matrix)
         createEmpty();
   }
   
   public Space( double c)
   {
      initialise();
      createEmpty();
      this.c = c;
   }
   
   public Space()
   {
      initialise();
      createEmpty();
   }
   
   // Methods
   private void initialise()
   {
      space = new Plane();
      colors = new Color[8];
      
      colors[0] = Color.WHITE;
      colors[1] = Color.BLACK;
      colors[2] = Color.ORANGE;
      colors[3] = Color.MAGENTA;
      colors[4] = Color.CYAN;
      colors[5] = Color.GREEN;
      colors[6] = Color.RED;
      colors[7] = Color.BLUE;
      
   }
   
   public void createEmpty()
   {
      for ( int i = -1 * SPACE_SIZE; i <= SPACE_SIZE; i++)
      {
         for ( int j = -1 * SPACE_SIZE; j <= SPACE_SIZE; j++)
         {
            if ( i % 100 == 0 || j % 100 == 0)
               space.setPixel(i,j,(byte)1);
            else
               space.setPixel(i,j,(byte)0);
         }
      }
   }
   
   public Space lorentz( int v)
   {
      double[] p;
      Space temp = new Space( 100.0 , false, null);
      
      for ( int i = -1 * SPACE_SIZE; i <= SPACE_SIZE; i++)
      {
         for ( int j = -1 * SPACE_SIZE; j <= SPACE_SIZE; j++)
         {
            p = lorentz( i, j / c , (double) v);
            
            if (space.getPixel(i,j) != 0)
               temp.space.setPixel( (int) p[0], (int) (p[1] * c), space.getPixel(i,j));
            
            // Handle if there is more space here
            
         }
      }
      
      return temp;
   }
   
   public static double[] lorentz( double xx, double y, double velocity)
   {
      double[] tmp = new double[2];
      
      double x = xx;
      double t = y;
      double v = velocity;
      double gama = 1.0 / Math.sqrt(1 - v * v / (c * c));
      
//      System.out.println("xx: " + xx + "\ny: " + y + "\nx: " + x + "\nt: " + t + "\nv: " + v + "\ngama: " + gama + "\nnewX: " + newX + "\nnewY: " + newY);
      
      if (tmp[0] > -1 * SPACE_SIZE && tmp[0] < SPACE_SIZE && tmp[1] > -1 * SPACE_SIZE && tmp[1] < SPACE_SIZE)
      {
         tmp[0] = gama * ( x - v * t);
         tmp[1] = gama * ( t - v * x / (c * c));
      }
      else
      {
         tmp[0] = 0;
         tmp[1] = 1;
      }
      return tmp;
   }
   
   public void repaint()
   {
      p.repaint();
   }
   
   public void setSquare( int x, int y, byte color) // By index!
   {
      for ( int i = x - 5; i < x + 5; i++)
      {
         for ( int j = y - 5; j < y + 5; j++)
         {
            space.setPixelByIndex( i, j, color);
         }  
      }
   }
   
   public void setSpacePanel(SpacePanel sp)
   {
      p = sp;
   }
   
   public SpacePanel getSpacePanel()
   {
      return p;
   }
   
   public class Plane
   {
      // Property
      byte[][] space;
      
      // Constructor
      public Plane()
      {
         space = new byte[SPACE_SIZE * 2 + 1][SPACE_SIZE * 2 + 1];
      }
      
      // Methods
      public void setPixel( int x, int y, byte color)
      {
         if ( x >= -SPACE_SIZE && x <= SPACE_SIZE &&  y >= -SPACE_SIZE && y <= SPACE_SIZE)
            space[x + SPACE_SIZE][y + SPACE_SIZE] = color;
      }
      
      public byte getPixel( int x, int y)
      {
         return space[x + SPACE_SIZE][y + SPACE_SIZE];
      }
      
      public void setPixelByIndex(int x, int y, byte color)
      {
         if ( true) // Avoid array out of bounds exception
            space[x][y] = color;
      }
      
      public byte getPixelByIndex(int x, int y)
      {
         return space[x][y];
      }
      
   }
   
   // Delete below this
   String name;
   public void setName(String n){name = n;}
   public String toString(){return name;}
   
}