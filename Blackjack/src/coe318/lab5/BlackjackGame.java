package coe318.lab5;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * @author: Jules Gammad 500874689
 */

public class BlackjackGame {

  private CardPile deck;
  private CardPile houseCards;
  private CardPile yourCards;
  private boolean houseDone;
  private boolean playerDone;
  private UserInterface ui;

  public BlackjackGame(UserInterface ui) {
    this.ui = ui;
    ui.setGame(this);
    deck = new CardPile();
    for (int i = 2; i < 15; i++) {
      for (int j = 0; j < 4; j++) {
        deck.add(new Card(i, j, true));
      }
    }
    houseCards = new CardPile();
    yourCards = new CardPile();
    houseDone = false;
    playerDone = false;
  }

  public void start() {
    Card c;
    c = deck.removeRandom();
    c.setFaceUp(false);
    getHouseCards().add(c);
    getHouseCards().add(deck.removeRandom());
    getYourCards().add(deck.removeRandom());
    getYourCards().add(deck.removeRandom());
    ui.display();
  }

  //changed the play() method
  //made each loop seperate for formatting reasons
  public void play() {
      //first while loop deals the action of the house
      //the value of houseDone glitches when I try to prompt the user so
      //seperating the loops was necessary
    while (!houseDone) {
      if (!houseDone) {
        if (score(getHouseCards()) <= 17) {
          getHouseCards().add(deck.removeRandom());
          ui.display();
        } else {
          houseDone = true;
        }
      }
    }
    //when the house exits the loop, user is prompted that it is their turn
    System.out.println("-------------------------");
    System.out.println("HOUSE IS DONE. YOUR TURN");
    System.out.println("-------------------------" + "\n");
    
    //loops through the players actions normally
    while (!playerDone) {
        if (!playerDone) {
        if (ui.hitMe()) {
          getYourCards().add(deck.removeRandom());
          ui.display();
        } else {
          playerDone = true;
        }
      }
    }
  }

  public void end() {
    getHouseCards().getCards().get(0).setFaceUp(true);
    ui.gameOver();
  }

  /**
   * Determine the score of a pile of cards.
   *
   * @param p
   * @return the score
   */
  public int score(CardPile p) {
      //local variable pileScore that wll track all of the ranks in each respective pile
    int pileScore = 0;
    //loops through each card in the pile
    for (Card card: p.getCards()) {
        //if the card rank is 14, it is an ace and therefore add 1 to the pileScore
        if (card.getRank() == 14)
            pileScore += 1;
        //if the card rank is 11,12,13 they are royals and therefore add 10 to the pileScore
        else if(card.getRank() == 11 || card.getRank() == 12 || card.getRank() == 13)
            pileScore += 10;
        //otherwise add the ranks normarlly to pileScore
        else
            pileScore += card.getRank();
    } 
    return pileScore;
  }

  /**
   * @return the houseCards
   */
  public CardPile getHouseCards() {
    return houseCards;
  }

  /**
   * @return the yourCards
   */
  public CardPile getYourCards() {
    return yourCards;
  }

  public static void main(String[] args) {
    BlackjackGame game = new BlackjackGame( new SimpleUI());
    game.start();
    game.play();
    game.end();
  }
}