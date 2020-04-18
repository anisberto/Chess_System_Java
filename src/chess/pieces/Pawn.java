package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matPiecesAux = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position AuxPositionOnTheBoard = new Position(0, 0);

		if (getColor() == Color.WHITE) {
			
			AuxPositionOnTheBoard.setValuePositions(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(AuxPositionOnTheBoard) && !getBoard().thereIsAPiece(AuxPositionOnTheBoard)) {
				matPiecesAux[AuxPositionOnTheBoard.getRow()][AuxPositionOnTheBoard.getColumn()] = true;
			}
			
			AuxPositionOnTheBoard.setValuePositions(position.getRow() - 2, position.getColumn());
			Position p2 = new Position(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(AuxPositionOnTheBoard) && !getBoard().thereIsAPiece(AuxPositionOnTheBoard) && getBoard().positionExists(p2)
					&& !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				matPiecesAux[AuxPositionOnTheBoard.getRow()][AuxPositionOnTheBoard.getColumn()] = true;
			}
			AuxPositionOnTheBoard.setValuePositions(position.getRow() - 1, position.getColumn() - 1);
			if (getBoard().positionExists(AuxPositionOnTheBoard) && isTheOpponentPiece(AuxPositionOnTheBoard)) {
				matPiecesAux[AuxPositionOnTheBoard.getRow()][AuxPositionOnTheBoard.getColumn()] = true;
			}
			AuxPositionOnTheBoard.setValuePositions(position.getRow() - 1, position.getColumn() + 1);
			if (getBoard().positionExists(AuxPositionOnTheBoard) && isTheOpponentPiece(AuxPositionOnTheBoard)) {
				matPiecesAux[AuxPositionOnTheBoard.getRow()][AuxPositionOnTheBoard.getColumn()] = true;
			}

		} else {
			AuxPositionOnTheBoard.setValuePositions(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(AuxPositionOnTheBoard) && !getBoard().thereIsAPiece(AuxPositionOnTheBoard)) {
				matPiecesAux[AuxPositionOnTheBoard.getRow()][AuxPositionOnTheBoard.getColumn()] = true;
			}
			AuxPositionOnTheBoard.setValuePositions(position.getRow() + 2, position.getColumn());
			Position p2 = new Position(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(AuxPositionOnTheBoard) && !getBoard().thereIsAPiece(AuxPositionOnTheBoard) && getBoard().positionExists(p2)
					&& !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				matPiecesAux[AuxPositionOnTheBoard.getRow()][AuxPositionOnTheBoard.getColumn()] = true;
			}
			AuxPositionOnTheBoard.setValuePositions(position.getRow() + 1, position.getColumn() - 1);
			if (getBoard().positionExists(AuxPositionOnTheBoard) && isTheOpponentPiece(AuxPositionOnTheBoard)) {
				matPiecesAux[AuxPositionOnTheBoard.getRow()][AuxPositionOnTheBoard.getColumn()] = true;
			}
			AuxPositionOnTheBoard.setValuePositions(position.getRow() + 1, position.getColumn() + 1);
			if (getBoard().positionExists(AuxPositionOnTheBoard) && isTheOpponentPiece(AuxPositionOnTheBoard)) {
				matPiecesAux[AuxPositionOnTheBoard.getRow()][AuxPositionOnTheBoard.getColumn()] = true;
			}

		}
		return matPiecesAux;
	}

	@Override
	public String toString() {
		return "P";
	}

}
