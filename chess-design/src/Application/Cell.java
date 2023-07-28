package Application;

import Piece.Piece;

public class Cell {
    Position position;
    Piece piece;
    Cell(Position position,Piece piece){
        this.position=position;
        this.piece=piece;
    }
}
