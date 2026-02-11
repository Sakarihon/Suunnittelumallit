public class ConsoleObserverA implements WeatherObserver {
    @Override
    public void update(int temperature) {
        System.out.println("Observer A notified. Temperature = " + temperature + "°C");
    }
}