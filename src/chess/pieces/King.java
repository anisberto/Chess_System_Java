package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	public King(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "K";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] possibleMatMove = new boolean[getBoard().getRows()][getBoard().getColumns()];
		for (int i = 0; i < possibleMatMove.length; i++) {
			for (int j = 0; j < possibleMatMove[i].length; j++) {

			}
		}
		return possibleMatMove;
	}

}
