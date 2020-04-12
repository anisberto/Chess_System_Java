package chess.pieces;

import boardgame.Board;
import boardgame.Position;
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

	// Metodos Auxiliar
	private boolean canMove(Position position) {
		ChessPiece pieceThisPosition = (ChessPiece) getBoard().piece(position);
		return pieceThisPosition == null || pieceThisPosition.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] possibleMatMove = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position positionAux = new Position(0, 0);

		// Posi��o superior
		positionAux.setValuePositions(position.getRow() - 1, position.getColumn());
		if (getBoard().positionExists(positionAux) && canMove(positionAux))
			possibleMatMove[positionAux.getRow()][positionAux.getColumn()] = true;

		// Posi��o Inferior
		positionAux.setValuePositions(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExists(positionAux) && canMove(positionAux))
			possibleMatMove[positionAux.getRow()][positionAux.getColumn()] = true;

		// Posi��o esquerdo
		positionAux.setValuePositions(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExists(positionAux) && canMove(positionAux))
			possibleMatMove[positionAux.getRow()][positionAux.getColumn()] = true;

		// Posi��o direito
		positionAux.setValuePositions(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExists(positionAux) && canMove(positionAux))
			possibleMatMove[positionAux.getRow()][positionAux.getColumn()] = true;

		// Posi��o NW
		positionAux.setValuePositions(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExists(positionAux) && canMove(positionAux))
			possibleMatMove[positionAux.getRow()][positionAux.getColumn()] = true;

		// Posi��o NE
		positionAux.setValuePositions(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExists(positionAux) && canMove(positionAux))
			possibleMatMove[positionAux.getRow()][positionAux.getColumn()] = true;

		// Posi��o SW
		positionAux.setValuePositions(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExists(positionAux) && canMove(positionAux))
			possibleMatMove[positionAux.getRow()][positionAux.getColumn()] = true;

		// Posi��o SE
		positionAux.setValuePositions(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExists(positionAux) && canMove(positionAux))
			possibleMatMove[positionAux.getRow()][positionAux.getColumn()] = true;

		return possibleMatMove;
	}

}
