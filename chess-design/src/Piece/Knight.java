package Piece;

import Application.Board;
import Application.Position;

public class Knight extends Piece{
    public Knight(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(Position desiredPosition, Position currentPosition, Board board) {
        return false;
    }

}
