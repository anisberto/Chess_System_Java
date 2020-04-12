package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {
	private Color color;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	protected boolean isTheOpponentPiece(Position position) {
		ChessPiece pieceThereIs = (ChessPiece) getBoard().piece(position);
		return pieceThereIs != null && pieceThereIs.getColor() != color;
	}

}
