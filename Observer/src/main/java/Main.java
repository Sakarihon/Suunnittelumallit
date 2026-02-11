public class Main {
    public static void main(String[] args) throws InterruptedException {

        WeatherStation station = new WeatherStation();

        WeatherObserver obsA = new ConsoleObserverA();
        WeatherObserver obsB = new ConsoleObserverB();
        WeatherObserver obsC = new ConsoleObserverC();

        station.addObserver(obsA);
        station.addObserver(obsB);
        station.addObserver(obsC);

        Thread stationThread = new Thread(station);
        stationThread.start();

        Thread.sleep(15000);

        System.out.println("\nRemoving Observer B\n");
        station.removeObserver(obsB);

        Thread.sleep(15000);

        station.stop();
        stationThread.join();

        System.out.println("Simulation finished.");
    }
}