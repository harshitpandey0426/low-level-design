package Application;
import Piece.Piece;
import Piece.King;
import Piece.Rook;
public class Board {
    Cell[][] board;
    Piece piece;
    public Board(int size, Piece piece){
        this.piece= piece;
        board = new Cell[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                board[i][j] = initializeBoard(i,j);
            }
        }
    }
    Cell initializeBoard(int i,int j){
        Cell cell;
        if(i==0&&j==0||i==0&&j==7){
            cell = new Cell(new Position(i,j),new Rook(true));
        }
        if(i==7&&j==0||i==7&&j==7){
            cell = new Cell(new Position(i,j),new Rook(false));
        }
        else{
            cell = new Cell(new Position(i,j),null);
        }
        return cell;
    }
//    public boolean move(Piece piece,Position desiredCell){
//        Position currentPosition = piece.pieceVsPosition.get(piece);
//        return piece.isValidMove(desiredCell,currentPosition);
//    }
}
