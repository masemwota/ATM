package atm;
import java.util.*;

/**
 * ATM class has the method and variables needed to operate the ATM
 * @author Marietta Asemwota
 * @Date 10/3/2017
 */
public class ATM {
	public final int MAX_AMOUNT = 100; //the maximum amount of cash a customer can withdraw per transaction 
	private String bank_id; //the bank_id this ATM is linked to
	private Bank myBank; //the bank this ATM belongs to
	private int id; //the atm id
	private double cash; //the amount of cash left in the atm

	//temp variables for the card accessing the ATM
	BankAccount theBA; 
	CashCard theCard; 
	
	Scanner in; 
	
	/**
	 * The Constructor for the ATM takes a bank and the id of the atm
	 * @param b - the bank this atm belongs to
	 * @param theID - the identity of this atm
	 */
	public ATM(Bank b, int theID)
	{
		myBank = b; 
		bank_id = b.getBankID(); 
		id = theID; 
	}
	
	
	/**
	 * Get the atm identity
	 * @return the id of the atm
	 */
	public int getID()
	{
		return id; 
	}
	
	/**
	 * Validates a cash card. 
	 * A card is valid if: 1) it is not expired;
	 * 2)its bank id is correct for the bank associated with the atm
	 * 
	 * @param cardNumber - the card number to validate
	 * @precondition cardNumber must be in the valid format of (X###) where x is bank_id
	 */
	public void validateCard(String cardNumber)
	{
		String id = cardNumber.substring(0,1); 
		
		if(!bank_id.equals(id)) //if this bank id doesn't match the atm
		{
			System.out.println("The card is not supported by this ATM");
			return; 
		}
		
		//process card into an object 
		theCard = findCard(cardNumber); 
		
		//check if the card is expired or not
		if(theCard.isExpired())
		{
			System.out.println("The card is expired");
			return; 
		}
		
		//if the method is still running at this point, everything is okay 
		//run authorization dialog
		authorizationDialog();
	}
	
	
	/**
	 * Method to find the cash card given the card number 
	 * @param cardNumber - the card number 
	 * @precondition - the cardNumber must be in the correct format (X###) 
	 * @return the cash card linked to the number; null object if it doesn't exist
	 */
	public CashCard findCard(String cardNumber)
	{
		//takes the card number and searches the array list of the bank for the account number 
		//this method will only be called if the card belongs to this bank
		int accountNum = Integer.parseInt(cardNumber.substring(1,cardNumber.length())); 
		
		theBA = myBank.getAccount(accountNum); 
	
		CashCard myCard; 
		if(theBA != null)
		{
			myCard = theBA.getCard(); 
			return myCard;
		}
		else 
			return null; //when the bank doesn't return a card - so doesn't exist
	}
	
	
	/**
	 * Runs the authorization dialog - asks for and checks the password 
	 */
	public void authorizationDialog()
	{
		String password = getPassword(); //calls a method which gets the password
		boolean correct = theCard.isPassword(password);
		
		//If the authorization is rejected, the relevant error message is displayed and card is returned to the customer. 
		while (!correct) 
		{
			System.out.println("The password is incorrent. Please try again or enter \"-1\" to quit");
			password = getPassword(); //ask for the password again
			
			if (password == null) //if the string object is null - incorrect input
			{
				System.out.println("You have chosen to quit");
				return; 
			}
			
			else 
			{
				correct = theCard.isPassword(password); //the password is correct
			}
		
		}
		//at this point, the password should be correct, or the method would have returned 
		//If authorization is accepted, start transaction dialog.
		in = new Scanner(System.in); 
		boolean again = true; 
		while(again)
		{
			transactionDialog(); 
			
			System.out.println("Do you want to make another transaction (Y/N)");
			String choice = in.next(); 
			
			if(choice.equalsIgnoreCase("N"))
				again = false; 
		}
	}
	
	
	/**
	 * Runs the transaction dialog - asks and checks that the amount is valid 
	 */
	public void transactionDialog()
	{
		//Transaction dialog: When authorization is successfully completed, the customer can withdraw money by entering an amount. 
		double amount = getAmount(); //gets the amount
		
		//If the amount is not within the pre-defined transaction limit at the ATM 
		while (amount > MAX_AMOUNT)
		{
			//display an error message asking the customer to redo the transaction. 
			System.out.println("The amount is over pre-defined limit. Please redo transaction");
			amount = getAmount(); 
		}
		
		//tries to withdraw money, and is told whether it works
		boolean success = theBA.withdraw(amount); 
		
		while(!success)
		{
			//if not successful, the customer should enter a different amount
			System.out.println("Please enter a different amount.");
			amount = getAmount(); //get the different amount
			success = theBA.withdraw(amount); 
			cash -= amount; 
		}
			
		cash -= amount; 
		System.out.println("Transaction complete. Please take your money.");
	}
	
	/**
	 * Ask the user to enter an amount to withdraw
	 * Represents entering a card 
	 * 
	 * @return the amount
	 */
	public double getAmount()
	{
		in = new Scanner(System.in); 
		System.out.println("Enter an amount to withdraw: ");
		double amount = in.nextDouble(); 
		
		return amount; 
	}
	
	
	/**
	 * Obtain the password from the user to be used in the program
	 * @return the password 
	 */
	public String getPassword()
	{
		//The customer is asked to enter the password. 
		in = new Scanner(System.in); 
		System.out.println("Please enter the password: ");
		String password = in.nextLine(); 
		
		if(password.equals("-1"))
		{
			return null; 
		}
		return password; 
	}
	
	/**
	 * Ask the user to enter a card number 
	 * represents entering a card 
	 * 
	 * @return the card number 
	 */
	public String getCardNumber()
	{
		in = new Scanner(System.in); 
		System.out.println("Please enter a cash card number: ");
		String cardNumber = in.nextLine(); 
		
		return cardNumber; 
	}
	
	
	
	/**
	 * The main atm sequence of the ATM program
	 * This lets the user use the ATM
	 */
	public void dialog()
	{
		//ask the user to enter the number 
		String cardNumber = getCardNumber(); 
		System.out.println("Card number: " + cardNumber);
		validateCard(cardNumber); //validateCard calls all the other parts of the program
		
		//At this point the dialog should be over. 
		System.out.println("Please take your card"); 
	}
	
	
	/**
	 * Get the state of the ATM. It tells the identity of the ATM as well as the withdrawal limit
	 * @return the state as a string
	 */
	public String state()
	{
		//ATM1_A: (ATM1 from BankofA)
		// The maximum amount of cash a card can widthraw per day: $50
		String state = ""; 
		state += "ATM" + id + "_" + bank_id + ": "; 
		state += "(ATM" + id + " from Bank of " + bank_id + ")"; 
		
		state += "The maximum amount of cash a card can withdraw per day: $" + MAX_AMOUNT; 
		
		return state; 
	}
}
