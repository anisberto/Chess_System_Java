package UI;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class UserInterface {

	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
	// Text Colors
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	// back-ground colors
	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	public static ChessPosition readchessPosition(Scanner input) {
		try {
			String read = input.nextLine();
			char column = read.charAt(0);
			int row = Integer.parseInt(read.substring(1));

			return new ChessPosition(column, row);
		} catch (RuntimeException error) {
			throw new InputMismatchException("Erro lendo posi��o! As posi��es validas s�o de (a8 - h8)");
		}
	}

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static void printMatch(ChessMatch chessMatch, List<ChessPiece> captured) {
		System.out.println();
		printBoard(chessMatch.getPieces());
		System.out.println();
		printCapturedPieces(captured);
		System.out.println();

		if (!chessMatch.checkMate()) {

			System.out.println("Turn: " + chessMatch.getTurn());
			if (chessMatch.getCheck()) {
				System.out.println(ANSI_RED + "Check! " + ANSI_RESET);
			}

			if (chessMatch.getCurrentPlayer() == Color.BLACK)
				System.out.println("Aguardando jogador: " + ANSI_BLACK + chessMatch.getCurrentPlayer() + ANSI_RESET);
			if (chessMatch.getCurrentPlayer() == Color.WHITE)
				System.out.println("Aguardando jogador: " + ANSI_WHITE + chessMatch.getCurrentPlayer() + ANSI_RESET);

		} else {
			System.out.println("CHECKMATE!");
			System.out.println("O VENCEDOR E O JOGADOR: " + ANSI_PURPLE_BACKGROUND + chessMatch.getCurrentPlayer() + ANSI_RESET);
		}
	}

	public static void printBoard(ChessPiece[][] pieces) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print("|" + (8 - i) + "| ");
			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j], false);
			}
			System.out.println();
		}
		System.out.println("    A B C D E F G H ");
	}

	public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print("|" + (8 - i) + "| ");
			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j], possibleMoves[i][j]);
			}
			System.out.println();
		}
		System.out.println("    A B C D E F G H ");
	}

	// Metodo para imprimir uma unica pe�a do tabuleiro
	private static void printPiece(ChessPiece piece, boolean background) {
		if (background)
			System.out.print(ANSI_RED_BACKGROUND);

		if (piece == null) {
			System.out.print("*" + ANSI_RESET);
		} else {
			if (piece.getColor() == Color.WHITE) {
				System.out.print(ANSI_WHITE + piece + ANSI_RESET);
			} else {
				System.out.print(ANSI_BLACK + piece + ANSI_RESET);
			}
		}
		System.out.print(" ");
	}

	private static void printCapturedPieces(List<ChessPiece> capturedPieces) {
		List<ChessPiece> piecesWhiteCaptured = capturedPieces.stream().filter(x -> x.getColor() == Color.WHITE)
				.collect(Collectors.toList());

		List<ChessPiece> piecesBlackCaptured = capturedPieces.stream().filter(x -> x.getColor() == Color.BLACK)
				.collect(Collectors.toList());

		System.out.println("Pecas Capturadas: ");
		System.out.print("White: ");
		System.out.print(ANSI_WHITE);
		System.out.print(Arrays.toString(piecesWhiteCaptured.toArray()));
		System.out.print(ANSI_RESET);
		System.out.println();
		System.out.print("Black: ");
		System.out.print(ANSI_BLACK);
		System.out.print(Arrays.toString(piecesBlackCaptured.toArray()));
		System.out.print(ANSI_RESET);
		System.out.println();

	}
}
