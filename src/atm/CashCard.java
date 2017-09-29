package atm;
import java.util.*;
/**
 * Holds information about the Cash Card, like the balance, the id, and the expiration date
 * @author Marietta
 * @Date 9/23/2017
 *
 */
public class CashCard {
	//the first letter of the cardNumber will be the bank id; 
	//the last three numbers are the representative account number 
	private String cardNumber; 
	private GregorianCalendar expirationDate; 
	private String password; //to hold the pin for the card
	
	public CashCard(String aCardNumber, GregorianCalendar anExpDate, String aPassword)
	{
		cardNumber = aCardNumber; 
		expirationDate = anExpDate; 
		password = aPassword;
	}
	
	public String getCardNumber()
	{
		return cardNumber; 
	}
	
	public GregorianCalendar getExpiration()
	{
		return expirationDate; 
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setCardNumber(String newCardNumber)
	{
		cardNumber = newCardNumber; 
	}
	
	public void setExpirationDate(GregorianCalendar newDate)
	{
		expirationDate = newDate;
	}
	
	public void setPassword(String newPassword)
	{
		password = newPassword;
	}
	
	/**
	 * Method to check if card is expired - expiration date is past
	 * @return
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
	
	public boolean isPassword(String option)
	{
		//checks if option is the password 
		if(password.equals(option))
		{
			//System.out.println("True. Actual password: " + password);
			//System.out.println("Your password: " + option);
			return true; 
		}
		
		else 
		{
			//System.out.println("False. Actual password: " + password);
			//System.out.println("Your password: " + option);
			return false; 
		}
	}
	
}
