package aplication;

import java.security.InvalidParameterException;
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

	public static void main(final String[] args) {
		final Scanner input = new Scanner(System.in);
		final ChessMatch chessMatch = new ChessMatch();
		final List<ChessPiece> captured = new ArrayList();

		while (!chessMatch.checkMate()) {
			try {
				UserInterface.clearScreen();

				UserInterface.printMatch(chessMatch, captured);
				System.out.println();

				// Posi��o de Origem
				System.out.print(UserInterface.ANSI_RED);
				System.out.print("Source - Peca a ser Movida: ");
				System.out.print(UserInterface.ANSI_RESET);

				final ChessPosition source = UserInterface.readchessPosition(input);
				System.out.println();

				final boolean[][] possibleMoves = chessMatch.possibleMovesMarkup(source);
				UserInterface.clearScreen();
				UserInterface.printBoard(chessMatch.getPieces(), possibleMoves);

				System.out.print(UserInterface.ANSI_WHITE);
				System.out.print("Target - Destino da Peca: ");
				System.out.print(UserInterface.ANSI_RESET);

				final ChessPosition target = UserInterface.readchessPosition(input);

				final ChessPiece capturedPiece = chessMatch.performeChessMove(source, target);
				if (capturedPiece != null)
					captured.add(capturedPiece);

				if (chessMatch.getPromoted() != null) {
					System.out.print("Enter piece for promotion ( B / N / R / Q ): ");
					String typePromotedPiece = input.nextLine().toUpperCase();

					while (!typePromotedPiece.equals("B") && !typePromotedPiece.equals("N")
							&& !typePromotedPiece.equals("Q") && !typePromotedPiece.equals("R")) {

						System.out.print("Invalid Value! Enter piece for promotion ( B / N / R / Q ): ");
						typePromotedPiece = input.nextLine().toUpperCase();
					}

					chessMatch.replacePromotedPiece(typePromotedPiece);
				}

			} catch (final ChessException erroChess) {
				System.out.println(erroChess.getMessage());
				input.nextLine();
			} catch (final InputMismatchException erroInput) {
				System.out.println(erroInput.getMessage());
				input.nextLine();
			} catch (final BoardException erroBoard) {
				System.out.println(erroBoard.getMessage());
				input.nextLine();
			}
		}
		UserInterface.clearScreen();
		UserInterface.printMatch(chessMatch, captured);

	}
}
