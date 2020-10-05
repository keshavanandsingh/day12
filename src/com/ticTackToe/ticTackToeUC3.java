package com.ticTackToe;

import java.util.*;

public class ticTackToeUC3 {
	private char board[];
	private char player1;
	private char comp1;

	private char[] createBoard() {
		board = new char[10];
		Arrays.fill(board, ' ');
		return board;
	}

	private void playerLetter() {
		Scanner S1 = new Scanner(System.in);
		System.out.println("type X or O as per your wish");
		player1 = S1.next().charAt(0);
		if (player1 == 'x')
			comp1 = 'o';
		else
			comp1 = 'x';
		S1.close();
	}
	
	private void showBoard()
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print("  | ");
			}
			System.out.println();
		}
	
	}

	public static void main(String[] args) {

		ticTackToeUC3 gameboard = new ticTackToeUC3();
		char board[] = gameboard.createBoard();
		gameboard.playerLetter();
		gameboard.showBoard();
	}
}
