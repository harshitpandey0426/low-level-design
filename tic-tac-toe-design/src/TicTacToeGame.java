import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TicTacToeGame {
    Deque<Player> players;
    Board  board;
    public TicTacToeGame(){
        initializeGame();
    }
    private void initializeGame(){
        Player player1 = new Player("p1",PieceType.O);
        Player player2 = new Player("p2",PieceType.X);
        players = new LinkedList<>();
        players.add(player1);
        players.add(player2);
        board = new Board(3);
    }
    public String startGame(){
        int size = board.size;
        int remainingMoves = size*size;
        boolean winner = false;
        while(winner||remainingMoves > 0){
            Player current = players.poll();


            Scanner scannerInput = new Scanner(System.in);
            int row = scannerInput.nextInt();
            int col = scannerInput.nextInt();
//            board.printBoard();
            boolean pieceAdded = board.addPiece(row,col,current.pieceType);
            board.printBoard();
            if(!pieceAdded){
                players.addFirst(current);
                System.out.println("Place is already filled try different position");
                continue;
            }
            else{
                players.addLast(current);
            }
            remainingMoves--;
            winner = isThereWinner(row,col,current.pieceType);

            if(winner){
                return current.name;
            }

        }
        return "Tie";
    }
    public boolean isThereWinner(int row, int column, PieceType pieceType) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0;i<board.size;i++) {

            if(board.board[row][i].pieceType == null || board.board[row][i].pieceType != pieceType) {
                rowMatch = false;
                break;
            }
        }

        //need to check in column
        for(int i=0;i<board.size;i++) {

            if(board.board[i][column].pieceType  == null || board.board[i][column].pieceType != pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<board.size;i++,j++) {
            if (board.board[i][j].pieceType  == null || board.board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=board.size-1; i<board.size;i++,j--) {
            if (board.board[i][j].pieceType  == null || board.board[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }




}
