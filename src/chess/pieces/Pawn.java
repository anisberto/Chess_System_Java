package chess.pieces;

import javax.annotation.PostConstruct;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
	private ChessMatch chessMatch;

	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
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
			if (getBoard().positionExists(AuxPositionOnTheBoard) && !getBoard().thereIsAPiece(AuxPositionOnTheBoard)
					&& getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
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

			// #Especial move en passant with white
			if (position.getRow() == 3) {
				Position pieceInLeft = new Position(position.getRow(), position.getColumn() - 1);
				if (getBoard().positionExists(pieceInLeft) && isTheOpponentPiece(pieceInLeft)
						&& getBoard().piece(pieceInLeft) == chessMatch.getEnPassantVulnerable()) {
					matPiecesAux[pieceInLeft.getRow() - 1][pieceInLeft.getColumn()] = true;
				}
				Position pieceInRight = new Position(position.getRow(), position.getColumn() + 1);
				if (getBoard().positionExists(pieceInRight) && isTheOpponentPiece(pieceInRight)
						&& getBoard().piece(pieceInRight) == chessMatch.getEnPassantVulnerable()) {
					matPiecesAux[pieceInRight.getRow() - 1][pieceInRight.getColumn()] = true;
				}
			}

		} else {
			AuxPositionOnTheBoard.setValuePositions(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(AuxPositionOnTheBoard) && !getBoard().thereIsAPiece(AuxPositionOnTheBoard)) {
				matPiecesAux[AuxPositionOnTheBoard.getRow()][AuxPositionOnTheBoard.getColumn()] = true;
			}
			AuxPositionOnTheBoard.setValuePositions(position.getRow() + 2, position.getColumn());
			Position p2 = new Position(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(AuxPositionOnTheBoard) && !getBoard().thereIsAPiece(AuxPositionOnTheBoard)
					&& getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
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

			// #Especial move en passant with black
			if (position.getRow() == 4) {
				Position pieceInLeft = new Position(position.getRow(), position.getColumn() - 1);
				if (getBoard().positionExists(pieceInLeft) && isTheOpponentPiece(pieceInLeft)
						&& getBoard().piece(pieceInLeft) == chessMatch.getEnPassantVulnerable()) {
					matPiecesAux[pieceInLeft.getRow() + 1][pieceInLeft.getColumn()] = true;
				}
				Position pieceInRight = new Position(position.getRow(), position.getColumn() + 1);
				if (getBoard().positionExists(pieceInRight) && isTheOpponentPiece(pieceInRight)
						&& getBoard().piece(pieceInRight) == chessMatch.getEnPassantVulnerable()) {
					matPiecesAux[pieceInRight.getRow() + 1][pieceInRight.getColumn()] = true;
				}
			}

		}
		return matPiecesAux;
	}

	@Override
	public String toString() {
		return "P";
	}

}
