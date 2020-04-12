package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;
import exceptions.ChessException;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] possibleMatMove = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position auxPosition = new Position(0, 0);

		/// Marcar posi��es Superiores a Pe�a atual
		auxPosition.setValuePositions(position.getRow() - 1, position.getColumn());
		
		while (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
			
			possibleMatMove[auxPosition.getRow()][auxPosition.getColumn()] = true;
			auxPosition.setRow(auxPosition.getRow() - 1);
		}
		if (getBoard().positionExists(auxPosition) && isTheOpponentPiece(auxPosition)) {
			possibleMatMove[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}

		/// Marcar posi��es a esquerda da Pe�a atual
		auxPosition.setValuePositions(position.getRow(), position.getColumn() - 1);
		while (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
			possibleMatMove[auxPosition.getRow()][auxPosition.getColumn()] = true;
			auxPosition.setColumn(auxPosition.getColumn() - 1);
		}
		if (getBoard().positionExists(auxPosition) && isTheOpponentPiece(auxPosition)) {
			possibleMatMove[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}

		/// Marcar posi��es a direita da Pe�a atual
		auxPosition.setValuePositions(position.getRow(), position.getColumn() + 1);
		while (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
			possibleMatMove[auxPosition.getRow()][auxPosition.getColumn()] = true;
			auxPosition.setColumn(auxPosition.getColumn() + 1);
		}
		if (getBoard().positionExists(auxPosition) && isTheOpponentPiece(auxPosition)) {
			possibleMatMove[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}

		/// Marcar posi��es inferior a Pe�a atual
		auxPosition.setValuePositions(position.getRow() + 1, position.getColumn());
		while (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
			possibleMatMove[auxPosition.getRow()][auxPosition.getColumn()] = true;
			auxPosition.setRow(auxPosition.getRow() + 1);
		}
		if (getBoard().positionExists(auxPosition) && isTheOpponentPiece(auxPosition)) {
			possibleMatMove[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}
		return possibleMatMove;
	}
}
