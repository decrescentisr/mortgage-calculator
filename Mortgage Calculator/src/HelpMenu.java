import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import helpers.ApplicationHelpers;

public class HelpMenu extends JMenu
{
	
	public static final String ABOUT = "About";
	
	
	private JMenuItem itemAbout;
	
	private MenuMain mainMenu;

	public HelpMenu(MenuMain main) 
	{
		super("Help");
		mainMenu = main;
		createMenu();		
		
	}
	
	private void createMenu() 
	{
		super.setText("Help");
		super.setMnemonic(KeyEvent.VK_H);
		
		MenuHandler handler = new MenuHandler();
		
		itemAbout = new JMenuItem("About");
		itemAbout.setMnemonic(KeyEvent.VK_B);
		itemAbout.addActionListener(handler);
		super.add(itemAbout);
	}
	
	public class MenuHandler implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ApplicationHelpers.displayApplicationInformation("Mortgage Calculator", "By", "Robert DeCrescentis");
		}
	}

}
