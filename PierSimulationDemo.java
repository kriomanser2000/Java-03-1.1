public class PierSimulationDemo
{
    public static void main(String[] args)
    {
        PierSimulation simulation = new PierSimulation(100);
        long currentTime = System.currentTimeMillis();
        simulation.addPassenger(currentTime);
        simulation.addPassenger(currentTime + 2000);
        simulation.addBoat(currentTime + 5000, true);
        double averageWaitingTime = simulation.calculateAverageWaitingTime();
        System.out.println("Average time spent by a passenger at a bus stop: " + averageWaitingTime + " ms");
        long sufficientBoatInterval = simulation.calculateSufficientBoatInterval(10);
        System.out.println("Sufficient interval between boats: " + sufficientBoatInterval + " ms");
    }
}
