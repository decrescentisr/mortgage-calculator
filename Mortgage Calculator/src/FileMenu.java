

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import helpers.*;

//import FileMenu.MenuHandler;
import helpers.ApplicationHelpers;

public class FileMenu extends JMenu 
{
	private String appName = "Application";

	public static final String EXIT = "Exit";
	public static final String OPEN = "Open";
	
	
	
	private JMenuItem itemExit;
	private JMenuItem itemOpen;
	private JMenuItem itemClear;
	private JFileChooser jFileChooser1 = new JFileChooser(new File(","));
	private JLabel jlblStatus = new JLabel();
	
	
	private JTextArea jta = new JTextArea();
	
	private MenuMain mainMenu;
	
	
	
	public FileMenu(MenuMain main)
	{
		super("File");
		mainMenu = main;
		createMenu();
	}
	
	
	private void createMenu() 
	{
		super.setText("File");
		super.setMnemonic(KeyEvent.VK_F);
		
		
					
		itemOpen = new JMenuItem("Open");
		itemOpen.setMnemonic(KeyEvent.VK_S);
		super.add(itemOpen);
		itemOpen.addActionListener(
				new ActionListener()
				{
					

					@Override
					public void actionPerformed(ActionEvent e) {
						open();
						
					}

					private void open() {
						if(jFileChooser1.showOpenDialog(itemOpen) == 
								JFileChooser.APPROVE_OPTION)
							open(jFileChooser1.getSelectedFile());
						
					}
					
					private void open(File file) {
						
						try {
							BufferedInputStream in = new BufferedInputStream(
									new FileInputStream(file));
							byte[] b = new byte[in.available()];
							in.read(b, 0, b.length);
							jta.append(new String(b, 0, b.length));
							in.close();
							
							jlblStatus.setText(file.getName() + " Opened");
						}
						catch (IOException ex){
							jlblStatus.setText("Error Opening " + file.getName());
						}
					}
				}

		);
		
		itemClear = new JMenuItem("Clear");
		itemClear.setMnemonic(KeyEvent.VK_C);
		super.add(itemClear);
		itemClear.addActionListener(
				new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						mainMenu.clear();
					}

					
				}

			);
	
		
		itemExit = new JMenuItem("Exit");
		itemExit.setMnemonic(KeyEvent.VK_G);
		super.add(itemExit);
		itemExit.addActionListener(
			new ActionListener()
			{
			
				
				public void actionPerformed(ActionEvent e)
				{
					int response = JOptionPane.NO_OPTION;
					String prompt = "Do you want to quit " + "?";
					String title = "Quit ";
					response = JOptionPane.showConfirmDialog(null, prompt, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
					
					if(response == JOptionPane.YES_OPTION) 
					{
						System.exit(0);
					}
					
					
				}
				
				
				
			}
		);
	}
		
		
			
}

	
		



