package Piece;

import Application.Position;

public class Knight extends Piece{
    public Knight(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(Position position) {
        return false;
    }
}
