public class InternalButton {
//    Elevator elevator;
    InternalButtonDispatcher internalButtonDispatcher;

    InternalButton(InternalButtonDispatcher internalButtonDispatcher){
        this.internalButtonDispatcher = internalButtonDispatcher;
    }
    void pressButton(Elevator elevator,int button,Direction direction){
        internalButtonDispatcher.submitRequest(elevator.id,button,direction);
    }
}
