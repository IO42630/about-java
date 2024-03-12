package com.olexyn.about.java.io;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

 class Failed extends RuntimeException {

}

 class Success extends RuntimeException {

}

class Solution {



	private static int LEAP = 0;
	static List<Integer> GAME = new ArrayList<>();
	static List<String> MID_GAME_RESULTS = new ArrayList<>();

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

		Scanner scan = new Scanner(System.in);
		int queries = Integer.parseInt(scan.nextLine());

		for (int i = 0; i < queries; i++) {

			int leap = Integer.parseInt(scan.nextLine().split(" ")[1]);

			List<Integer> array = Arrays.stream(scan.nextLine().split(" "))
					.map(Integer::parseInt)
					.collect(Collectors.toList());

			System.out.println(play(array, leap));
		}

	}

	public static String play(List<Integer> game, Integer leap) {
		GAME = game;
		LEAP = leap;
		MID_GAME_RESULTS = new ArrayList<>();

		Set<Integer> result = new HashSet<>();
		result.add(0);

		try {
			int count = 0;
			do {
				result = explore(result);
				count++;
			} while (!result.isEmpty() && count < game.size());
			return "NO";

		} catch (Success e) {
			return "YES";
		}
		catch (Failed e) {
			return "NO";
		}
	}

	private static Set<Integer> explore(Set<Integer> oldResult) {
		Set<Integer> result = new HashSet<>();

		for (Integer position : oldResult) {
			// handle step back
			if (position != 0 && GAME.get(position - 1) == 0) {
				result.add(position - 1);
			}
			// handle step forward
			if (position == GAME.size() -1) {
				throw new Success();
			}
			if (GAME.get(position + 1) == 0) {
				result.add(position + 1);
			}

			// handle step forward
			if (position + LEAP >= GAME.size()) {
				throw new Success();
			}
			if (GAME.get(position + LEAP) == 0) {
				result.add(position + LEAP);
			}
		}
		String midGameResult = result.stream()
				.sorted()
				.map(String::valueOf)
				.collect(Collectors.joining(","));
		if (MID_GAME_RESULTS.contains(midGameResult)) {
			throw new Failed();
		} else {
			MID_GAME_RESULTS.add(midGameResult);
		}

		return result;

	}

}