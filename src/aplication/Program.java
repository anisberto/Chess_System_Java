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

			// Posição de Origem
			System.out.print("Source Peça a ser Movida: ");
			ChessPosition source = UserInterface.readchessPosition(input);
			System.out.println();

			System.out.print("Target Destino da Peça: ");
			ChessPosition target = UserInterface.readchessPosition(input);

			ChessPiece capturedPiece = chessMatch.performeChessMove(source, target);
		}
	}
}
