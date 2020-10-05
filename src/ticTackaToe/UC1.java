package ticTackaToe;

import java.util.*;

public class UC1 
{
	char board[];
void board()
{
	board = new char[10];
	Arrays.fill(board, ' ');
}

public static void main(String[] args) 
{
	UC1 obj = new UC1();
	obj.board();

   }
}
	
