public class Player {
    public String name;
    public PieceType pieceType;

    public Player(String name, PieceType pieceType) {
        this.name = name;
        this.pieceType = pieceType;
    }
    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }
}
