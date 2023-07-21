import java.lang.reflect.Array;
import java.util.*;

public class ElevatorController {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    Elevator elevator;
    Direction elevatorDirection=Direction.UP;
    int currentFloor;
    int id;
    Door door;

    public ElevatorController(Elevator elevator, Direction elevatorDirection, int currentFloor, Door door) {
        this.elevator = elevator;
        this.elevatorDirection = elevatorDirection;
        this.currentFloor = currentFloor;
        this.door = door;
    }

    Map<Integer, Object> pendingRequests = new HashMap<>();
    ArrayList<Integer>pendingRequests2 = new ArrayList<>();
    public void acceptNewRequest(int floor, Direction direction){

    }
    public void controlElevator(int button, Direction requestDirection){
        //LOOK algo;
        //when elevator is moving up
        elevator.setDirection(requestDirection);
        if(elevatorDirection == Direction.UP && requestDirection==Direction.UP && currentFloor < button){
            minHeap.add(button);
        }
        else if(elevatorDirection == Direction.UP && requestDirection==Direction.DOWN ){
            maxHeap.add(button);
        }
        else if (elevatorDirection == Direction.UP && requestDirection==Direction.UP && currentFloor > button){ //no need for condition here this will contain all remaining cases
            pendingRequests.put(button,requestDirection);
            pendingRequests2.add(button);
        }

        while(!minHeap.isEmpty()){
            System.out.println(elevator.id + " Elevator is at " + minHeap.poll());
        }
        for(var request : pendingRequests2){
            minHeap.add(request);

        }
        pendingRequests2.clear();
        //change elevator direction

        if(elevatorDirection==Direction.DOWN){
            elevatorDirection=Direction.UP;
        }
        else{
            elevatorDirection=Direction.DOWN;
        }
        //when elevator is moving down
        if(elevatorDirection == Direction.DOWN && requestDirection==Direction.DOWN && currentFloor > button){
            maxHeap.add(button);
        }
        else if(elevatorDirection == Direction.DOWN && requestDirection==Direction.UP ){
            minHeap.add(button);
        }
        else if (elevatorDirection == Direction.DOWN && requestDirection==Direction.DOWN && currentFloor < button){ //no need for condition here this will contain all remaining cases
            pendingRequests.put(button,requestDirection);
            pendingRequests2.add(button);
        }
        while(!maxHeap.isEmpty()){
            System.out.println(elevator.id + " Elevator is at " + maxHeap.poll());
        }
        for(var request : pendingRequests2){
            maxHeap.add(request);
        }
        pendingRequests2.clear();

    }
    public void setElevator(){
        elevator.setDisplay(new Display(currentFloor,elevatorDirection));
        elevator.setStatus(Status.Moving);
        elevator.setId(id);
        elevator.setDoor(door);
        elevator.setDirection(elevatorDirection);
    }


}
