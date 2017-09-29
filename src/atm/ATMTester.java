package atm;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ATMTester {
	
	/**
	 * Ask the user to enter a card number 
	 * represents entering a card 
	 * 
	 * @return the card number 
	 */
	public static String getCardNumber()
	{
		Scanner in = new Scanner(System.in); 
		System.out.println("Please enter a cash card number: ");
		String cardNumber = in.nextLine(); 
		
		return cardNumber; 
	}
	
	
	public static void main(String [] args)
	{
		//there are two Banks - WellsFargo, and Chase
		Bank WellsFargo = new Bank("A"); 
		ATM atmA1 = new ATM(WellsFargo); 
		ATM atmA2 = new ATM(WellsFargo); 
		
		Bank Chase = new Bank("B"); 
		ATM atmB1 = new ATM(Chase); 
		ATM atmB2 = new ATM(Chase); 
		
		
		BankAccount myAccount = new BankAccount("A", 345, 200, "pass"); 
		WellsFargo.accounts.put(myAccount.getAccountNumber(), myAccount);
		
		CashCard baCard = myAccount.getCard();
		System.out.println("Card number: " + baCard.getCardNumber());
		
		GregorianCalendar exp = baCard.getExpiration();
		System.out.println("Expiration Date: " + exp.get(Calendar.MONTH) + "/" + exp.get(Calendar.DAY_OF_MONTH) + "/" + exp.get(Calendar.YEAR));
		System.out.println("This card has expired: " + baCard.isExpired());
		
		System.out.println("\nCurrent balance: " + myAccount.getBalance());
		System.out.println("Withdraw $50");
		myAccount.withdraw(50.0); 
		System.out.println("New balance: " + myAccount.getBalance());
		
		
		
		/*
		 * The ATM sequence
		 * This example -- using ATM wa
		 */
		atmA1.dialog();
		//The user tries to use the ATM 
		//ask the user to enter the number 
		//String cardNumber = getCardNumber(); 
		//System.out.println("Card number: " + cardNumber);
	//	boolean valid = atmA1.validateCard(cardNumber); //validate the card
		
		//If it not valid, display error message and return card to the customer. If the card is valid, the ATM Initiate authorization dialog.
	
		/*
		if (valid)
		{
			//valid card -> begin authorization
			atmA1.authorizationDialog(baCard); /****Change later *****
		}
		
		else 
			{
			//if not valid -> display error message and return card
			//System.out.println("Sorry this card is not valid. Either this is the wrong atm or the card is expired.");
			System.out.println("Please take your card"); 
		}
		
		*/
	}
}
