public class ConsoleObserverC implements WeatherObserver {
    @Override
    public void update(int temperature) {
        System.out.println("Observer C notified. Temperature = " + temperature + "°C");
    }
}