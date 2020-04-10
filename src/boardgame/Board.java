package boardgame;

import boardgame.exception.BoardException;

public class Board {
	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1)
			throw new BoardException(
					"Erro ao Criar Tabuleiro: É necessario que exista pelo menos uma linnha e uma coluna! " + rows
							+ ", " + columns);

		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece piece(int row, int column) {
		if (!positionExists(row, column))
			throw new BoardException(
					"Erro ao acessar posição: Esta posição não existe no tabuleiro! " + row + ", " + column);

		return pieces[row][column];
	}

	public Piece piece(Position position) {
		if (!positionExists(position))
			throw new BoardException("Erro ao acessar posição: Esta posição não existe no tabuleiro! " + position);

		return pieces[position.getRow()][position.getColumn()];
	}

	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position))
			throw new BoardException("Erro ao incluir peça: Existe uma peça nesta posição: " + position);

		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}

	// Metodo Auxiliar
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}

	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}

	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position))
			throw new BoardException("Erro ao acessar posição: Esta posição não existe no tabuleiro! " + position);

		return piece(position) != null;
	}
}
