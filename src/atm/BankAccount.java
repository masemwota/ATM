package atm;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Bank Account has account information like the customer, the balance, and the cashcard
 * @author Marietta
 * @Date 09/23/2017
 *
 */
public class BankAccount {
	private String bank_id; //a string representing bank this account is connected to
	private int accountNumber; //the identifier for the actual account
	private double balance; 
	private CashCard card;
	private String password;
	private ArrayList<String> transactions; 
	
	public BankAccount(String aBank_id, int anAccountNumber, double aBalance, String aPassword)
	{
		bank_id = aBank_id;
		accountNumber = anAccountNumber; 
		balance = aBalance; 
		
		//when a bank account is created, a cash card is created as well
		//a cash card object takes in the card number, expiration date, and password 
		GregorianCalendar expDate = new GregorianCalendar();
		expDate.add(Calendar.YEAR, 4);
		String cardN = bank_id + ""+ accountNumber; 
		
		card = new CashCard(cardN, expDate, aPassword); 
		transactions = new ArrayList<String>(); 
	}
	
	public String getBankID()
	{
		return bank_id;
	}
	
	public int getAccountNumber()
	{
		return accountNumber; 
	}
	
	public double getBalance()
	{
		return balance; 
	}
	
	public CashCard getCard()
	{
		return card;
	}
	
	/**
	 * Withdraw money from the account
	 * @param amount
	 */
	public boolean withdraw(double amount)
	{
		//check if amount is greater than balance
		if(amount > balance)
		{
			System.out.println("You a poor bitch");
			return false;
		}
		
		else 
		{
			balance -= amount;
			String transaction = "$" + amount + " withdrawn"; 
			System.out.println(transaction);
			transactions.add(transaction); 
			return true; 
		}
	}
	
	public String state()
	{
		//Customer - Cash Card (bankid: B, account number #: 111), expires on MM/DD/YY, password... 
		//write shit code
		
		return null; 
	}
}
