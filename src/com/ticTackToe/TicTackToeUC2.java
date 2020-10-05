package com.ticTackToe;

import java.util.*;

public class TicTackToeUC2 
{
	private char board[];
	private char player1;
	private char comp;
	private char[] createBoard()
	{
		board = new char[10];
		Arrays.fill(board, ' ');
		return board;
	}
	
	private void playerLetter()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Type X or O to start the game");
		player1 = sc.next().charAt(0);
		if(player1=='x')
			comp = 'o';
		else
			comp = 'x';
		sc.close();
	}

	public static void main(String[] args) {
		
		TicTackToeUC2 b1 = new TicTackToeUC2();
		char board[] = b1.createBoard();
		b1.playerLetter();
	}
}
