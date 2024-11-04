import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] cells;
    HashMap<Integer,Integer>jumpMap= new HashMap<>();

    Board(int row, int col,int snakesCount, int ladderCount){
        initializeBoard(row,col);
        addSnakesAndLadders(snakesCount,ladderCount);
    }
    public void initializeBoard(int row,int col){
        cells = new Cell[row][col];
//        for(int i=0;i<row;i++){
//            for(int j=0;j<col;j++){
//                Cell obj = new Cell();
//                Jump jump = new Jump();
//                jump.end = i*row + j;
//                obj.jump = jump;
//                cells[i][j]=obj;
//            }
//        }
    }
    public void addSnakesAndLadders(int snakesCount, int ladderCount){
        int row=cells.length;
        int col=cells[0].length;
        while(snakesCount>0||ladderCount>0){

            int point1 = ThreadLocalRandom.current().nextInt(0,row*col-1);
            int point2 = ThreadLocalRandom.current().nextInt(0,row*col-1);


            if(point1>point2){
                snakesCount--;
                this.jumpMap.put(point1,point2);

            }
            else if (point2>point1){
                ladderCount--;
                this.jumpMap.put(point1,point2);
            }
        }
    }
    Cell updateCell(int point2){
        int row=cells.length;
        int col=cells[0].length;
        return cells[point2/row][point2%row];
    }

    public Cell[][] getCells() {
        return cells;
    }

    public HashMap<Integer, Integer> getJumpMap() {
        return jumpMap;
    }

    public void setJumpMap(HashMap<Integer, Integer> jumpMap) {
        this.jumpMap = jumpMap;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }
}
