import java.util.Arrays;

public class Board {
    int size;
    Cell[][] board;

    public Board(int size) {
        this.size = size;
        board = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell();
            }
        }
    }
    public boolean addPiece(int row, int col, PieceType pieceType){
        if(board[row][col].pieceType!=null){
            return false;
        }
        board[row][col].pieceType=pieceType;
        return true;
    }
    public void printBoard() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j].pieceType != null) {
                    System.out.print(board[i][j].pieceType + " ");
                } else {
                    System.out.print("  ");

                }
                System.out.print("| ");
            }
            System.out.println();

        }
    }



}
