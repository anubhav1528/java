package TreeMapJava;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class LetterSequenceMain {
	private static String sentence;
	public static TreeMap<Character, Integer> frequencyMap = new TreeMap<Character, Integer>();
	private static LetterSequence letterSequenceObj;
	static Scanner scanner = new Scanner(System.in);
	private static int getValue;

	public static void main(String[] args) {
		sentence = scanner.nextLine();
		String Sentence = sentence.replaceAll("\\s", "");
		letterSequenceObj = new LetterSequence(Sentence);
		frequencyMap = letterSequenceObj.computeFrequency();
		letterSequenceObj.displayLetterFrequency(frequencyMap);
	}
}
