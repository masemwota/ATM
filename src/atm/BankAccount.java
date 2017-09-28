package atm;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Bank Account has account information like the customer, the balance, and the cashcard
 * @author Marietta
 * @Date 09/23/2017
 *
 */
public class BankAccount {
	private int bank_id; //two digit number representing bank
	private int accountNumber; //the identifier for the actual account
	private double balance; 
	private CashCard card;
	private String password;
	
	public BankAccount(int aBank_id, int anAccountNumber, double aBalance, String aPassword)
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
		
	}
	
	public int getBankID()
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
	public void withdraw(double amount)
	{
		balance -= amount; 
	}
}
