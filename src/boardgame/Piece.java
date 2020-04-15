package boardgame;

public abstract class Piece {
	protected Position position;
	private Board board;

	public Piece(Board board) {
		this.board = board;
		position = null;
	}

	protected Board getBoard() {
		return board;
	}

	public abstract boolean[][] possibleMoves();

	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}

	public boolean isThereAnyPossibleMove() {
		boolean[][] anyPositionTrue = possibleMoves();
		
		for (int i = 0; i < anyPositionTrue.length; i++) {
			for (int j = 0; j < anyPositionTrue[i].length; j++) {
				if (anyPositionTrue[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
}
