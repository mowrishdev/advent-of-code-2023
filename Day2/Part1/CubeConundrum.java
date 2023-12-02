import java.io.*;
import java.util.*;

public class CubeConundrum {
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("in.txt"));
			System.setOut(new PrintStream(new FileOutputStream("out.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);

		Map<String, Integer> maximumCubesMap = new HashMap<>();
		maximumCubesMap.put("red", 12);
		maximumCubesMap.put("green", 13);
		maximumCubesMap.put("blue", 14);
		int result = 0;
		while (sc.hasNext()) {
			String line = sc.nextLine();
			String[] lineSplit = line.split(":");
			int gameId = Integer.parseInt(lineSplit[0].trim().split(" ")[1]);
			String[] cubeSetArray = lineSplit[1].trim().split(";");
			if (isValidGame(cubeSetArray, maximumCubesMap)) {
				result += gameId;
			}
		}
		System.out.println(result);
	}

	private static boolean isValidGame(String[] cubeSetArray, Map<String, Integer> maximumCubesMap) {
		for (String cubeSet: cubeSetArray) {
			String[] cubes = cubeSet.trim().split(",");
			for (String cube : cubes) {
				String[] cubeSplit = cube.trim().split(" ");
				int cubeNumber = Integer.parseInt(cubeSplit[0].trim());
				String cubeColour = cubeSplit[1].trim();
				if (cubeNumber > maximumCubesMap.get(cubeColour)) {
					return false;
				}
			}
		}
		return true;
	}
}