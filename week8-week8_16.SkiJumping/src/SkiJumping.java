
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import java.util.Random;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author slier
 */
public class SkiJumping {

	enum Sort {
		ASC,
		DESC
	}

	private Scanner scanner;
	private Map<String, Integer> points;
	private Map<String, ArrayList<Integer>> jumps;
	private int jumpRound;

	public SkiJumping() {
		this.scanner = new Scanner(System.in);
		this.points = new HashMap<String, Integer>();
		this.jumps = new HashMap<String, ArrayList<Integer>>();
		this.jumpRound = 0;
	}

	public void start() {
		this.playerMenu();
	}

	private void playerMenu() {
		System.out.println("Kumpula ski jumping week");
		System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");

		while (true) {
			System.out.print("  Participant name: ");
			String playerName = this.scanner.nextLine();

			if (playerName.isEmpty()) {
				System.out.println();
				break;
			}

			this.points.put(playerName, 0);
		}

		this.jumpMenu();
	}

	private void jumpMenu() {
		System.out.println("The tournament begins!");
		System.out.println();

		while (true) {
			System.out.print("Write \"jump\" to jump; otherwise you quit: ");
			String command = this.scanner.nextLine();

			if (command.equalsIgnoreCase("quit")) {
				break;
			}

			if (command.equalsIgnoreCase("jump")) {
				this.jumpRound++;
				System.out.println();
				this.playerJump();
			}
		}

		System.out.println();
		System.out.println("Thanks!");
		System.out.println();

		System.out.println("Tournament results:");
		this.generateTournamentResults();
	}

	private void playerJump() {
		System.out.println("Round " + this.jumpRound);
		System.out.println();
		this.playerJumpOrder();
	}

	private void playerJumpOrder() {
		System.out.println("Jumping order:");

		this.points = this.sortJumpingOrder(this.points, Sort.ASC);

		int counter = 0;
		for (String player : this.points.keySet()) {
			System.out.println("  " + (++counter) + ". " + player + " (" + this.points.get(player) + " points)");
		}

		System.out.println();
		System.out.println("Results of round " + this.jumpRound);

		this.generateScore();
	}

	private void generateScore() {

		HashMap<String, Integer> jumpScore = new HashMap<String, Integer>();
		HashMap<String, Integer[]> judgeScore = new HashMap<String, Integer[]>();

		for (String player : this.points.keySet()) {
			jumpScore.put(player, this.generateJumpScore());
			judgeScore.put(player, this.generateJudgeScore());
		}

		for (String player : jumpScore.keySet()) {
			System.out.println("  " + player);
			System.out.println("    length: " + jumpScore.get(player));
			System.out.println("    judge votes: " + Arrays.toString(judgeScore.get(player)));
		}

		this.savePlayerScore(jumpScore, judgeScore);

		System.out.println();

	}

	private int generateJumpScore() {
		return this.getRandomInBetween(60, 120);
	}

	private Integer[] generateJudgeScore() {
		int judgeAmount = 5;
		int[] judgeScore = new int[judgeAmount];

		for (int i = 0; i < judgeAmount; i++) {
			judgeScore[i] = this.getRandomInBetween(10, 20);
		}

		return this.toConvertInteger(judgeScore);
	}

	private int getRandomInBetween(int min, int max) {
		Random r = new Random();
		int result = r.nextInt(max - min) + min;
		return result;
	}

	private Integer[] toConvertInteger(int[] ids) {
		Integer[] newArray = new Integer[ids.length];

		for (int i = 0; i < ids.length; i++) {
			newArray[i] = Integer.valueOf(ids[i]);
		}

		return newArray;
	}

	private void savePlayerScore(HashMap<String, Integer> jumpScore, HashMap<String, Integer[]> judgeScore) {

		for (String player : jumpScore.keySet()) {
			int playerJumpScore = jumpScore.get(player);
			int totalJudgeScore = this.calculateJudgeScore(judgeScore, player);

			if (!this.points.containsKey(player)) {
				this.points.put(player, playerJumpScore + totalJudgeScore);

			} else {
				this.points.put(player, this.points.get(player) + (playerJumpScore + totalJudgeScore));
			}

			if (!this.jumps.containsKey(player)) {
				ArrayList<Integer> playerJumps = new ArrayList<Integer>();
				playerJumps.add(playerJumpScore);
				this.jumps.put(player, playerJumps);
			} else {
				this.jumps.get(player).add(playerJumpScore);
			}

		}
	}

	private int calculateJudgeScore(HashMap<String, Integer[]> judgeScore, String player) {
		ArrayList<Integer> playerJudgeScore = new ArrayList<Integer>(Arrays.asList(judgeScore.get(player)));
		playerJudgeScore.remove(playerJudgeScore.indexOf(Collections.min(playerJudgeScore)));
		playerJudgeScore.remove(playerJudgeScore.indexOf(Collections.max(playerJudgeScore)));

		int totalJudgeScore = 0;

		for (int score : playerJudgeScore) {
			totalJudgeScore += score;
		}

		return totalJudgeScore;
	}

	private void generateTournamentResults() {
		System.out.println("Position    Name");

		this.points = this.sortJumpingOrder(this.points, Sort.DESC);

		int counter = 0;
		for (String player : this.points.keySet()) {
			System.out.println((++counter) + "           " + player + " (" + this.points.get(player) + " points)");
			System.out.print("            jump lengths: ");

			String delim = "";
			for (int jump : this.jumps.get(player)) {
				System.out.print(delim + jump);
				delim = " m, ";
			}

			System.out.println(" m");
		}
	}

	private Map<String, Integer> sortJumpingOrder(Map<String, Integer> unsortMap, final Sort direction) {
		//1. Convert Map to List of Map
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

		//2. Sort list with Collections.sort(), provide a custom Comparator
		//Try switch the o1 o2 position for a different order
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {

				if (direction == Sort.ASC) {
					return (o1.getValue()).compareTo(o2.getValue());
				} else {
					return (o2.getValue()).compareTo(o1.getValue());
				}
			}
		});

		//3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}

}
