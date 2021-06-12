public class ReferenceFrame
{
   // Properties
   Space s;
   int velocity;
   SpacePanel sp;
   
   // Constructor
   public ReferenceFrame(Space space, int v, SpacePanel p)
   {
      s = space;
      velocity = v;
      sp = p;
   }
   
   // Methods
   public void lorentz(Space space)
   {
      SpacePanel spacePanel = s.getSpacePanel();
      s = space.lorentz(velocity);
      s.setSpacePanel(spacePanel);
      spacePanel.setSpace(s);
      spacePanel.repaint();
      // To delete
      //LorentzGame.drawSpace(sp);
   }
   
   public void repaint()
   {
      sp.repaint();
   }
}