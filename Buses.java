import java.util.*;
import java.util.concurrent.*;
public class Buses{
    Semaphore sem;
    int availableSeats = 50;
    int disembarked = 0;
    int queued = 0;
    int boarded = 0;
    int currentPassengers = 0;
    Random rand = new Random();

    public Buses(Semaphore sem){
        this.sem = sem;
    }


    // @Override
     public void run(int n){
        System.out.print("Station " + n + ": ");


        try {
            sem.acquire();
            // on starting the cycle,
            // 50 seats are available and no one has boarded, queued or disembarked at the station

            System.out.print(disembarked + " disembarked, ");
            System.out.print(queued + " queued, ");
            System.out.print(boarded + " boarded, ");
            System.out.print(currentPassengers + " current passengers, ");
            System.out.println(availableSeats + " available seats");

            // if nobody is onboard then nobody can disembark at the station
            if (currentPassengers == 0) {
                disembarked = 0;
            } else {
                //only random number of people onboard can disembark at the station
                disembarked = rand.nextInt(currentPassengers);
            }
            //random number of persons can queue at the station
            queued = rand.nextInt(50);
            //if persons queued up is less than available seats on bus then that means that
            //all can board otherwise it means that there is not enough space for all to board and only
            //the number of available seats can board
            if (queued < availableSeats) {
                boarded = queued;
            } else {
                boarded = availableSeats;
                //int waiting = queued - boarded;
                //System.out.println(waiting + " Passenger could not get on the bus, they'll wait for next cycle");
            }
            //boarded = rand.nextInt(queued);
            //number of passengers currently onboard
            currentPassengers = (currentPassengers - disembarked) + boarded;

            //number of available seats
            availableSeats = availableSeats + disembarked - boarded;
            Thread.sleep(1000);

        }catch (InterruptedException exc){
            System.out.print("I am here " + exc);
        }

        sem.release();

    }
    public static void main(String[] args){
        Semaphore sem = new Semaphore(5);
        Buses buses = new Buses(sem);
        //loop through the stations to repeat cycle of the 5 stations twice
        for(int j=0;j<2;j++) {
            for (int i = 1; i <= 5; i++) {
                buses.run(i);
            }
        }
    }
}