package boardgame;

public abstract class Piece {
	
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
	
	public abstract boolean[][] possibleMoves();
	
	
	/****************** Implementação concreta que depende de metodos abstratos************/
	public boolean possibleMove(Position position) {
		//hook methods um metodo que faz um gancho com a subclasse
		return possibleMoves()[position.getRow()][position.getColumn()];
	};
	
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();

	
		for(int i=0; i<mat.length;i++) {
			for (int j=0; j<mat.length;j++) {
				if(mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	
}
