package com.ticTackToe;

import java.util.*;

public class TicTackToeUC6 {
	private char board[];
	private char player1;
	private char comp1;
	private final Scanner sc = new Scanner(System.in);

	//  create board
	private char[] createBoard() {
		board = new char[10];
		Arrays.fill(board, ' ');
		return board;
	}

	// choosing X or O
	private void player1Letter() {

		System.out.println("Enter X or O ");
		player1 = sc.next().charAt(0);
		if (player1 == 'x')
			comp1 = 'o';
		else
			comp1 = 'x';
	}

	// choose position
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

	// input of player1's
	private boolean userInputMoveValidate(int inpMove) {

		if (inpMove > 0 && inpMove < 10 && board[inpMove] == ' ') {
			return true;
		} else {
			return false;
		}
	}

	//To make the move 
	private void makeMove() {
		System.out.println("Enter the position number ");
		int userMoveIndex = sc.nextInt();
		if (userInputMoveValidate(userMoveIndex)) {
			board[userMoveIndex] = player1;
			showBoard();
		} else {
			System.out.println("Invalid move entered");
		}
	}

	// To randomly decide who plays first
	private void whoseTurn() {
		Random random = new Random();
		int randomToss = random.nextInt(2);
		int heads = 0;
		int tails = 1;
		if (randomToss == heads)
			System.out.println("player1 plays first");
		else
			System.out.println("comp1 plays first");
	}

	public static void main(String[] args) {

		TicTackToeUC6 ticTackToe = new TicTackToeUC6();
		char board[] = ticTackToe.createBoard();
		ticTackToe.player1Letter();
		ticTackToe.showBoard();
		ticTackToe.makeMove();
		ticTackToe.whoseTurn();

	}
}
