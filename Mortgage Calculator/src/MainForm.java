import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import helpers.ApplicationHelpers;


public class MainForm extends JFrame
{
	public static final int WINDOW_WIDTH = 1000;
	public static final int WINDOW_HEIGHT = 500;

	JTabbedPane jtp;
	
	private JLabel lblWelcome;
	private JPanel framePanel;
		
	public MainForm(){
		super();
		createTabPane();
		setFrame();
		
		ApplicationHelpers.displayApplicationInformation("Mortgage Calculator", "Robert DeCrescentis", "Business Application");
	}
	
	private void createTabPane()
	{
		super.setLayout(new GridBagLayout());
		framePanel = new JPanel(new GridBagLayout());
		GridBagConstraints bag = new GridBagConstraints();
		
		jtp = new JTabbedPane();
		jtp.addTab("Mortgage Calculator", new MortgageCalculator());
		//addTab("Amortization", new Amortization());
		
		lblWelcome = new JLabel();
		lblWelcome.setText("Mortgage Calculator");
		bag.gridx = 0;
		bag.gridy = 0;
		bag.weighty = 0;
		framePanel.add(lblWelcome, bag);
				
		bag.fill = GridBagConstraints.HORIZONTAL;
		bag.gridx = 0;
		bag.gridy = 0;
		bag.ipady = 250;
		bag.weightx = 1;
		bag.weighty = .75;
		this.add(jtp, bag);
		
		bag.fill = GridBagConstraints.CENTER;
		bag.gridx = 0;
		bag.gridy = 1;
		bag.ipady = 40;
		bag.ipadx = 400;
		bag.weightx = 1;
		bag.weighty = .25;
		bag.insets = new Insets(10,0,10,0);
		
		this.add(new ExitButton("Mortgage Calculator"), bag);
		
		//create the main menu object, but will need to create the main menu first, then come back and complete these steps
		MenuMain mainMenu = new MenuMain(this);
		this.setJMenuBar(mainMenu);
	}
	

	
	private void setFrame()
	{
		Dimension windowSize = new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);
		super.setTitle("Mortgage Calculator");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setSize(windowSize);
		
		super.setLocationRelativeTo(null);
		super.setVisible(true);
	}
	
	public void clearResults(){
		MortgageCalculator.txtAmount.setText("");
		MortgageCalculator.txtRate.setText("");
		MortgageCalculator.txtYears.setText("");
		MortgageCalculator.txtMonthlyPayment.setText("");
	}

}
