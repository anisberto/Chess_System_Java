package aplication;

import java.util.Scanner;

import UI.UserInterface;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();

		while (true) {
			UserInterface.printBoard(chessMatch.getPieces());
			System.out.println();

			// Posi��o de Origem
			System.out.print("Source: ");
			ChessPosition source = UserInterface.readchessPosition(input);
			System.out.println();

			System.out.print("Target: ");
			ChessPosition target = UserInterface.readchessPosition(input);

			ChessPiece capturedPiece = chessMatch.performeChessMove(source, target);
		}
	}
}
