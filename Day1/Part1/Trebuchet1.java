import java.io.*;
import java.util.*;

public class Trebuchet1 {
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("in.txt"));
			System.setOut(new PrintStream(new FileOutputStream("out.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);
		long result = 0l;
		while(sc.hasNext()) {
			String line = sc.next();
			int endIndexForRight = 0;
			int leftInteger = 0;
			int rightInteger = 0;
			for (int i=0; i<line.length(); i++) {
				if (Character.isDigit(line.charAt(i))) {
					leftInteger = line.charAt(i) - '0';
					endIndexForRight = i;
					break;
				}
			}
			for (int i=line.length()-1; i>=endIndexForRight; i--) {
				if (Character.isDigit(line.charAt(i))) {
					rightInteger = line.charAt(i) - '0';
					break;
				}
			}
			int twoDigitInteger = leftInteger * 10 + rightInteger;
			result += (long) twoDigitInteger;
		}
		System.out.println(result);
	}
}