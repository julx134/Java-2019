package coe318.lab5;

//@author Jules Gammad 500874689

public class Card implements Comparable {
  //Symbolic constant
  public static final int CLUB = 0;
  public static final int DIAMOND = 1;
  public static final int HEART = 2;
  public static final int SPADE = 3;
  
  //declaring instance varaiables
  private int rank;
  private int suit;
  private boolean faceUp;

  /**
   * Construct a card of the given rank, suit and whether it is faceup or
   * facedown. The rank is an integer from 2 to 14. Numbered cards (2 to 10)
   * have a rank equal to their number. Jack, Queen, King and Ace have the ranks
   * 11, 12, 13, and 14 respectively. The suit is an integer from 0 to 3 for
   * Clubs, Diamonds, Hearts and Spades respectively.
   *
   * @param rank
   * @param suit
   * @param faceUp
   */
  public Card(int rank, int suit, boolean faceUp) {
    //initializing the instance variables throught he constructor
    this.rank = rank;
    this.suit = suit;
    this.faceUp = faceUp;
  }

  /**
   * @return the faceUp
   */
  public boolean isFaceUp() {
    return faceUp;
  }

  /**
   * @param faceUp the faceUp to set
   */
  public void setFaceUp(boolean faceUp) {
    this.faceUp = faceUp;
  }

  /**
   * @return the rank
   */
  public int getRank() {
    return rank;
  }

  /**
   * @return the suit
   */
  public int getSuit() {
    return suit;
  }

  @Override
  //method that checks if this card object is equal to the comparing object
  public boolean equals(Object ob) {
    if (!(ob instanceof Card)) {
      return false;
    }
    //cast ob as type Card
    Card c = (Card) ob;
    //check to see if the ob has the same suit and rank as 'this' object
    if(c.suit == this.suit && c.rank == this.rank)
    	return true; //return true if it matches
    else
    	return false; //false if it doesn't
  }

  @Override
  public int hashCode() {//DO NOT MODIFY
    int hash = 7;
    hash = 31 * hash + this.getRank();
    hash = 31 * hash + this.getSuit();
    return hash;
  }

  @Override
  public int compareTo(Object obj) {//DO NOT MODIFY
    return compareTo((Card) obj);
  }

  //method that compares the this card object to the object passed
  public int compareTo(Card c) {
          //returns pos value if this object is bigger
	  if (rank > c.rank)
		  return 1;
          //returns neg value if this object is smaller
	  else if (rank < c.rank)
		  return -1;
          //checks the suit since the ranks are equal
	  else {
              //returns pos value if the suit is bigger
              if (suit > c.suit)
		  return 1;
              //returns neg value if the suit is smaller
              else if (suit < c.suit)
                  return -1;
              //otherwise both are equal and therefore return 0
              else
                  return 0;
          }
  }

  /**
   * Return the rank as a String. For example, the 3 of Hearts produces the
   * String "3". The King of Diamonds produces the String "King".
   *
   * @return the rank String
   */
  
  public String getRankString() {
    //switch statements that take @rank as argument
    //when rank is 11-14, return jack, queen, king and ace respectively
    switch (rank) {
         case 11:
            return "Jack";
         case 12:
            return "Queen";
         case 13:
            return "King";
         case 14:
            return "Ace";
        //when the rank is neither of the cases above, return it's value as string
         default:
            return ""+ rank;
    }
  }

  /**
   * Return the suit as a String: "Clubs", "Diamonds", "Hearts" or "Spades".
   *
   * @return the suit String
   */
  public String getSuitString() {
      //switch that takes suit as an argument
      //when suit is 0-3, return clubs, diamonds, hearts and spades respectively.
    switch (suit) {
        case 0:
            return "Clubs";
        case 1:
            return "Diamonds";
        case 2:
            return "Hearts";
        case 3:
            return "Spades";
        //default case
        default:
            return "";
    }
  }

  /**
   * Return "?" if the card is facedown; otherwise, the rank and suit of the
   * card.
   *
   * @return the String representation
   */
  @Override
  public String toString() {
    //when faceUp is true return the string equivalent of the value of Card
    if (faceUp)
        return getRankString() + " of " + getSuitString();
    //otherwise if it's facedown, return '?'
    else
        return "?";
  }

  public static void main(String[] args) {
    //Create 5 of clubs
    Card club5 = new Card(5, 0, true);
    System.out.println("club5: " + club5);
    Card spadeAce = new Card(14, SPADE, true);
    System.out.println("spadeAce: " + spadeAce);
    
    
    System.out.println("club5 compareTo spadeAce: "
            + club5.compareTo(spadeAce));
    
    System.out.println("club5 compareTo club5: "
            + club5.compareTo(club5));
    
    System.out.println("club5 equals spadeAce: "
            + club5.equals(spadeAce));
    
    System.out.println("club5 equals club5: "
            + club5.equals(club5));
  }
}