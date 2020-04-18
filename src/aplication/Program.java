package aplication;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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
		List<ChessPiece> captured = new ArrayList();

		while (!chessMatch.checkMate()) {
			try {
				UserInterface.clearScreen();

				UserInterface.printMatch(chessMatch, captured);
				System.out.println();

				// Posição de Origem
				System.out.print(UserInterface.ANSI_RED);
				System.out.print("Source - Peca a ser Movida: ");
				System.out.print(UserInterface.ANSI_RESET);

				ChessPosition source = UserInterface.readchessPosition(input);
				System.out.println();

				boolean[][] possibleMoves = chessMatch.possibleMovesMarkup(source);
				UserInterface.clearScreen();
				UserInterface.printBoard(chessMatch.getPieces(), possibleMoves);

				System.out.print(UserInterface.ANSI_WHITE);
				System.out.print("Target - Destino da Peca: ");
				System.out.print(UserInterface.ANSI_RESET);

				ChessPosition target = UserInterface.readchessPosition(input);

				ChessPiece capturedPiece = chessMatch.performeChessMove(source, target);
				if (capturedPiece != null)
					captured.add(capturedPiece);

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
		UserInterface.clearScreen();
		UserInterface.printMatch(chessMatch, captured);
		
	}
}
