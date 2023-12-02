import java.io.*;
import java.util.*;

public class Trebuchet2 {
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("in.txt"));
			System.setOut(new PrintStream(new FileOutputStream("out.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);

		// pre-computed data
		List<String> wordList = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
		int result = 0;

		while (sc.hasNext()) {
			String line = sc.next();
			int leftInteger = findLeftInteger(line, wordList);
			int rightInteger = findRightInteger(line, wordList);
			result += leftInteger*10+rightInteger;
		}
		System.out.println(result);
	}

	private static int findLeftInteger(String line, List<String> wordList) {
		int leftInteger = 0;
		String leftString = "";
		for (int i=0; i<line.length(); i++) {
			Character character = line.charAt(i);
			if (Character.isDigit(character)) {
				leftInteger = character - '0';
				return leftInteger;
			} else {
				leftString += String.valueOf(character);
				for (String word : wordList) {
					if (leftString.contains(word)) {
						return wordList.indexOf(word)+1;
					}
				}
			}
		}
		return leftInteger;
	}

	private static int findRightInteger(String line, List<String> wordList) {
		int rightInteger = 0;
		String rightString = "";
		for (int i=line.length()-1; i>=0; i--) {
			Character character = line.charAt(i);
			if (Character.isDigit(character)) {
				rightInteger = character - '0';
				return rightInteger;
			} else {
				rightString = String.valueOf(character) + rightString;
				for (String word : wordList) {
					if (rightString.contains(word)) {
						return wordList.indexOf(word)+1;
					}
				}
			}
		}
		return rightInteger;
	}
}