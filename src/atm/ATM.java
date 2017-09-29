package atm;
import java.util.*;

public class ATM {
	public final int MAX_AMOUNT = 500; //the maximum amount of cash a customer can withdraw per transaction 
	private String bank_id; //the bank_id this ATM is linked to
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
	 * @param cardNumber - the card number to validate
	 */
	public void validateCard(String cardNumber)
	{
		String id = cardNumber.substring(0,1); 
		
		if(!bank_id.equals(id))
		{
			//System.out.println("bank id: " + bank_id + " id: " + id);
			System.out.println("The card is not supported by this ATM");
			return; 
		}
		
		//process card into an object 
		CashCard myCard = findCard(cardNumber); 
		
		//check if the card is expired or not
		if(myCard.isExpired())
		{
			System.out.println("The card is expired");
			return; 
		}
		
		//if the method is still running at this point, everything is okay 
		//run authorization dialog
		authorizationDialog(myCard);
	}
	
	public CashCard findCard(String cardNumber)
	{
		//takes the card number and searches the array list of the bank for the account number 
		//this method will only be called if the card belongs to this bank
		int accountNum = Integer.parseInt(cardNumber.substring(1,cardNumber.length())); 
		BankAccount myBA; 
		
		myBA = myBank.getAccount(accountNum); 
	
		CashCard myCard; 
		if(myBA != null)
		{
			myCard = myBA.getCard(); 
			return myCard;
		}
		else 
			return null;
	}
	
	public void authorizationDialog(CashCard myCard)
	{
		String password = getPassword(); 
		//The ATM verifies password with the bank. 
		//The ATM receives the result of authorization (accept/reject) from bank.
		boolean correct = myCard.isPassword(password);
		
		//For the authorization is rejected, the relevant error message is displayed and card is returned to the customer. 
		while (!correct) 
		{
			System.out.println("The password is incorrent. Please try again or enter \"-1\" to quit");
			password = getPassword();
			
			if (password == null)
			{
				System.out.println("You have chosen to quit");
				return; 
			}
			
			else 
			{
				correct = myCard.isPassword(password);
			}
		}
		
		//at this point, the password should be correct, or the method would have returned 
		//If authorization is accepted, start transaction dialog.
		transactionDialog(myCard); 
	}
	
	
	public void transactionDialog(CashCard myCard)
	{
		System.out.println("Transaction dialog");
	}
	
	public String getPassword()
	{
		//The customer is asked to enter the password. 
		Scanner in = new Scanner(System.in); 
		System.out.println("Please enter the password: ");
		String password = in.nextLine(); 
		
		if(password.equals("-1"))
		{
			return null; 
		}
		return password; 
		//The ATM verifies password with the bank. 
		//The ATM receives the result of authorization (accept/reject) from bank.
		//boolean correct = myCard.isPassword(password);
	}
	
	/**
	 * Ask the user to enter a card number 
	 * represents entering a card 
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
	
	
	public void dialog()
	{
		/*
		 * The ATM sequence
		 */
		
		//The user tries to use the ATM 
		//ask the user to enter the number 
		String cardNumber = getCardNumber(); 
		System.out.println("Card number: " + cardNumber);
		validateCard(cardNumber); //validate the card
		
		//If it not valid, display error message and return card to the customer. If the card is valid, the ATM Initiate authorization dialog.
		//valid card -> begin authorization
		//authorizationDialog(myCard); /****Change later ******/
		
			//if not valid -> display error message and return card
			//System.out.println("Sorry this card is not valid. Either this is the wrong atm or the card is expired.");
			System.out.println("Please take your card"); 
		}
	}
