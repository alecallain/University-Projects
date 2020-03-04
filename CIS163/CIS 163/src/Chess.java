
public class Chess {
	
	private char [][] board;
	
	public Chess() {
		board = new char[8][8];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j< board[i].length; j++) {
				board[i][j] = '*';
			}
		}
	}
	
	public void printBoard() {
		for (int i = 0; i <8; i++ ) {
			for (int j = 0; j < 8; j++) {
				System.out.print(" " + board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void placePiece(char piece, int row, int col) {
		board[row][col] = piece;
	}
	
	public static void main (String [] args) {
		Chess go = new Chess();
		
		go.placePiece('r', 0, 0);
		go.placePiece('R', 7, 7);
		for (int i = 0; i < 8; i++) {
			go.placePiece('p', 1, i);
			go.placePiece('P', 6, i);
		}
	}
	
}
