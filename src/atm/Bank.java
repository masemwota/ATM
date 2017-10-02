package atm;
import java.util.*;
/**
 * Bank class holds the atms and all the accounts in the bank
 * @author Marietta Asemwota
 * @Date 9/23/2017
 */
public class Bank {
	public String bank_id; //the id for this bank 
	
	//public ArrayList<BankAccount>  accounts; //to hold the accounts in this bank 
	public TreeMap <Integer, BankAccount> accounts; //to hold the accounts in this bank 
	//the key is the account number, and the value is the actual account
	
	//each bank has two ATMs
	public ATM atm1; 
	public ATM atm2; 
		
		
		
	public Bank(String id)
	{
		bank_id = id; 
		accounts = new TreeMap<Integer, BankAccount>();
		
		//each bank has two ATMs
		atm1 = new ATM(this); 
		atm2 = new ATM(this); 
	}
	
	public ATM getATM1()
	{
		return atm1; 
	}
	
	public ATM getATM2()
	{
		return atm2; 
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
	
	public String printState()
	{
		/*
		BankofB (three customers)
		Customer - Cash Card (bankid: B, account number #: 111), expires on MM/DD/YY, password... 
		Customer - Cash Card (bankid: B, account number #: 122), expires on MM/DD/YY, password... 
		Customer - Cash Card (bankid: B, account number #: 133), expires on MM/DD/YY, password... 
		 */
		String state = ""; 
		int customers = accounts.size(); 
		state += customers + " customers \n";
		
		//for each account, get the account info
		
		return state;
	}
}
