/*
* Name:  	Lam, Simon
* Project: 	2
* Due:		November 2, 2012    
* Course: 	CS-141-01-f12
*
* Description:
* This project is the basic design and code of the game Tic-Tac-Toe.
* This game lets you choose whether to watch two computers play against each other
* or have two humans play against each other or have a human vs computer.
*/

import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;

public class TicTacToe {
	
	private int[][] map;
	private String[] player = new String [2];
	private Random rand = new Random();
	
	public TicTacToe () {
		this(3, 9);
	}
	
	public TicTacToe (int size, int seed) {
		map = new int [size][size];
		rand.setSeed(seed);
	}
	
	public void createMap () {
		int x = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				x++;
				map[i][j] = x;
			}
		}
	}
	
	public void displayMap () {
		DecimalFormat dc = new DecimalFormat("#00");
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 6666) // Player 1
					System.out.print("X  ");
				else if (map[i][j] == 9999) // Player 2
					System.out.print("O  ");
				else
				System.out.print(dc.format(map[i][j]) + " ");
			}
			System.out.println("");
		}
		System.out.println();
	}
	
	public void setPlayer() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter first username: ");
		player[0] = kb.next();
		System.out.println("Enter second username: ");
		player[1] = kb.next();
		System.out.println();
	}
	
	public boolean checkMap () {
		int counter = 0;
		boolean status = false;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				counter++;
				if (map[i][j] == counter)
					status = true;
			}
		}
		return status;
	}
	
	public String checkWin (int playerID) {
		int count = 0;
		String status = null;
		for (int j = 0; j < map.length; j++) { 				//check win horizontally
			for (int k = 0; k < map.length; k++) {
				if (map[j][k] == playerID) {
					count++;
					if (count == map.length) {
						return "Win";
					}
				} else {
					count = 0;
					break;
				}
			}
		}
		for (int j = 0; j < map.length; j++) {				//check win vertically
			for (int k = 0; k < map.length; k++)
			if (map[k][j] == playerID) {
				count++;
				if (count == map.length) {
					return "Win";
				}
			} else {
				count = 0;
				break;
			}
		}
		for (int j = 0; j < map.length; j++) {				//check win diagonally (\)
			if (map[j][j] == playerID) {
				count++;
				if (count == map.length)
					return "Win";
			} else {
				count = 0;
				break;
			}
		}
		int j = map.length - 1;
		for (int i = 0; i < map.length; i++) {				//check win reverse diagonally (/)
			if (map[i][j] == playerID) {
				count++;
				if (count == map.length)
					return "Win";
			} else {
				count = 0;
				break;
			}
			j--;
		}
		return status;
	}

	public void player1Turn () {
		if (player[0].toLowerCase().equals("computer"))
			computerMove(6666);
		else
			playerMove(6666);
		displayMap();
	}
	
	public void player2Turn () {
		if (player[1].toLowerCase().equals("computer"))	// computer
			computerMove(9999);
		else							// player
			playerMove(9999);
		displayMap();
	}
	
	public void computerMove (int computerID) {
		int move, counter = 0;
		outerloop:
		do {
			move = rand.nextInt((map.length * map.length)) + 1;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (move == map[i][j]) {
						map[i][j] = computerID;
						break outerloop;
					}
				}
			}
			counter++;
		} while (counter < (map.length * map.length));
		System.out.println("computer's move is: " + move);
	}
	
	public void playerMove (int playerID) {
		Scanner kb = new Scanner(System.in);
		int counter = 0;
		outerloop:
		while (counter < playerID) {
			if (playerID == 6666)
				System.out.print(player[0] + ", enter your move: ");
			else if (playerID == 9999)
				System.out.print(player[1] + ", enter your move: ");
			int temp = kb.nextInt();
			for (int i = 0; i < map.length; i++) {
				for (int j = 0 ; j < map[i].length; j++) {
					if (temp == map[i][j]) {
						map[i][j] = playerID;
						break outerloop;
					}
				}
			}
			counter++;
		}
	}
	
	public void startUp () {
		createMap();
		setPlayer();
		displayMap();
	}
	
	public static void main (String[] args) {
		System.out.println("\nWelcome to jTic-Tac-Toe version 0.1\nCopyright (C) Simon 2012. All rights reserved.\n");
		TicTacToe tic;
		String winner = null;
		if (args.length >= 1) {
			if (args.length == 2)
				tic = new TicTacToe(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
			else
				tic = new TicTacToe(Integer.parseInt(args[0]), 40);
		} else
			tic = new TicTacToe();
		tic.startUp();
		loopy:
		while (tic.checkMap() == true && winner != tic.player[0] && winner != tic.player[1]) {
			tic.player1Turn();
			tic.checkWin(6666);
			if (tic.checkWin(6666) == "Win") {
				winner = tic.player[0] + "(1)";
				break loopy;
			}
			tic.checkMap();
			if (tic.checkMap() == false)
				break loopy;
			tic.player2Turn();
			tic.checkWin(9999);
			if (tic.checkWin(9999) == "Win") {
				winner = tic.player[1] + "(2)";
				break loopy;
			}
			tic.checkMap();
			if (tic.checkMap() == false)
				break loopy;
		}
		if (winner != null)
			System.out.println(winner + ", you are the winner.");
		else 
			System.out.println("great game, it's a tie.");
	}
}