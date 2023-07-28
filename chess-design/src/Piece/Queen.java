package Piece;

import Application.Position;

public class Queen extends Piece{
    public Queen(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(Position position) {
        return false;
    }
}
