package TreeMapJava;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class LetterSequence {
	private String Sentence;
	private static int getValue;
	public TreeMap<Character, Integer> frequencyMap = new TreeMap<Character, Integer>();

	public String getSentence() {
		return Sentence;
	}

	public void setSentence(String sentence) {
		this.Sentence = sentence;
	}

	public LetterSequence(String sentence) {
		super();
		this.Sentence = sentence;
	}

	public TreeMap<Character, Integer> computeFrequency() {
		for (int i = 0; i < Sentence.length(); i++) {
			if (frequencyMap.containsKey(Sentence.charAt(i))) {
				getValue = frequencyMap.get(Sentence.charAt(i));
				getValue++;
				frequencyMap.put(Sentence.charAt(i), getValue);
			} else {
				frequencyMap.put(Sentence.charAt(i), 1);
			}
		}
		return frequencyMap;
	}

	public void displayLetterFrequency(TreeMap<Character, Integer> frequencyMap) {
		Set set = frequencyMap.entrySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Map.Entry me = (Map.Entry) it.next();
			System.out.print(me.getKey() + ": ");
			getValue = (int) me.getValue();
			for (int j = 0; j < getValue; j++) {
				System.out.print("*");
			}
			System.out.print("\r\n");
		}
	}
}
