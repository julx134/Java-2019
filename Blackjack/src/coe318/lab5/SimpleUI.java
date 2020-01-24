package coe318.lab5;

import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

  @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

  @Override
    public void display() {
        //displays the pile from user and house
        System.out.println("HOUSE CARDS:");
        System.out.println(game.getHouseCards().toString());
        System.out.println("YOUR CARDS:");
        System.out.println(game.getYourCards().toString());
    }

  @Override
    public boolean hitMe() {
        //String input for while-loop validation
        String input = null;
        //do while that validates user input
        do {
            //reset user value
            user.reset();
            //prompt user
            System.out.print("Do you want another card? ");
            input = user.nextLine();     
            //loop only exits if the user inputs the key phrases below
        }while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("y")
                && !input.equalsIgnoreCase("no") && !input.equalsIgnoreCase("n"));
        
        //if the input is yes, return true. Otherwise return false
        if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y"))
            return true;
        else
            return false;
    }

  @Override
    public void gameOver() {
        //local variables that keep track of the house and user score values
        int houseScore = game.score(game.getHouseCards());
        int yourScore = game.score(game.getYourCards());
        
        //display final deck value for house and user
        System.out.println("HOUSE CARDS:");
        System.out.println(game.getHouseCards().toString());
        System.out.println("YOUR CARDS:");
        System.out.println(game.getYourCards().toString());
        //prints the score for user and house
        System.out.println("Your score: " + yourScore + ", " +
                           "House score: " + houseScore );
        //end-game rules
        if(yourScore > 21)
            System.out.println("You lose");
        else if (yourScore == houseScore) 
            System.out.println("You lose");
        else if (yourScore <= 21) {
            if(houseScore > 21 || (yourScore > houseScore))
                System.out.println("You win");
            else
                System.out.println("You lose");
        }
            
    }   
}