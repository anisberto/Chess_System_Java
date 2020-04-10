package aplication;

import chess.ChessMatch;
import gui.UserInterface;

public class Program {

	public static void main(String[] args) {
		ChessMatch chessMatch = new ChessMatch();
		
		UserInterface.printBoard(chessMatch.getPieces());
		
	}
}
