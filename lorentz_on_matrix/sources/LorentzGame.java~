
import javax.swing.*;
import java.awt.*;

public class LorentzGame
{
   
   //  Properties
   int vDiff;
   Space beforeLorentz;
   Space afterLorentz;
   SpacePanel bL;
   SpacePanel aL;
   
   // Constructors
   public LorentzGame()
   {
      beforeLorentz = new Space(100);
      afterLorentz = beforeLorentz.lorentz(-50);
      
      beforeLorentz.setName("(A)");
      afterLorentz.setName("Bharfi)");
      
      bL = new SpacePanel(beforeLorentz);
      aL = new SpacePanel(afterLorentz);
      
      beforeLorentz.setSpacePanel(bL);
      afterLorentz.setSpacePanel(aL);
      
      bL.setLorentzMate(afterLorentz, -50);
      aL.setLorentzMate(beforeLorentz, 50);
      
      drawSpace(bL);
      drawSpace(aL);
   }
   
   public LorentzGame(int velocityDifference)
   {
      vDiff = velocityDifference;
      beforeLorentz = new Space();
      afterLorentz = beforeLorentz.lorentz(-vDiff);
      
      bL = new SpacePanel(beforeLorentz);
      aL = new SpacePanel(afterLorentz);
      
      bL.setLorentzMate(afterLorentz, -vDiff);
      aL.setLorentzMate(beforeLorentz, +vDiff);
      
      drawSpace(bL);
      drawSpace(aL);
   }
   
   
   public static void drawSpace(SpacePanel sp)
   {
      JFrame f = new JFrame();
      
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setSize( Space.SPACE_SIZE * 2, Space.SPACE_SIZE * 2);
      f.add(sp);
      f.setVisible( true);
   }
   
}