package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
	private ChessMatch chessMatch;

	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	private boolean canMove(Position position) {
		ChessPiece pieceThisPosition = (ChessPiece) getBoard().piece(position);
		return pieceThisPosition == null || pieceThisPosition.getColor() != getColor();
	}

	private boolean possibleRookCastling(Position position) {
		ChessPiece possiblePiece = (ChessPiece) getBoard().piece(position);
		return possiblePiece != null && possiblePiece instanceof Rook && possiblePiece.getColor() == getColor()
				&& possiblePiece.getMoveCount() == 0;
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] possibleMatMove = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position positionAux = new Position(0, 0);

		// Posição superior
		positionAux.setValuePositions(position.getRow() - 1, position.getColumn());
		if (getBoard().positionExists(positionAux) && canMove(positionAux))
			possibleMatMove[positionAux.getRow()][positionAux.getColumn()] = true;

		// Posição Inferior
		positionAux.setValuePositions(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExists(positionAux) && canMove(positionAux))
			possibleMatMove[positionAux.getRow()][positionAux.getColumn()] = true;

		// Posição esquerdo
		positionAux.setValuePositions(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExists(positionAux) && canMove(positionAux))
			possibleMatMove[positionAux.getRow()][positionAux.getColumn()] = true;

		// Posição direito
		positionAux.setValuePositions(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExists(positionAux) && canMove(positionAux))
			possibleMatMove[positionAux.getRow()][positionAux.getColumn()] = true;

		// Posição NW
		positionAux.setValuePositions(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExists(positionAux) && canMove(positionAux))
			possibleMatMove[positionAux.getRow()][positionAux.getColumn()] = true;

		// Posição NE
		positionAux.setValuePositions(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExists(positionAux) && canMove(positionAux))
			possibleMatMove[positionAux.getRow()][positionAux.getColumn()] = true;

		// Posição SW
		positionAux.setValuePositions(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExists(positionAux) && canMove(positionAux))
			possibleMatMove[positionAux.getRow()][positionAux.getColumn()] = true;

		// Posição SE
		positionAux.setValuePositions(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExists(positionAux) && canMove(positionAux))
			possibleMatMove[positionAux.getRow()][positionAux.getColumn()] = true;

		// Movimento especial Castling

		// #specialmove castling
		if (getMoveCount() == 0 && !chessMatch.getCheck()) {
			// #specialmove castling kingside rook
			Position posT1 = new Position(position.getRow(), position.getColumn() + 3);
			if (possibleRookCastling(posT1)) {
				Position p1 = new Position(position.getRow(), position.getColumn() + 1);
				Position p2 = new Position(position.getRow(), position.getColumn() + 2);
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
					possibleMatMove[position.getRow()][position.getColumn() + 2] = true;
				}
			}
			// #specialmove castling queenside rook
			Position posT2 = new Position(position.getRow(), position.getColumn() - 4);
			if (possibleRookCastling(posT2)) {
				Position p1 = new Position(position.getRow(), position.getColumn() - 1);
				Position p2 = new Position(position.getRow(), position.getColumn() - 2);
				Position p3 = new Position(position.getRow(), position.getColumn() - 3);
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
					possibleMatMove[position.getRow()][position.getColumn() - 2] = true;
				}
			}
		}

		return possibleMatMove;
	}

	@Override
	public String toString() {
		return "K";
	}

}
