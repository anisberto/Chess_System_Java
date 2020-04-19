package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {

	public Queen(Board board, Color color) {
		super(board, color);
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] possibleMatMove = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position auxPosition = new Position(0, 0);

		/// Marcar posições Superiores a Peça atual
		auxPosition.setValuePositions(position.getRow() - 1, position.getColumn());

		while (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {

			possibleMatMove[auxPosition.getRow()][auxPosition.getColumn()] = true;
			auxPosition.setRow(auxPosition.getRow() - 1);
		}
		if (getBoard().positionExists(auxPosition) && isTheOpponentPiece(auxPosition)) {
			possibleMatMove[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}

		/// Marcar posições a esquerda da Peça atual
		auxPosition.setValuePositions(position.getRow(), position.getColumn() - 1);
		while (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
			possibleMatMove[auxPosition.getRow()][auxPosition.getColumn()] = true;
			auxPosition.setColumn(auxPosition.getColumn() - 1);
		}
		if (getBoard().positionExists(auxPosition) && isTheOpponentPiece(auxPosition)) {
			possibleMatMove[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}

		/// Marcar posições a direita da Peça atual
		auxPosition.setValuePositions(position.getRow(), position.getColumn() + 1);
		while (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
			possibleMatMove[auxPosition.getRow()][auxPosition.getColumn()] = true;
			auxPosition.setColumn(auxPosition.getColumn() + 1);
		}
		if (getBoard().positionExists(auxPosition) && isTheOpponentPiece(auxPosition)) {
			possibleMatMove[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}

		/// Marcar posições inferior a Peça atual
		auxPosition.setValuePositions(position.getRow() + 1, position.getColumn());
		while (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
			possibleMatMove[auxPosition.getRow()][auxPosition.getColumn()] = true;
			auxPosition.setRow(auxPosition.getRow() + 1);
		}
		if (getBoard().positionExists(auxPosition) && isTheOpponentPiece(auxPosition)) {
			possibleMatMove[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}

		///
		auxPosition.setValuePositions(position.getRow() - 1, position.getColumn() - 1);

		while (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {

			possibleMatMove[auxPosition.getRow()][auxPosition.getColumn()] = true;
			auxPosition.setValuePositions(auxPosition.getRow() - 1, auxPosition.getColumn() - 1);
		}
		if (getBoard().positionExists(auxPosition) && isTheOpponentPiece(auxPosition)) {
			possibleMatMove[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}

		/// NE
		auxPosition.setValuePositions(position.getRow() - 1, position.getColumn() + 1);
		while (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
			possibleMatMove[auxPosition.getRow()][auxPosition.getColumn()] = true;
			auxPosition.setValuePositions(auxPosition.getRow() - 1, auxPosition.getColumn() + 1);
		}
		if (getBoard().positionExists(auxPosition) && isTheOpponentPiece(auxPosition)) {
			possibleMatMove[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}

		/// SE
		auxPosition.setValuePositions(position.getRow() + 1, position.getColumn() + 1);
		while (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
			possibleMatMove[auxPosition.getRow()][auxPosition.getColumn()] = true;
			auxPosition.setValuePositions(auxPosition.getRow() + 1, auxPosition.getColumn() + 1);
		}
		if (getBoard().positionExists(auxPosition) && isTheOpponentPiece(auxPosition)) {
			possibleMatMove[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}

		/// SW
		auxPosition.setValuePositions(position.getRow() + 1, position.getColumn() - 1);
		while (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
			possibleMatMove[auxPosition.getRow()][auxPosition.getColumn()] = true;
			auxPosition.setValuePositions(auxPosition.getRow() + 1, auxPosition.getColumn() - 1);
		}
		if (getBoard().positionExists(auxPosition) && isTheOpponentPiece(auxPosition)) {
			possibleMatMove[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}
		///

		return possibleMatMove;
	}

	@Override
	public String toString() {
		return "Q";
	}

}
