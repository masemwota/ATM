package atm;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Bank Account has account information like the customer, the balance, and the cashcard
 * @author Marietta Asemwota
 * @Date 09/23/2017
 *
 */
public class BankAccount {
	private String customer; 
	private String bank_id; //a string representing bank this account is connected to
	private int accountNumber; //the identifier for the actual account
	private double balance; 
	private CashCard card;
	private String password;
	private ArrayList<String> transactions; //list of all the transactions
	
	
	/**
	 * The Constructor for the Bank Account class takes customer, id, account number, etc 
	 * @param aCustomer - the name of the customer 
	 * @param aBank_id - the bank that this account belongs to
	 * @param anAccountNumber - the account number 
	 * @param aBalance - the balance for this account
	 * @param aPassword - the password for the card 
	 */
	public BankAccount(String aCustomer, String aBank_id, int anAccountNumber, double aBalance, String aPassword)
	{
		customer = aCustomer;
		bank_id = aBank_id;
		accountNumber = anAccountNumber; 
		balance = aBalance; 
		password = aPassword; 
		
		//when a bank account is created, a cash card is created as well
		//a cash card object takes in the card number, expiration date, and password 
		GregorianCalendar expDate = new GregorianCalendar();
		expDate.add(Calendar.YEAR, 4);
		String cardN = bank_id + ""+ accountNumber; 
		
		card = new CashCard(cardN, expDate, aPassword); 
		transactions = new ArrayList<String>(); 
	}
	
	
	/**
	 * Get the name of the customer 
	 * @return the customer 
	 */
	public String getCustomer()
	{
		return customer; 
	}
	
	
	/**
	 * Set the customer name to the provided name
	 * @param aCustomer - the name to change to 
	 */
	public void setCustomer(String aCustomer)
	{
		customer = aCustomer; 
	}
	
	
	/**
	 * Get the bank id of the bank this account belongs to 
	 * @return the bank id
	 */
	public String getBankID()
	{
		return bank_id;
	}
	
	
	/**
	 * Get the account number for this account
	 * @return account number
	 */
	public int getAccountNumber()
	{
		return accountNumber; 
	}
	
	
	/**
	 * Get the current balance of this bank account 
	 * @return the balance
	 */
	public double getBalance()
	{
		return balance; 
	}
	
	
	/**
	 * Get the cash card linked to this bank account 
	 * @return the cash card
	 */
	public CashCard getCard()
	{
		return card;
	}
	
	/**
	 * Withdraw money from the account
	 * @param amount - the amount to withdraw 
	 * @precondition - the amount has to be valid
	 */
	public boolean withdraw(double amount)
	{
		//check if amount is greater than balance
		if(amount > balance)
		{
			System.out.println("Not enough money in account");
			return false;
		}
		
		else 
		{
			balance -= amount;
			String transaction = "$" + amount + " withdrawn"; 
			System.out.println(transaction);
			System.out.println("$" + balance + " remaining");
			transactions.add(transaction); 
			return true; 
		}
	}
	
	
	/**
	 * Get the state of the bank account 
	 * Get the bank id, the account number, and expiration date
	 * @return the state of the account
	 */
	public String getState()
	{
		//Customer - Cash Card (bankid: B, account number #: 111), expires on MM/DD/YY, password... 
		String state = ""; 
		state += customer + " with Cash Card (bankid: " + bank_id + ", account number: " + accountNumber + ", expires on: " + card.getExpirationString();
		state += ", password: " + password + ")"; 
		
		return state; 
	}
}
