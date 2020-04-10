package aplication;

import boardgame.Board;
import boardgame.Position;

public class Program {

	public static void main(String[] args) {
		Position posicao = new Position(8, 8);
		Board board = new Board(posicao.getRow(), posicao.getColumn());
		System.out.println(posicao);
		System.out.println();
		System.out.println(board);
	}
}
