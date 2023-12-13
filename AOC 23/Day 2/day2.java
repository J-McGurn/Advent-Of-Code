import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class day2 {
    final static ArrayList<int[]> data = new ArrayList<>();
    final static int RED_I = 0, GREEN_I = 1, BLUE_I = 2;
    final static int RED_MAX = 12, GREEN_MAX = 13, BLUE_MAX = 14;

    public static void main(String args[]) throws Exception {

        Scanner scanner = new Scanner(new File("input.txt"));

        while (scanner.hasNextLine()) {
            int[] rgbValues = new int[3];

            String line = scanner.nextLine();
            String[] split = line.split(" ");

            for (int i = 3; i < split.length; i += 2) {
                if (split[i].startsWith("red")) {
                    rgbValues[RED_I] = Math.max(Integer.parseInt(split[i - 1]), rgbValues[RED_I]);
                } else if (split[i].startsWith("green")) {
                    rgbValues[GREEN_I] = Math.max(Integer.parseInt(split[i - 1]), rgbValues[GREEN_I]);
                } else if (split[i].startsWith("blue")) {
                    rgbValues[BLUE_I] = Math.max(Integer.parseInt(split[i - 1]), rgbValues[BLUE_I]);
                } else {
                    throw new Exception("Invalid color: " + split[i]);
                }
            }
            data.add(rgbValues);
        }
        scanner.close();

        part1();
        part2();
    }

    public static void part1() {
        int dataSize = data.size();
        int sum = 0;

        for (int i = 0; i < dataSize; i++) {
            if (data.get(i)[RED_I] <= RED_MAX && data.get(i)[GREEN_I] <= GREEN_MAX && data.get(i)[BLUE_I] <= BLUE_MAX) {
                sum += (i + 1);
            }
        }
        System.out.println("Part 1 Solution: " + sum);
    }

    public static void part2() {
        int sum = 0;

        // for each game, add the product of the max values for each color
        for (int[] rgbValues : data) {
            sum += (rgbValues[RED_I] * rgbValues[GREEN_I] * rgbValues[BLUE_I]);
        }
        System.out.println("Part 2 Solution: " + sum);
    }
}