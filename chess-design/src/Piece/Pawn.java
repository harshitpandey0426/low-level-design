package Piece;

import Application.Board;
import Application.Position;

public class Pawn extends Piece{
    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(Position desiredPosition, Position currentPosition, Board board) {
        return false;
    }
}
