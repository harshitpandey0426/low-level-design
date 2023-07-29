package Piece;

import Application.Board;
import Application.Position;

public class Queen extends Piece{
    public Queen(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(Position desiredPosition, Position currentPosition, Board board) {
        return false;
    }


}
