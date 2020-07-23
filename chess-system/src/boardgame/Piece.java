package boardgame;

public class Piece {
	
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
	
		this.board = board;
		//System.out.println(this.board);
		position = null;
		
	}

	protected Board getBoard() {
		return board;
	}
	
	
	
}
