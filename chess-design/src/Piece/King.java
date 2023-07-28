package Piece;

import Application.Board;
import Application.Position;

public class King extends Piece{
    public King(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(Position desiredPosition, Position currentPosition, Board board) {
        int dx= desiredPosition.x,dy=desiredPosition.y;
        int cx= currentPosition.x,cy= currentPosition.y;
        if(Math.abs(cx-dx)<=1&&Math.abs(cy-dy)<=1&&dx<7&&dx>=0&&dy<7&&dy>=0)
        {
            if(!pieceVsPosition.containsKey(desiredPosition)){
                return true;
            }
        }
        return false;
    }
}
