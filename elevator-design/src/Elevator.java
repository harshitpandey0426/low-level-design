public class Elevator {
    int id;

    Display display;
    Status status;
    Door door;
    Direction direction;

    Elevator (int id){
        this.id = id;
    }


    @Override
    public String toString() {
        return "Elevator{" +
                "id=" + id +
                ", display=" + display +
                ", status=" + status +
                ", door=" + door +
                ", direction=" + direction +
                '}';
    }
    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Door getDoor() {
        return door;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
