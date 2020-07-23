package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	
	private Board board;
	
	public ChessMatch() {
		// instanciando um objeto new board
		board = new Board(8, 8);
		intialSetup();
	}
	//funcao getPieces, pega um vetor de Objetos ChessPieces e retorna uma matriz com mat
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for(int i=0;i<board.getRows();i++) {
			for(int j=0;j<board.getColumns();j++) {
				mat[i][j]= (ChessPiece) board.piece(i, j);
		}
	}
		return mat;
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
	
		validateSourcePosition(source);
	
		Piece capturedPiece = makeMove(source, target);

		return (ChessPiece) capturedPiece;
	}
	
	private void validateSourcePosition(Position position) {
		if(!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece on source position!");
		}
	}
	
	private Piece makeMove(Position source, Position target) {
		
		Piece p = board.removePiece(source);
		//System.out.println("source: "+p);
		Piece capturedPiece = board.removePiece(target);
		//System.out.println("captured: "+capturedPiece);
		board.placePiece(p, target);
		//System.out.println("target: "+target);
		return capturedPiece;
	}
	
	// funcao que adiciona peça ao tabuleiro, recebendo um caracter, um inteiro e uma peça da classe ChessPiece
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		// chama o metodo da classe Board, instanciando um novo objeto da classe ChessPosition passando a columa e linha
		//e transformando para caracter e coluna
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	// funcao que seta as peças no tabuleiro e instancia as determinadas classes.
	private void intialSetup() {
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
	}
}
