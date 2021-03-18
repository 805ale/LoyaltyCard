
/**
 * Represents a collection of loyalty cards using a simple array.
 *
 * @author Alexandra Vaida
 * @version w18001218
 */
public class LoyaltyCardArrayClass
{
    private int currentIndex;
    private LoyaltyCard[] loyaltyCards;

    /**
     * Constructor for the LoyaltyCardArrayClass class. It sets the size of the
     * array at runtime and initialises the variable currentIndex.
     */
    public LoyaltyCardArrayClass(int maxNoOfLoyaltyCards)
    {
        loyaltyCards = new LoyaltyCard[maxNoOfLoyaltyCards];
        currentIndex = 0;
    }

    /**
     * Checks if there is enough space for a new loyaltyCard to be added to the
     * array and, if so, adds it using the LoyaltyCard class. Otherwise, it 
     * produces an error message.
     * 
     * @param loyaltyCard
     */
    public void addLoyaltyCard(LoyaltyCard loyaltyCard)
    {
        if( currentIndex < loyaltyCards.length )
        {
            loyaltyCards[currentIndex] = loyaltyCard;
            currentIndex++;
            System.out.println("Loyalty Card successfully added!");
        }
        else
        {
            System.out.println("Membership full. Could not add LoyaltyCard!");
        }
    }
    
    /**
     * Returns the size of the array.
     * 
     * @return the capacity
     */
    public int getCapacity()
    {
        return loyaltyCards.length;
    }
    
    /**
     * Returns the number of loyalty cards.
     * 
     * @return the number of loyalty cards
     */
    public int getNumberOfLoyaltyCards()
    {
        return currentIndex;
    }
    
    /**
     * Print all loyalty cards.
     */
    public void printAllLoyaltyCards()
    {
        if ( currentIndex > 0 )
        {
            for ( int i = 0 ; i < currentIndex; i++ )
            {
                loyaltyCards[i].printCustomerDetails();
            }
        }
        else
        {
            System.out.println("No loyaltyCards to display.");
        }
    }
    
    /**
     * Print a loyalty card given a card number. If the card does not exist, an error
     * message will be output.
     * 
     * @param cardNumber
     */
    public boolean printLoyaltyCard(String cardNumber)
    {
        for ( LoyaltyCard loyaltyCard: loyaltyCards )
            if ( cardNumber.equals(loyaltyCard.getCardNumber()))
            {
                loyaltyCard.printCustomerDetails();
                return true;
            }
        return false;
    }
    
    /**
     * Remove a loyalty card given a card number. Reorganise the remaining elements of the 
     * array.
     * 
     * @param cardNumber
     */
    public boolean removeLoyaltyCard(String cardNumber)
    {
        for(int i = 0; i < currentIndex; i++)
        {
            if(loyaltyCards[i].getCardNumber().equals(cardNumber))
            {
                squash(i);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Search for a card given a card number and return the index. If invalid, return -1.
     * 
     * @param cardNumber
     */
    public int search(String cardNumber)
    {
        int index = 0;
        for (LoyaltyCard loyaltyCard : loyaltyCards)
        {
            if (cardNumber.equals(loyaltyCard.getCardNumber()))
            {
                return index;
            }
            else
            {
                index++;
            }
        }
        return -1;
    }
    
    private void squash(int index)
 {
     if ( index >= 0 )
     {
        for ( int i = index ; i < currentIndex - 1 ; i++)
        {
             loyaltyCards[i]= loyaltyCards[i+1];
        }
        loyaltyCards[ currentIndex - 1] = null;
        currentIndex--;
      }
}

}
