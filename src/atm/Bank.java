package atm;
import java.util.*;
/**
 * Bank class holds the atms and all the accounts in the bank
 * @author Marietta Asemwota
 * @Date 9/23/2017
 */
public class Bank {
	public String bank_id; //the id for this bank 
	
	//public ArrayList<BankAccount> accounts; //to hold the accounts in this bank 
	public TreeMap <Integer, BankAccount> accounts; //to hold the accounts in this bank 
	//the key is the account number, and the value is the actuall account
	
	public Bank(String id)
	{
		bank_id = id;
		accounts = new TreeMap<Integer, BankAccount>();
	}
	
	public String getBankID()
	{
		return bank_id;
	}
	
	public TreeMap<Integer, BankAccount> getAccounts()
	{
		return accounts; 
	}
	
	public BankAccount getAccount(int accountNumber)
	{
		//takes a number and returns the account with that number
		BankAccount myBA; 
		
		if (accounts.containsKey(accountNumber))
			myBA = accounts.get(accountNumber); 
		else 
			myBA = null; 
		
		return myBA; 
	}
}
