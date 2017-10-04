package atm;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * ATM Tester class runs the ATM class and creates some of the other classes to test
 * @author Marietta Asemwota
 * @Date 10/3/2017
 */
public class ATMSystem {
	
	/**
	 * Ask the user to enter a card number represents entering a card 
	 * 
	 * @return the card number 
	 */
	public String getCardNumber()
	{
		Scanner in = new Scanner(System.in); 
		System.out.println("Please enter a cash card number: ");
		String cardNumber = in.nextLine(); 
		
		return cardNumber; 
	}
	
	
	public static void main(String [] args)
	{
		/*
		 * Creating Banks and getting ATMs
		 * there are two Banks - WellsFargo, and Chase; each bank has two atms
		 */
		Bank wellsFargo = new Bank("A"); 
		ATM atmA1 = wellsFargo.getATM1(); 
		ATM atmA2 = wellsFargo.getATM2(); 
		
		Bank chase = new Bank("B"); 
		ATM atmB1 = chase.getATM1(); 
		ATM atmB2 = chase.getATM2(); 
		
		
		/*
		 * Create Bank Accounts
		 */
		BankAccount anna = new BankAccount("Anna", "A", 114, 80, "sun"); 
		wellsFargo.accounts.put(anna.getAccountNumber(), anna);
		
		BankAccount karen = new BankAccount("Karen", "A", 111, 80, "nina"); 
		wellsFargo.accounts.put(karen.getAccountNumber(), karen);
		
		//Other Bank
		BankAccount bran = new BankAccount("Bran", "B", 218, 40, "muffin"); 
		chase.accounts.put(bran.getAccountNumber(), bran);
		
		BankAccount charlie = new BankAccount("Charlie", "B", 381, 40, "cloud"); 
		chase.accounts.put(charlie.getAccountNumber(), charlie);
		
		BankAccount dave = new BankAccount("Dave", "B", 412, 40, "franco"); 
		chase.accounts.put(dave.getAccountNumber(), dave);
		
		
		/*
		 * For screenshots 
		 */
		//make an expired card 
		GregorianCalendar today = new GregorianCalendar();
		GregorianCalendar cal = new GregorianCalendar(today.get(Calendar.YEAR), today.get(Calendar.MONTH), 1);
		charlie.getCard().setExpirationDate(cal); 
		
		//System.out.println("Expired: " + charlie.getCard().isExpired());
		
		/*
		 * Printing Details
		 */
		//Required 
		
		System.out.println("Bank States: \n");
		System.out.println(wellsFargo.printState());
		System.out.println(chase.printState());
		
		System.out.println("\nATM States: \n");
		System.out.println(atmA1.state());
		//System.out.println(atmA2.state());
		
		//System.out.println(atmB1.state());
		System.out.println(atmB2.state()+"\n");
		
		
		/*
		 * Ask which atm to use 
		 */
		System.out.println("Select which ATM to use: ");
		System.out.println(" Bank A - atm 1 (1) \n Bank A - atm 2 (2) \n Bank B - atm 1 (3) \n Bank B - atm 2 (4) \n");
		Scanner in = new Scanner(System.in); 
		int choice = in.nextInt(); 
		
		
		/*
		 * The ATM sequence
		 */
		if(choice == 1)
		{
			//choose A1
			atmA1.dialog();
		}
		
		else if(choice == 2)
		{
			//choose A2
			atmA2.dialog();
		}
		
		else if(choice == 3)
		{
			//choose B1
			atmB1.dialog();
		}
		
		else if(choice == 4)
		{
			//choose B2
			atmB2.dialog();
		}
		
		else 
		{
			//doesn't choose correctly
			System.out.println("Invalid choice");
		} 
	}
}
