package universe;

public interface Selectable
{
	boolean selected = false;
	
	public void setSelected(boolean b);
	public void toggleSelected();
	public boolean getSelected();
}
