import java.util.*;
import java.io.*;

public class day1 {
    public static void main(String args[]) throws FileNotFoundException {
        part1();
        part2();
    }

    public static void part1() throws FileNotFoundException {

        int sum = 0;

        Scanner scanner = new Scanner(new File("Day 1/input.txt"));
        for (int i = 0; i < 1000; i++) {
            ArrayList<String> numbers = new ArrayList<>();
            if (scanner.hasNext()) {
                String input = scanner.next();
                for (String str : input.split("")) {
                    if (str.equals("1") || str.equals("2") || str.equals("3") || str.equals("4") || str.equals("5")
                            || str.equals("6") || str.equals("7") || str.equals("8") || str.equals("9")
                            || str.equals("0")) {
                        numbers.add(str);
                    }
                }
                String num = numbers.get(0);
                num += numbers.get(numbers.size() - 1);
                int number = Integer.parseInt(num);
                sum += number;
            }
        }
        System.out.println("Part 1: " + sum);
    }

    public static void part2() throws FileNotFoundException {
        Map<String, Integer> digits = Map.of("one", 1, "two", 2, "three", 3, "four", 4, "five", 5, "six", 6, "seven", 7,
                "eight", 8,
                "nine", 9);
        int sum = 0;

        Scanner scanner = new Scanner(new File("Day 1/input.txt"));
        for (int i = 0; i < 1000; i++) {
            if (scanner.hasNext()) {
                String input = scanner.next();

                int firstDigit = 0;
                int lastDigit = 0;
                char[] characters = input.toCharArray();
                int firstOccurance = input.length();
                int lastOccurance = -1;

                for (Map.Entry<String, Integer> d : digits.entrySet()) {
                    int index = input.indexOf(d.getKey());
                    if (index != -1 && index < firstOccurance) {
                        firstOccurance = index;
                        firstDigit = d.getValue();
                    }

                    for (int j = 0; j < characters.length; j++) {
                        if (Character.isDigit(characters[j]) && j < firstOccurance) {
                            firstDigit = Character.getNumericValue(characters[j]);
                            break;
                        }
                    }
                }

                for (Map.Entry<String, Integer> d : digits.entrySet()) {
                    int index = input.lastIndexOf(d.getKey());
                    if (index != -1 && index > lastOccurance) {
                        lastOccurance = index;
                        lastDigit = d.getValue();
                    }

                    for (int j = characters.length - 1; j >= 0; j--) {
                        if (Character.isDigit(characters[j]) && j > lastOccurance) {
                            lastDigit = Character.getNumericValue(characters[j]);
                            break;
                        }
                    }
                }

                sum += (firstDigit * 10 + lastDigit);
            }
        }
        System.out.println("Part 2: " + sum);
    }
}
