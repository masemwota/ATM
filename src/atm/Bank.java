package atm;
import java.util.*;
/**
 * Bank class holds the atms and all the accounts that belong to the bank
 * @author Marietta Asemwota
 * @Date 9/23/2017
 */
public class Bank {
	public String bank_id; //the id for this bank 
	public TreeMap <Integer, BankAccount> accounts; //to hold the accounts in this bank 
	//the key is the account number, and the value is the actual account
	
	//each bank has two ATMs
	public ATM atm1; 
	public ATM atm2; 
		
		
	/**
	 * Constructor for the Bank takes the bank id
	 * @param id - the bank id
	 */
	public Bank(String id)
	{
		bank_id = id; 
		accounts = new TreeMap<Integer, BankAccount>();
		
		//each bank has two ATMs
		atm1 = new ATM(this, 1); 
		atm2 = new ATM(this, 2); 
	}
	
	
	/**
	 * Get the first ATM for this bank 
	 * 
	 * @return the ATM
	 */
	public ATM getATM1()
	{
		return atm1; 
	}
	
	/**
	 * Get the first ATM for this bank 
	 * 
	 * @return the ATM
	 */
	public ATM getATM2()
	{
		return atm2; 
	}
	
	/**
	 * Get the Bank ID for this bank 
	 * 
	 * @return bank_id as a string
	 */
	public String getBankID()
	{
		return bank_id;
	}
	
	/**
	 * Get a list of the accounts in this bank 
	 * @return treeMap of accounts
	 */
	public TreeMap<Integer, BankAccount> getAccounts()
	{
		return accounts; 
	}
	
	
	/**
	 * Get the bank account with the provided account number 
	 * @param accountNumber - the account number to look for
	 * @return the linked BankAccount or null if it doesn't exist
	 */
	public BankAccount getAccount(int accountNumber)
	{
		BankAccount myBA; 
		
		if (accounts.containsKey(accountNumber))
			myBA = accounts.get(accountNumber); 
		else 
			myBA = null; 
		
		return myBA; 
	}
	
	
	/**
	 * Print the state of the bank - the accounts at the bank
	 * @return the states of the accounts in the bank
	 */
	public String printState()
	{
		/* template ---
		BankofB (three customers)
		Customer - Cash Card (bankid: B, account number #: 111), expires on MM/DD/YY, password... 
		Customer - Cash Card (bankid: B, account number #: 122), expires on MM/DD/YY, password... 
		Customer - Cash Card (bankid: B, account number #: 133), expires on MM/DD/YY, password... 
		 */
		String state = ""; 
		state += "Bank of " + bank_id + " ("; 
		int customers = accounts.size(); 
		state += customers + " customers) \n";
		
		//for each account
		for(int accountNum : accounts.keySet())
		{
			//get the state
			BankAccount ba = accounts.get(accountNum); 
			state += ba.getState() + "\n"; 
		}
		
		return state;
	}
}
