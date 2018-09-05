import java.awt.Color;

import javax.swing.UIManager;

public class AppMain 
{
	public static void main(String[] args) {
		setStyle();
		new MainForm();

	}
	
	private static void setStyle() 
	{
		UIManager.put("Optionpane.background", Color.BLUE);
		UIManager.put("JPanel.background", Color.LIGHT_GRAY);
		
	}
}
