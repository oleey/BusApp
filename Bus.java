
public class Bus {

    private int numberOfPassengers = 0;

    public int getNumberOfPassengers() {
        return this.numberOfPassengers;
    }

    public void loadBus(int passengers) {
        this.numberOfPassengers += passengers;
    }

    public void unloadBus(int passengers) {
        this.numberOfPassengers -= passengers;
    }

    public int getAvailableSeat(){
        return 50 - this.numberOfPassengers;
    }
}