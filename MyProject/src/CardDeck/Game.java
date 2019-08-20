package CardDeck;

import java.util.*;

public class Game {
	Scanner scanner = new Scanner(System.in);
	Random random = new Random();
	int randno;
	int NoOfHands;
	int NoOfCards;
	int k = 49;
	int index = 0;
	String[] CardArray = new String[52];
	String[] CardtempArray = new String[52];
	String swap;

	public Game() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				CardArray[index] = Suit.values()[i].toString() + " " + Rank.values()[j].toString();
				index++;
			}
		}
		do {
			System.out.println("No of players");
			NoOfHands = scanner.nextInt();
			System.out.println("No of cards");
			NoOfCards = scanner.nextInt();

			for (int i = 0; i < NoOfHands * NoOfCards; i++) {
				randno = random.nextInt(k - 0 + 1) + 1;
				CardtempArray[i] = CardArray[randno];
				swap = CardArray[k + 2];
				CardArray[randno] = swap;
				k--;
			}
			index = 0;
			for (int i = 0; i < NoOfHands; i++) {
				System.out.println("Cards of Player-" + (i + 1));
				for (int j = 0; j < NoOfCards; j++) {
					System.out.println(CardtempArray[index]);
					index++;
				}
			}

		} while (true);
	}

	public static void main(String[] args) {
		Game game = new Game();

	}

}
