import java.util.Random;

public class Station implements Runnable {

    Random random = new Random(50);

    private int queued = random.nextInt(50);
    //int availableSeats;
    private String stationName;
    private Bus bus;


    public Station(String stationName) {
        this.stationName = stationName;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    @Override
    public void run() {
        unloadBus(this.bus);
        loadBus(this.bus);
    }

    public Bus unloadBus(Bus bus) {
        if (bus.getNumberOfPassengers() == 0) {
            System.out.print(this.stationName);
            System.out.println(": bus empty, no passenger to unload");
            return bus;
        }

        int passengersUnloaded = random.nextInt(bus.getNumberOfPassengers());
        bus.unloadBus(passengersUnloaded);
       // availableSeats += passengersUnloaded;
        //System.out.println(availableSeats + " here");
        System.out.print(this.stationName);
        System.out.printf(": number of passenger to unload is %d", passengersUnloaded);
        System.out.println();
        return bus;
    }

    public Bus loadBus(Bus bus) {
        int passengersLoaded;
        if(bus.getNumberOfPassengers() == 50) {
            System.out.print(this.stationName);
            System.out.println(": bus full, no passenger to loaded");
            return bus;
        }

       // queued = random.nextInt(50);
       // if (queued < availableSeats) {
      //      passengersLoaded = queued;
      //  }
       // availableSeats =
        int availableSeats = bus.getAvailableSeat();
        passengersLoaded = random.nextInt(availableSeats);
        bus.loadBus(passengersLoaded);
        System.out.print(this.stationName);
        System.out.printf(", number of passenger loaded is %d", passengersLoaded);
        System.out.print(", available seats are " + availableSeats);
        System.out.println();
        return bus;
    }
}
