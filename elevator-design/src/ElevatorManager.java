import java.util.HashMap;
import java.util.Map;

public class ElevatorManager {
    Map<Integer, ElevatorController> elevatorControllerWithId = new HashMap<>();
    Map<Integer, Elevator> elevatorWithId = new HashMap<>();
    Elevator elevator;
    public ElevatorManager(){

    }
    public void createElevatorController(int id,int button,Elevator elevator, Direction direction){
        ElevatorController elevatorController = new ElevatorController(elevator,Direction.UP,0,Door.Door1);
        elevatorControllerWithId.put(id,elevatorController);
        elevatorWithId.put(id,elevator);
        callElevatorController(id,button,direction);

    }
    public void callElevatorController(int id,int button, Direction direction){
        elevatorControllerWithId.get(id).controlElevator(button,direction);
    }

}
