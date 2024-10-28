import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class Passenger
{
    private final long arrivalTime;
    public Passenger(long arrivalTime)
    {
        this.arrivalTime = arrivalTime;
    }
    public long getArrivalTime()
    {
        return arrivalTime;
    }
}
class Boat
{
    private final boolean isEndStop;
    private final int capacity;
    private final long arrivalTime;
    public Boat(boolean isEndStop, int capacity, long arrivalTime)
    {
        this.isEndStop = isEndStop;
        this.capacity = capacity;
        this.arrivalTime = arrivalTime;
    }
    public boolean isEndStop()
    {
        return isEndStop;
    }
    public int getCapacity()
    {
        return capacity;
    }
    public long getArrivalTime()
    {
        return arrivalTime;
    }
}
class PierSimulation
{
    private final Queue<Passenger> passengersQueue = new LinkedList<>();
    private final Queue<Boat> boatsQueue = new LinkedList<>();
    private final Random random = new Random();
    private final int maxPassengersOnPier;
    public PierSimulation(int maxPassengersOnPier)
    {
        this.maxPassengersOnPier = maxPassengersOnPier;
    }
    public void addPassenger(long currentTime)
    {
        passengersQueue.add(new Passenger(currentTime));
    }
    public void addBoat(long currentTime, boolean isEndStop)
    {
        int randomCapacity = 5 + random.nextInt(15);
        boatsQueue.add(new Boat(isEndStop, randomCapacity, currentTime));
    }
    public double calculateAverageWaitingTime() {
        long totalWaitingTime = 0;
        int count = 0;
        while (!passengersQueue.isEmpty() && !boatsQueue.isEmpty()) {
            Boat boat = boatsQueue.poll();
            int passengersToBoard = Math.min(boat.getCapacity(), passengersQueue.size());
            for (int i = 0; i < passengersToBoard; i++) {
                Passenger passenger = passengersQueue.poll();
                totalWaitingTime += (boat.getArrivalTime() - passenger.getArrivalTime());
                count++;
            }
        }
        return count == 0 ? 0 : (double) totalWaitingTime / count;
    }
    public long calculateSufficientBoatInterval(long peakPassengerArrivalRate)
    {
        return maxPassengersOnPier / peakPassengerArrivalRate;
    }
}
