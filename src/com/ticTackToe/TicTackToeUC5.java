package com.ticTackToe;

import java.util.*;

public class TicTackToeUC5 {
	private char board[];
	private char player1;
	private char comp1;
	private final Scanner sc = new Scanner(System.in);

	//creating board
	private char[] createBoard() {
		board = new char[10];
		Arrays.fill(board, ' ');
		return board;
	}

	// Assigning symbol to players
	private void playerLetter() {

		System.out.println("Enter X or O as per your choice");
		player1 = sc.next().charAt(0);
		if (player1 == 'x')
			comp1 = 'o';
		else
			comp1 = 'x';
	}

	//choose position
	private void showBoard() {
		int temp = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				++temp;
				System.out.print("_" + board[temp] + "_ | ");
			}
			System.out.println();
		}

	}

	// To take input of player's move
	private void userInputPosition() {

		System.out.println("Enter the position number where you want to play the move");
		int user_pos = sc.nextInt();
		if (board[user_pos] == ' ') {
			board[user_pos] = player1;
			showBoard();
		} else {
			System.out.println("The positon is already occupied!! Please try again");
			userInputPosition();
		}
	}

	public static void main(String[] args) {

		TicTackToeUC5 ticTackToe = new TicTackToeUC5();
		char board[] = ticTackToe.createBoard();
		ticTackToe.playerLetter();
		ticTackToe.showBoard();
		ticTackToe.userInputPosition();
	}
}
