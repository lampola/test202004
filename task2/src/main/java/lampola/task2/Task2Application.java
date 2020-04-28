package lampola.task2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Task2Application {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Give a space separated list of integers: ");
		String str = sc.nextLine();
		String[] integerStrings = str.split(" ");

		int[] integers = Arrays.stream(integerStrings).mapToInt(i -> Integer.parseInt(i)).toArray();

		System.out.println("The smallest gap between the integers is: " + task2(integers));
	}

	public static long task2(int[] integers) {
		long result = Long.MAX_VALUE;
		SortedSet<Integer> sortedIntegers = new TreeSet<>();

		if (integers.length <= 1) {
			result = 0;
		} else {
			
			for (int i : integers) {
				sortedIntegers.add(i);
			}

			Integer[] sortedIntegerValues = sortedIntegers.toArray(new Integer[sortedIntegers.size()]);

			for (int i = 1; i < sortedIntegerValues.length; i++) {
				long difference = Long.MAX_VALUE;
				long currentInt = sortedIntegerValues[i];
				long previousInt = sortedIntegerValues[i - 1];

				if (currentInt > previousInt + 1L) {
					difference = currentInt - previousInt - 1L;
				} else {
					difference = 0;
				}

				if (difference < result) {
					result = difference;
				}
			}
		}
		
		return result;
	}
}
