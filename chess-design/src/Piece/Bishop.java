package Piece;

import Application.Board;
import Application.Position;

public class Bishop extends Piece{
    public Bishop(boolean isWhite){
        super(isWhite);
    }

    @Override
    public boolean isValidMove(Position desiredPosition, Position currentPosition, Board board) {
        return false;
    }
}
