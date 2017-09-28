package atm;
import java.util.*;

public class ATM {
	public final int MAX_AMOUNT = 500; //the maximum amount of cash a customer can withdraw per transaction 
	private int  bank_id; //the bank_id this ATM is linked to - two digits
	private Scanner in; 
	private Bank myBank; 
	//reads a cash card number 
	//checks if the card is valid 
	
	
	public ATM(Bank b)
	{
		//an ATM has a bank it is linked to
		myBank = b; 
		bank_id = b.getBankID(); 
	}
	
	//the ATM read a cash card number and determines if it is valid
	//a card is valid if: 1) it is not expired; 2)its bank id is correct for the bank associated with the atm
	
	/**
	 * Validates a cash card. 
	 * A card is valid if: 1) it is not expired;
	 * 2)its bank id is correct for the bank associated with the atm
	 * 
	 * @return true if card is valid; otherwise false
	 */
	public boolean validateCard(String cardNumber)
	{
		int id = Integer.parseInt(cardNumber.substring(0,2)); 
		
		if(bank_id != id)
		{
			return false; 
		}
		
		//check if the card is expired or not
		//process card into an object 
		CashCard myCard = findCard(cardNumber); 
		
		if(myCard.isExpired())
			return false; 
		
		return true; 
	}
	
	public CashCard findCard(String cardNumber)
	{
		//takes the card number and searches the array list of the bank for the account number 
		//this method will only be called if the card belongs to this bank
		int accountNum = Integer.parseInt(cardNumber.substring(2,cardNumber.length())); 
		BankAccount myBA = myBank.getAccount(accountNum); 
		
		CashCard myCard = myBA.getCard(); 
		
		return myCard; 
	}
	
	public void authorizationDialog(CashCard myCard)
	{
		//The customer is requested to enter his password. The ATM verifies password with the bank. 
		//The ATM receives the result of authorization (accept/reject) from bank. 
		//For the authorization is rejected, the relevant error message is displayed and card is returned to the customer. 
		//If authorization is accepted, start transaction dialog.
	}
}
