import javax.swing.JMenuBar;


import helpers.OutputHelpers;
import helpers.StringHelpers;

public class MenuMain extends JMenuBar
{
		private double total = 0;
	
	//provide a reference back to the main form so we can pass messages to it
		 private MainForm mainFrame;
		 private FileMenu menuFile;
		 private EditMenu menuEdit;
		 private HelpMenu menuHelp;
		
		 
		 public MenuMain(MainForm mainFrame)
		 {
			 super();
			 this.mainFrame = mainFrame;
			 createMenus();
		 }
		 
		 private void createMenus()
		 {
			 menuFile = new FileMenu(this);
			 this.add(menuFile);
			 
			 menuEdit = new EditMenu(this);
			 this.add(menuEdit);		
			 
			 menuHelp = new HelpMenu(this);
			 this.add(menuHelp);
		 }
		 
		 public void clear(){
				total = 0;
				
				mainFrame.clearResults();
		}
}
