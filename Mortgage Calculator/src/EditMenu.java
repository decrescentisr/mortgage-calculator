import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.JTextComponent;

import helpers.*;

import helpers.ApplicationHelpers;



public class EditMenu extends JMenu 
{
	public static final String EDIT = "Edit";
	public static final String COPY = "Copy";
	public static final String PASTE = "Paste";
	public static final String DELETE = "Delete";
	public static final String CUT = "Cut";
	
	private JTextComponent textComp;
	
	
	private MenuMain mainMenu;
	
	private EditMenu editMenu;
	
	public EditMenu(MenuMain main) 
	{
		
		super("Edit");
		mainMenu = main;
		createMenu();
	}
	
	private void createMenu() {
		
		super.setText("Edit");
		super.setMnemonic(KeyEvent.VK_E);
		
		JMenuItem itemCut = new JMenuItem(new DefaultEditorKit.CutAction());
		itemCut.setText("Cut");
		super.add(itemCut);
		
		JMenuItem itemCopy = new JMenuItem(new DefaultEditorKit.CopyAction());
		itemCopy.setText("Copy");
		super.add(itemCopy);
		
		JMenuItem itemPaste = new JMenuItem(new DefaultEditorKit.PasteAction());
		itemPaste.setText("Paste");
		super.add(itemPaste);

	
	}
	
	
}
