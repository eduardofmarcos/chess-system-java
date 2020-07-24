package boardgame;

public class Board {
	private int rows;
	private int columns;
	// instancia uma matriz de objetos Piece;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Error creating boarding: There is must be at least 1 row and 1 collumn!");
		}
		this.rows = rows;
		this.columns = columns;
		// cria uma matriz Piece do tamanho de terminada row*columns;
		pieces = new Piece[rows][columns];
		// System.out.println(pieces.length);

	}

	// Pega as linhas
	public int getRows() {
		return rows;
	}

	// pega as colunas
	public int getColumns() {
		return columns;
	}

	// metodo para posicionar a peça de acordo com a posição linhaXcoluna
	public Piece piece(int row, int collumn) {
		if (!positionExists(row, collumn)) {
			throw new BoardException("Error placing a piece: Position not on the board!");
		}
		// System.out.println("piece int: "+pieces[row][collumn]);
		return pieces[row][collumn];
	}

	// metodo para posicionar a peça de acordo com uma posição da classe position
	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Error placing a piece: Position not on the board!");
		}
		// System.out.println("piecie pos:
		// "+pieces[position.getRow()][position.getColumn()]);
		return pieces[position.getRow()][position.getColumn()];
	}

	// metodo para posicionar a peça no taboleiro
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("Error placing a piece: This position is not available: " + position);
		}
		// System.out.println("place a piece position: "+position);
		// System.out.println("place a piece: "+piece);
		// cria um objeto peça Pieces na posição abaixo
		// ********************** Matriz na posição RECEBE PEÇA!!!!!!!!!!!!!!!!!
		pieces[position.getRow()][position.getColumn()] = piece;
		// System.out.println(piece);
		// posição da peça recebe objeto posição
		// *******************************PEÇA RECEBE POSICAO!!!!!!!!!!!!!!!!!!
		piece.position = position;

	}

	public Piece removePiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Error placing a piece: Position not on the board!");
		}

		if (piece(position) == null) {
			return null;
		}
		Piece auxPiece = piece(position);
		auxPiece.position = null;
		pieces[position.getRow()][position.getColumn()] = null;

		return auxPiece;
	}

	// metodo que checa que se a posiçao existe baseada no inteiro linha e coluna
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}

	// metodo que checa que se a posiçao existe baseada no objeto posição
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}

	// metodo que checa que se exite uma peça ja na posição
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Error placing a piece: Position not on the board!");
		}
		return piece(position) != null;
	}

}
