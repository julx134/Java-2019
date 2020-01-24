package coe318.lab5;
/**
 *
 * @author Jules Gammad 500874689
 */

import java.util.ArrayList;
import java.lang.Math;

/**
 * A pile of cards.
 *
 */
public class CardPile {
    //Instance variables
    private ArrayList<Card> cards;
   
    public CardPile() {
        //Initialize the instance variable.
    	cards = new ArrayList <Card> ();
    }
    
    
    /**
     * Add a card to the pile.
     * @param card
     */
    public void add(Card card) {
        cards.add(card);
    }
    
    /**
     * Remove a card chosen at random from the pile.
     * @return
     */
    public Card removeRandom() {
        //uses the Math.random function from java Math library
        //the variable shrinks or expands depending on cards.size()
    	int removeCounter = (int)(Math.random()*cards.size())+ 0;
        //return the card that has been removed
    	return cards.remove(removeCounter);
    }

    /**
     * The string representation is a space separated list
     * of each card.
     * @return
     */
    @Override
    public String toString() {
        //loops through the arraylist and concatonates each card value into 
        //string variable deck
    	String deck = "";
        for (Card card: cards)
        	deck = deck.concat(card.toString() + "\n");
        
        return deck;
    }
    
    /**
     * @return the cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    public static void main(String[] args) {
        CardPile p = new CardPile();
        p.add(new Card(2, 1, true));
        p.add(new Card(3, 2, true));
        p.add(new Card(4, 3, false));
        p.add(new Card(14, 1, true));
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("");
        
        CardPile deck = new CardPile();
        for(int i = 2; i < 15; i++) {
            for(int j = 0; j < 4; j++) {
                deck.add(new Card(i, j, true));
            }
        }
        
        for (int i = 0; i < 52; i++) {
            System.out.println((i+1) + ": " + deck.removeRandom());

        }
    }


}