import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import helpers.InputHelpers;
import helpers.OutputHelpers;

public class MortgageCalculator extends JPanel 
{
	JLabel lblAmount;
	static JTextField txtAmount;
	JLabel lblYears;
	static JTextField txtYears;
	JLabel lblRate;
	static JTextField txtRate;
	JLabel lblMonthlyPayment;
	static JTextField txtMonthlyPayment;
	public static double payment;
	public static double rate;
	public static JButton btnCalculate;
	public static JButton btnAmortization;
	
	private DecimalFormat df = new DecimalFormat("$#,##0.00");
	
	public MortgageCalculator()
	{
		super();
		createPanel();
	}
	
	public void clear()
	{
		txtAmount.setText("");
		txtYears.setText("");
		txtRate.setText("");
		txtMonthlyPayment.setText("");
	}
	
	private void createPanel()
	{
		super.setLayout(new GridBagLayout());
		GridBagConstraints bag = new GridBagConstraints();
		
		bag.fill = GridBagConstraints.BOTH;
		bag.anchor = GridBagConstraints.FIRST_LINE_START;
		bag.insets = new Insets(5,5,5,5);
		
		//column 0, row 0
		bag.gridx = 0;
		bag.gridy = 0;
		lblAmount = new JLabel();
		lblAmount.setText("Loan Amount($): ");
		super.add(lblAmount, bag);
		
		//column 1, row 0
		bag.gridx = 1;
		bag.gridy = 0;
		txtAmount = new JTextField(20);
		super.add(txtAmount, bag);
		
		//column 0, row 1
		bag.gridx = 0;
		bag.gridy = 1;
		lblYears = new JLabel();
		lblYears.setText("Years: ");
		super.add(lblYears, bag);
		
		//column 1, row 1
		bag.gridx = 1;
		bag.gridy = 1;
		txtYears = new JTextField(10);
		super.add(txtYears, bag);
		
		//column 0, row 2
		bag.gridx = 0;
		bag.gridy = 2;
		lblRate = new JLabel();
		lblRate.setText("Percentage Rate: ");
		super.add(lblRate, bag);
		
		//column 1, row 2
		bag.gridx = 1;
		bag.gridy = 2;
		txtRate = new JTextField(10);
		super.add(txtRate, bag);
		
		//column 0, row 3
		bag.gridx = 0;
		bag.gridy = 3;
		lblMonthlyPayment = new JLabel();
		lblMonthlyPayment.setText("Monthly Payment: ");
		super.add(lblMonthlyPayment, bag);
		
		//column 1, row 3
		bag.gridx = 1;
		bag.gridy = 3;
		txtMonthlyPayment = new JTextField(10);
		txtMonthlyPayment.setEditable(false); //read only field
		super.add(txtMonthlyPayment, bag);
		
		//row 2, span both columns
		//take up half the column
		bag.gridx = 0;
		bag.gridy = 4;
		bag.gridwidth = 2;
		btnCalculate = new JButton ("Calculate Payment");
		btnCalculate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				double amount, years, rate;
				
				amount = InputHelpers.parseDoubleField(txtAmount, "Amount", 1, 1000000);
				years = InputHelpers.parseDoubleField(txtYears, "Years", 1, 45);
				rate = InputHelpers.parseDoubleField(txtRate, "Rate", 1, 20);
				
				if (amount > 0 && years > 0 && rate > 0) {
					
					//term in months
					years = years * 12;
					
					//monthly interest rate
					rate = rate/100/12;
					
					//monthly payment
					payment = (amount * rate)/(1 - Math.pow(1 + rate, -years));
					
					//round two decimal places
					payment = (double)Math.round(payment * 100)/100;
					txtMonthlyPayment.setText(OutputHelpers.formattedDouble(payment, 2));
				}
				else {
					txtMonthlyPayment.setText("");
				}
				
			  }
		    }
		);
		super.add(btnCalculate, bag);
		
		bag.gridx = 2;
		bag.gridy = 4;
		bag.gridwidth = 2;
		btnAmortization = new JButton ("Amortization");
		btnAmortization.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				StringBuilder order = new StringBuilder();
				
				NumberFormat nf = NumberFormat.getCurrencyInstance();
				  int Monthly = 0;
				  int monthcount = 0;
				  String Output = "";

				  int i = 0; // For first loop
				  double loanamount = Double.parseDouble( txtAmount.getText() );        //all loan amounts  are the same  
				  double rate = Double.parseDouble( txtRate.getText() );     //Array for the rate
				  double time = Double.parseDouble( txtYears.getText() );         //Array for the time
				  double totalnumpayments = 0;         //Set for 
				  double monthlypayment = 0; //Set for math calculation in first loop
				  double interestPayment = 0;            //Set for math calculation in first loop
				  double totaltime = 0; //Set for second loop to know how long to loop
				  double loan = 0; //Set for second loop
				  double interestPayment2 = 0; //Set for second loop
				  double principlePayment = 0;  //Set for second loop


				  for ( i = 0; i < time; i++ ) {//First loop This loops through the arrays and gives the first message listed below three times
				    monthlypayment = ( loanamount * ( ( rate / 12 ) / ( 1 - Math.pow( ( 1 + ( rate / 12 ) ), -( time * 12 ) ) ) ) );
				    interestPayment = loanamount * ( rate * 100 / 1200 );
				    totaltime = ( time * 12 );


				    
				    //jTextArea1.setText( "This loan has an interest rate of " + ( rate * 100 ) + "%" + " and a starting loan amount of " + nf.format( loanamount ) );
				    //jTextArea1.setText( "Payment Number\t\t" + "Towards Principle\t\t" + "Towards Interest\t" + "Remaining on loan" );
				    //jTextArea1.setText( "" ); // Part of the first loop this will appear three times with the math listed above


				    System.out.println( totaltime );
				    Monthly++;

				    Output += ( ( monthcount++ ) + "\t\t\t" + nf.format( principlePayment ) + "\t\t\t" + nf.format( interestPayment2 ) + "\t\t\t" + nf.format( loan - principlePayment ) + "\n" );


				    loan = -principlePayment;// Changes the numbers as the loop goes
				    interestPayment2 = loan * ( rate * 100 / 1200 );// Changes the numbers as the loop goes
				    principlePayment = monthlypayment - interestPayment2;// Changes the numbers as the loop goes
				  
				    
				    
				        
				  OutputHelpers.showStandardDialog(toString(),"Amortization Summary");
				  }
				  return;
				}

			
				
			}
				);
		super.add(btnAmortization, bag);
			
	}
		
				
		
		
	}
