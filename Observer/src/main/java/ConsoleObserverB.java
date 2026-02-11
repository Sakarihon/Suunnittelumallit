public class ConsoleObserverB implements WeatherObserver {
    @Override
    public void update(int temperature) {
        System.out.println("Observer B notified. Temperature = " + temperature + "°C");
    }
}