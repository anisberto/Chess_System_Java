package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {

	public Knight(Board board, Color color) {
		super(board, color);
	}

	private boolean canMove(Position position) {
		ChessPiece pieceThisPosition = (ChessPiece) getBoard().piece(position);
		return pieceThisPosition == null || pieceThisPosition.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] possibleMatMove = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position positionAux = new Position(0, 0);

		positionAux.setValuePositions(position.getRow() - 1, position.getColumn() - 2);
		if (getBoard().positionExists(positionAux) && canMove(positionAux))
			possibleMatMove[positionAux.getRow()][positionAux.getColumn()] = true;

		positionAux.setValuePositions(position.getRow() - 2, position.getColumn() - 1);
		if (getBoard().positionExists(positionAux) && canMove(positionAux))
			possibleMatMove[positionAux.getRow()][positionAux.getColumn()] = true;

		positionAux.setValuePositions(position.getRow() - 2, position.getColumn() + 1);
		if (getBoard().positionExists(positionAux) && canMove(positionAux))
			possibleMatMove[positionAux.getRow()][positionAux.getColumn()] = true;

		positionAux.setValuePositions(position.getRow() - 1, position.getColumn() + 2);
		if (getBoard().positionExists(positionAux) && canMove(positionAux))
			possibleMatMove[positionAux.getRow()][positionAux.getColumn()] = true;

		positionAux.setValuePositions(position.getRow() + 1, position.getColumn() + 2);
		if (getBoard().positionExists(positionAux) && canMove(positionAux))
			possibleMatMove[positionAux.getRow()][positionAux.getColumn()] = true;

		positionAux.setValuePositions(position.getRow() + 1, position.getColumn() - 2);
		if (getBoard().positionExists(positionAux) && canMove(positionAux))
			possibleMatMove[positionAux.getRow()][positionAux.getColumn()] = true;

		positionAux.setValuePositions(position.getRow() + 2, position.getColumn() + 1);
		if (getBoard().positionExists(positionAux) && canMove(positionAux))
			possibleMatMove[positionAux.getRow()][positionAux.getColumn()] = true;

		positionAux.setValuePositions(position.getRow() + 2, position.getColumn() - 1);
		if (getBoard().positionExists(positionAux) && canMove(positionAux))
			possibleMatMove[positionAux.getRow()][positionAux.getColumn()] = true;

		positionAux.setValuePositions(position.getRow() - 1, position.getColumn() - 2);
		if (getBoard().positionExists(positionAux) && canMove(positionAux))
			possibleMatMove[positionAux.getRow()][positionAux.getColumn()] = true;

		return possibleMatMove;
	}

	@Override
	public String toString() {
		return "N";
	}
}
