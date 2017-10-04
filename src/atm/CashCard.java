package atm;
import java.util.*;
/**
 * Holds information about the Cash Card, like the balance, the id, and the expiration date
 * @author Marietta Asemwota 
 * @Date 9/23/2017
 *
 */
public class CashCard {
	//the first letter of the cardNumber will be the bank id; 
	//the last three numbers are the representative account number 
	private String cardNumber; 
	private GregorianCalendar expirationDate; 
	private String password; //to hold the pin for the card
	
	
	/**
	 * Constructor for the cash card takes the card number, the expiration date, and the password 
	 * @param aCardNumber - the card number 
	 * @param anExpDate - the expiration date 
	 * @param aPassword - the password for the card
	 */
	public CashCard(String aCardNumber, GregorianCalendar anExpDate, String aPassword)
	{
		cardNumber = aCardNumber; 
		expirationDate = anExpDate; 
		password = aPassword;
	}
	
	
	/**
	 * Get the card number for this card
	 * @return the card number 
	 */
	public String getCardNumber()
	{
		return cardNumber; 
	}
	
	
	/**
	 * Get the account number for the linked account 
	 * @return the account number 
	 */
	public int getAccountNumber()
	{
		int accountNum = Integer.parseInt(cardNumber.substring(1,cardNumber.length()));
		return accountNum; 
	}
	
	/**
	 * Get the expiration date for this cash card as a Gregorian Calendar 
	 * @return the expiration date
	 */
	public GregorianCalendar getExpiration()
	{
		return expirationDate; 
	}
	
	/**
	 * Get the password for the cash card 
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}
	
	/**
	 * Set a new card number for the cash card
	 * @param newCardNumber - the new cash card number 
	 * @precondition - the card number must be valid
	 */
	public void setCardNumber(String newCardNumber)
	{
		cardNumber = newCardNumber; 
	}
	
	/**
	 * Set the expiration date for the card to a new Gregorian calendar
	 * @param newDate - the new date to set the expiration date to
	 * @precondition - the new date must be a Gregorian calendar and make sense
	 */
	public void setExpirationDate(GregorianCalendar newDate)
	{
		expirationDate = newDate;
	}
	
	/**
	 * Set the password for the cash card 
	 * @param newPassword - the new password to set it to 
	 */
	public void setPassword(String newPassword)
	{
		password = newPassword;
	}
	
	/**
	 * Method to check if card is expired - expiration date is past
	 * @return true if the card is expired; false if not expired 
	 */
	public boolean isExpired()
	{
		GregorianCalendar today = new GregorianCalendar();
		
		if(expirationDate.before(today)) 
		{
			return true; 
		}
		
		return false; 
	}
	
	
	/**
	 * Get the expiration date of the card as a string
	 * @return the expiration date 
	 */
	public String getExpirationString() {
		String year = Integer.toString(expirationDate.get(Calendar.YEAR));
		String month = Integer.toString(expirationDate.get(Calendar.MONTH)+1);
		String day = Integer.toString(expirationDate.get(Calendar.DAY_OF_MONTH));
		
		String date = month + "/" + day + "/" + year; 
		
		return date;
	}

	
	/**
	 * Checks if the provided password is the correct password for the card
	 * @param option - the password to check
	 * @return true if the password is correct; false otherwise 
	 */
	public boolean isPassword(String option)
	{
		//checks if option is the password 
		if(password.equals(option))
		{
			return true; 
		}
		
		else 
		{
			return false; 
		}
	}
	
}
