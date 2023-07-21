import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InternalButtonDispatcher {
    Map<Integer,Elevator> idWithElevators = new HashMap<>();
    ElevatorManager elevatorManager;
    public InternalButtonDispatcher(ElevatorManager elevatorManager){
        this.elevatorManager=elevatorManager;
    }
    public void submitRequest(int elevatorId, int button, Direction direction){
        idWithElevators.put(elevatorId,new Elevator(elevatorId));
        elevatorManager.createElevatorController(elevatorId,button,idWithElevators.get(elevatorId),direction);

    }
}
