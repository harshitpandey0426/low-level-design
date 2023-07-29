package Piece;

import Application.Board;
import Application.Position;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece{
    public Rook(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(Position desiredPosition, Position currentPosition, Board board) {
        return false;
    }

    public boolean isValidMove(Position desiredPosition, Position currentPosition){
        int cx= desiredPosition.x;
        int cy = desiredPosition.y;

        return true;
    }
//    public boolean isSquareUnderAttack(int targetRow, int targetCol, boolean isWhiteMove) {
//        // Iterate through all opponent's pieces on the chessboard
//        List<Piece> opponentPieces = new ArrayList<>();
//        for(var temp: pieceVsPosition.entrySet()){
//            Piece piece = temp.getKey();
//            if(piece.isWhite){
//                opponentPieces.add(piece);
//            }
//        }
//        for (Piece opponentPiece : opponentPieces) {
//            // Check if the opponent's piece can attack the target square
//            if (canAttack(targetRow, targetCol, isWhiteMove)) {
//                return true; // The square is under attack
//            }
//        }
//        return false; // The square is not under attack by any opponent's piece
//    }
//    public boolean canAttack(int targetRow, int targetCol, Board board) {
//        int currentRow = this.getRow();
//        int currentCol = this.getCol();
//
//        // Rooks can attack if the target square is on the same row or column
//        if (currentRow == targetRow && currentCol != targetCol) {
//            // Check if there are no pieces between the rook and the target square along the same row
//            int colStep = (targetCol > currentCol) ? 1 : -1;
//            for (int col = currentCol + colStep; col != targetCol; col += colStep) {
//                if (board.getPiece(currentRow, col) != null) {
//                    return false; // A piece is blocking the rook's path
//                }
//            }
//            return true; // The target square is reachable along the same row
//        } else if (currentRow != targetRow && currentCol == targetCol) {
//            // Check if there are no pieces between the rook and the target square along the same column
//            int rowStep = (targetRow > currentRow) ? 1 : -1;
//            for (int row = currentRow + rowStep; row != targetRow; row += rowStep) {
//                if (board.getPiece(row, currentCol) != null) {
//                    return false; // A piece is blocking the rook's path
//                }
//            }
//            return true; // The target square is reachable along the same column
//        }
//
//        return false; // The target square is neither on the same row nor column
//    }


}
