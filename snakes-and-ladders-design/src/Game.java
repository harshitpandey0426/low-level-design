import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Player winner;
    Deque<Player>playersList = new LinkedList<>();
    public Game(){
        board = new Board(10, 10,20,20);
        dice = new Dice(1);
        winner = null;
        addPlayers();
    }
    private void addPlayers() {
        Player player1 = new Player("p1", 0);
        Player player2 = new Player("p2", 0);
        playersList.add(player1);
        playersList.add(player2);
    }
    public void startGame(){

        while(winner==null){
            Player playerTurn =playersList.getFirst();
            playersList.removeFirst();
            playersList.addLast(playerTurn);

            System.out.println("player turn is:" + playerTurn.id + " current position is: " + playerTurn.currentPosition);

            Dice dice = new Dice(1);
            int diceValue = dice.rollDice();
            int playerNewPosition = playerTurn.currentPosition + diceValue;

            Cell[][] cell = board.getCells();
            int row= cell.length,col=cell[0].length;
            if(playerNewPosition >= row*col - 1){
                winner = playerTurn;
                break;
            }
            HashMap <Integer,Integer> jumpMap = board.getJumpMap();
            if(jumpMap.containsKey(playerNewPosition)){
                playerNewPosition=jumpMap.get(playerNewPosition);
            }
//            Jump jump = cell[playerNewPosition/row][playerNewPosition%row].jump;
//            playerNewPosition = jump.end;

            System.out.println("player turn is:" + playerTurn.id + " new Position is: " + playerNewPosition);

            playerTurn.currentPosition=playerNewPosition;

            if(playerNewPosition >= row*col - 1){
                winner = playerTurn;
                break;
            }
        }
        System.out.println("WINNER IS:" + winner.id);
    }


}
