package CardDeck;

public class Card {
private Suit suit;
private Rank rank;
public Card() {
	
}
public Card(Suit s,Rank r){
	this.suit=s;
	this.rank=r;
}
@Override
public String toString() {
	return "Card [suit=" + suit + ", rank=" + rank + "]";
}
}
