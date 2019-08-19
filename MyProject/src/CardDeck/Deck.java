package CardDeck;

import java.util.ArrayList;
import java.util.Collection;

public class Deck {
private static Collection<Card> protodeck = new ArrayList<Card>();
static {
	for(Suit suitfor:Suit.values()) {
		for(Rank rankfor:Rank.values()) {
			protodeck.add(new Card(suitfor,rankfor));
		}
	}
	System.out.println(protodeck);
}
//public static void main(String[] args) {
//	
//}

}
