package com.TicTackToe;

import java.util.*;

public class TicTackToeUC7 {
	private char board[];
	private char player1;
	private char comp1;
	private final Scanner S1 = new Scanner(System.in);

	// Function to create board
	private char[] createBoard() {
		board = new char[10];
		Arrays.fill(board, ' ');
		return board;
	}

	// Assigning letter to the player1 as per their choice
	private void player1Letter() {

		System.out.println("Enter X or O to start game");
		player1 = S1.next().charAt(0);
		if (player1 == 'x')
			comp1 = 'o';
		else
			comp1 = 'x';
	}

	// Showing the board for users to choose their position
	private void showBoard() {
		int temp = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				++temp;
				System.out.print("" + board[temp] + "_| ");
			}
			System.out.println();
		}

	}

	// To validate input of player1's move
	private boolean userInputMoveValidate(int inpMove) {

		if (inpMove > 0 && inpMove < 10 && board[inpMove] == ' ') {
			return true;
		} else {
			return false;
		}
	}

	// To make the move after the validation is done
	private void makeMove() {
		System.out.println("Enter the position ");
		int userMoveIndex = S1.nextInt();
		if (userInputMoveValidate(userMoveIndex)) {
			board[userMoveIndex] = player1;
			showBoard();
		} else {
			System.out.println("Invalid move entered");
		}
	}

	private void comp1Move() {
		int computerMoveIndex = (int) (Math.random() * 10 % 9) + 1;
		if (userInputMoveValidate(computerMoveIndex)) {
			board[computerMoveIndex] = comp1;
			System.out.println();
			showBoard();
		} else
			comp1Move();
	}

	// To randomly decide who plays first
	private int tossWinner() {
		int randomToss = (int) (Math.random() * 10 % 2);
		int heads = 0;
		int tails = 1;
		if (randomToss == heads)
			System.out.println("player1 plays first");
		else
			System.out.println("comp1 plays first");
		return randomToss;
	}

	// Conditions to check the winnings cases
	private boolean winningCases() {
		if ((board[1] == 'x' && board[2] == 'x' && board[3] == 'x')
				|| (board[1] == 'o' && board[2] == 'o' && board[3] == 'o'))
			return true;
		else if ((board[4] == 'x' && board[5] == 'x' && board[6] == 'x')
				|| (board[4] == 'o' && board[5] == 'o' && board[6] == 'o'))
			return true;
		else if ((board[7] == 'x' && board[8] == 'x' && board[9] == 'x')
				|| (board[7] == 'o' && board[8] == 'o' && board[9] == 'o'))
			return true;
		else if ((board[1] == 'x' && board[4] == 'x' && board[7] == 'x')
				|| (board[1] == 'o' && board[4] == 'o' && board[7] == 'o'))
			return true;
		else if ((board[2] == 'x' && board[5] == 'x' && board[8] == 'x')
				|| (board[2] == 'o' && board[5] == 'o' && board[8] == 'o'))
			return true;
		else if ((board[3] == 'x' && board[6] == 'x' && board[9] == 'x')
				|| (board[3] == 'o' && board[6] == 'o' && board[9] == 'o'))
			return true;
		else if ((board[1] == 'x' && board[5] == 'x' && board[9] == 'x')
				|| (board[1] == 'o' && board[5] == 'o' && board[9] == 'o'))
			return true;
		else if ((board[7] == 'x' && board[5] == 'x' && board[3] == 'x')
				|| (board[7] == 'o' && board[5] == 'o' && board[3] == 'o'))
			return true;
		else
			return false;
	}

	public static void main(String[] args) {

		TicTackToeUC7 ticTackToe = new TicTackToeUC7();
		char board[] = ticTackToe.createBoard();
		ticTackToe.player1Letter();
		ticTackToe.showBoard();
		int firstPlayer = ticTackToe.tossWinner();
		if (firstPlayer == 1) {
			int flag = -1;
			for (int i = 1; i <= 9; i++) {
				ticTackToe.makeMove();
				boolean playerWins = ticTackToe.winningCases();
				if (playerWins) {
					flag = 1;
					break;
				}
				ticTackToe.comp1Move();
				boolean computerWins = ticTackToe.winningCases();
				if (computerWins) {
					flag = 0;
					break;
				}

			}
			if (flag == 1)
				System.out.println("Player1 wins the game");
			else if (flag == 1)
				System.out.println("Comp1 wins the game");
			else
				System.out.println("Game draw");
		} else {
			int flag = -1;
			for (int i = 1; i <= 9; i++) {
				ticTackToe.comp1Move();
				boolean computerWins = ticTackToe.winningCases();
				if (computerWins) {
					flag = 0;
					break;
				}
				ticTackToe.makeMove();
				boolean playerWins = ticTackToe.winningCases();
				if (playerWins) {
					flag = 1;
					break;
				}

			}
			if (flag == 1)
				System.out.println("Player1 wins the game");
			else if (flag == 1)
				System.out.println("Comp1 wins the game");
			else
				System.out.println("Game draw");

		}
	}
}
