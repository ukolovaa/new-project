public class Elevator {
    private int currentFloor = 1;
    private int minFloor;
    private int maxFloor;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveDown() {
        currentFloor = currentFloor > minFloor ? currentFloor - 1 : currentFloor;
    }

    public void moveUp() {
        currentFloor = currentFloor < maxFloor ? currentFloor + 1 : currentFloor;
    }

    public void move(int floor) {
        if (floor > maxFloor || floor < minFloor) {
            System.out.println("Error!");
            return;
        } else if (currentFloor > floor) {
            while (currentFloor != floor) {
                moveDown();
                System.out.println("Floor: " + currentFloor);
            }
        } else if (currentFloor < floor) {
            while (currentFloor != floor) {
                moveUp();
                System.out.println("Floor: " + currentFloor);
            }
        } else {
            return;
        }
    }
}
