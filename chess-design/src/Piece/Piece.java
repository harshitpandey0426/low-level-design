package Piece;


import Application.Board;
import Application.Position;

import java.util.HashMap;
import java.util.Map;

public abstract class Piece {
    public Map<Piece, Position> pieceVsPosition = new HashMap<>();
    boolean isWhite;
    boolean isKilled;
    Position position;
    public Piece(boolean isWhite){
        this.isWhite=isWhite;
    }
    public abstract boolean isValidMove(Position desiredPosition, Position currentPosition, Board board);
    public boolean isSquareUnderAttack(int targetRow, int targetCol, boolean isWhiteMove) {
        // Iterate through all opponent's pieces on the chessboard
//        for (Piece opponentPiece : opponentPieces) {
//            // Check if the opponent's piece can attack the target square
//            if (opponentPiece.canAttack(targetRow, targetCol, isWhiteMove)) {
//                return true; // The square is under attack
//            }
//        }
        return false; // The square is not under attack by any opponent's piece
    }
}
