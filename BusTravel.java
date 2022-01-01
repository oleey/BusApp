import java.util.*;
import java.util.concurrent.*;
public class BusTravel {

    public static void main(String[] args){

        Bus bus = new Bus();
        Station station1 = new Station("Station 1");
        Station station2 = new Station("Station 2");
        Station station3 = new Station("Station 3");
        Station station4 = new Station("Station 4");
        Station station5 = new Station("Station 5");

        Station[] stations = { station1, station2, station3, station4, station5 };


        for (Station station : stations) {
            station.setBus(bus);
            Thread thread = new Thread(station);
            thread.start();
        }
    }
}
