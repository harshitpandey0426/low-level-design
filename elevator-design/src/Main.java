public class Main {
    public static void main(String[] args) {

//        ElevatorController elevatorController = new ElevatorController(elevator,Direction.UP,0,Door.Door1);
        ElevatorManager elevatorManager = new ElevatorManager();

        Elevator elevator1 = new Elevator(1);
        Elevator elevator2 = new Elevator(2);

        InternalButton internalButton = new InternalButton(new InternalButtonDispatcher(elevatorManager));
        internalButton.pressButton(elevator1,5, Direction.UP);
        internalButton.pressButton(elevator1,8, Direction.UP);
        internalButton.pressButton(elevator1,6, Direction.UP);
        internalButton.pressButton(elevator1,2, Direction.UP);

        internalButton.pressButton(elevator2,11, Direction.UP);
    }
}