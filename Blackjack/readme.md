This project is recreating the BlackJack casino game. 

It will have two classes - BlackJack and Card

-> The Card class will contain information that is represents its state i.e. suit and number

-> The CardPile class will intiantiate one object that represents 'deck of cards' while also having functions such as adding a card object to the deck or removing a random card.

-> The BlackJack class will handle the logic of the game as seen below in the how to play section

-> The SimpleUI class will implement UserInterface in order to better the output of the code to the console.



How to Play:

Blackjack is the most popular casino gambling game in the world. (Note: the rules of the game favour
the casino. The Casino is guaranteed to win in the long run.) Here's how it works:

1. Both you and the House (the Casino) are dealt two cards: one is face up and the other face
down. So you can see only one of the House's cards and it can see only one of yours. But both
you and the House can discretely peek at your face down cards.

2. Each card has a score as follows:
 -> An Ace has a score of 1. (This differs from real Blackjack where the Ace can have a
score of either 1 or 11 at the player's discretion. The simplified version for this lab is
easier to program.)

 -> A Jack, Queen or King has a score of 10.

 -> All other cards have a score equal to their rank. (For example, the 4 of Hearts or the 4
of any suit have a rank of 4 and a score of 4.)

3. The House will obtain additional cards until its score is 17 or more.

4. You are asked if you want another card. If you answer yes, you get another face down card and
you will asked again. This continues until you say "no". This ends the game.

5. All cards are now turned face-up and the scores of you and the House are calculated.

 -> You lose if your score is more than 21 (no matter what the House's score is).

 -> You lose if your score is the same as the House's.

You win if:

 -> You don't go over 21 and the House does go over 21