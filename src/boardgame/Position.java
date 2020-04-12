package boardgame;

public class Position {
	private Integer row = 0;
	private Integer column = 0;

	public Position() {

	}

	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public Position(Position object) {
		this.row = object.row;
		this.column = object.column;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public Integer getColumn() {
		return column;
	}

	public void setColumn(Integer column) {
		this.column = column;
	}

	public void setValuePositions(int row, int column) {
		this.row = row;
		this.column = column;
	}

	@Override
	public String toString() {
		return row + ", " + column;
	}

}
