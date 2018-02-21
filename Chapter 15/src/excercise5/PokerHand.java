package excercise5;

public class PokerHand extends Deck{
	
	public Card[] cards;
	
	public static void main (String[] args) {
		Deck d = new Deck();
		PokerHand ph1 = d.deal();
		pln("Poker Hand 1 has: ");
		ph1.print();
		PokerHand ph2 = d.deal();
		pln("\nPoker Hand 2 has: ");
		ph2.print();
		PokerHand ph3 = d.deal();
		pln("\nPoker Hand 3 has: ");
		ph3.print();
		PokerHand ph4 = d.deal();
		pln("\nPoker Hand 4 has: ");
		ph4.print();
		PokerHand ph5 = d.deal();
		pln("\nPoker Hand 5 has: ");
		ph5.print();
		pln("\nDoes Poker Hand 1 have a flush? " + ph1.hasFlush());
		pln("Does Poker Hand 2 have a flush? " + ph2.hasFlush());
		pln("Does Poker Hand 3 have a flush? " + ph3.hasFlush());
		pln("Does Poker Hand 4 have a flush? " + ph4.hasFlush());
		pln("Does Poker Hand 5 have a flush? " + ph5.hasFlush());
		pln("\nDoes Poker Hand 1 have a Three Of A Kind? " + ph1.hasThreeOfAKind());
		pln("Does Poker Hand 2 have a Three Of A Kind? " + ph2.hasThreeOfAKind());
		pln("Does Poker Hand 3 have a Three Of A Kind? " + ph3.hasThreeOfAKind());
		pln("Does Poker Hand 4 have a Three Of A Kind? " + ph4.hasThreeOfAKind());
		pln("Does Poker Hand 5 have a Three Of A Kind? " + ph5.hasThreeOfAKind());
		generate();
	}
	
	public PokerHand() {
		this.cards = new Card[5];
	}
	
	public void print() {
		for (Card card : cards) {
			card.print();
		} 
	}
	
	public void addCards(Card c1, Card c2, Card c3, Card c4, Card c5) {
		cards[0] = c1;
		cards[1] = c2;
		cards[2] = c3;
		cards[3] = c4;
		cards[4] = c5;
	}
	
	public boolean hasFlush() {
		int suit = cards[0].suit;
		boolean result = true;
		for (Card card : cards) {
			if (card.suit != suit) {
				result = false;
				break;
			}
		}
		return result;
	}
	
	public boolean hasThreeOfAKind() {
		int matches = 0;
		boolean result = false;
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 5; j++) {
				if (cards[i].rank == cards[j].rank) {
					matches++;
				}
				if (matches >= 3) {
					result = true;
					break;
				}
			}
		}
		return result;
	}
	
	public static void generate() {
		Deck d = new Deck();
		int flushes = 0;
		int TOKs = 0;
		int num = 10000;
		PokerHand[] hands = new PokerHand[num];
		for (int i = 0; i < num; i++) {
			hands[i] = d.deal();
			if (hands[i].hasFlush()) {
				flushes++;
			} if (hands[i].hasThreeOfAKind()) {
				TOKs++;
			}
		}
		pln("\nOut of " + num + " randomly chosen poker hands:");
		pln(flushes + " were a flush, a percent probability of " + (double)flushes/num * 100);
		pln(TOKs + " were a three of a kind, a percent probability of " + (double)TOKs/num * 100);
	}


//	8. Write methods that test for the other poker hands. Some are easier
//	than others. You might find it useful to write some general-purpose
//	helper methods that can be used for more than one test.
//	9. In some poker games, players get seven cards each, and they form a
//	hand with the best five of the seven. Modify your program to generate
//	seven-card hands and recompute the probabilities.

	
	public static void p (String args) {
		System.out.print(args);
	}

	public static void pln (String args) {
		System.out.println(args);
	}
}
