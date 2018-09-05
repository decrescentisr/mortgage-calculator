import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.JPanel;

public class TotalPayment extends JPanel
{
	public static final double ending_balance = 0.0;
	public static final double new_balance = 0.0;
	public static final double interest_paid = 0.0;
	public static final double annual_rate = 0.0;
	public static final double principle_paid = 0.0;
	public static final double payment = 0.0;
	
	Scanner input = new Scanner(System.in);
    DecimalFormat f = new DecimalFormat("$#,###,###.00");

	
	//Setup a counter to count payments
    static int count = 1; 
    
    //Get standard payment which is 1/20 of loan
    payment = (ending_balance / 20.0);
    
    while (ending_balance > 0.0) {
    	new_balance = ending_balance;
    	
    	//Calculate interest by multiplying rate against balance
    	interest_paid = new_balance * (annual_rate / 12.0);
    	
    	//Subtract final payment from running balance
    	ending_balance = new_balance - principle_paid;
    	
    	//If the balance remaining plus the interest is less than the payment amount
    	//Print out 0 balance, the interest paid and that balance minus the interest
    	
    	if((new_balance + interest_paid) < payment) {
    		
    	}
    }
	public static String NONE = "None";
	
	public static double getPaymentTotal()
	{
		return count;
	}
	
}
}
