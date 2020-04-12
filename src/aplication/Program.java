package aplication;

import java.util.InputMismatchException;
import java.util.Scanner;

import UI.UserInterface;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import exceptions.BoardException;
import exceptions.ChessException;

public class Program {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();

		while (true) {
			try {
				UserInterface.clearScreen();
				UserInterface.printMatch(chessMatch);
				System.out.println();

				// Posição de Origem
				System.out.print("Source - Peca a ser Movida: ");
				ChessPosition source = UserInterface.readchessPosition(input);
				System.out.println();

				boolean[][] possibleMoves = chessMatch.possibleMovesMarkup(source);
				UserInterface.clearScreen();
				UserInterface.printBoard(chessMatch.getPieces(), possibleMoves);

				System.out.print("Target - Destino da Peca: ");
				ChessPosition target = UserInterface.readchessPosition(input);

				ChessPiece capturedPiece = chessMatch.performeChessMove(source, target);
			} catch (ChessException erroChess) {
				System.out.println(erroChess.getMessage());
				input.nextLine();
			} catch (InputMismatchException erroInput) {
				System.out.println(erroInput.getMessage());
				input.nextLine();
			} catch (BoardException erroBoard) {
				System.out.println(erroBoard.getMessage());
				input.nextLine();
			}
		}
	}
}
