import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    private final List<WeatherObserver> observers = new ArrayList<>();

    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    protected void notifyObservers(int temperature) {
        for (WeatherObserver observer : observers) {
            observer.update(temperature);
        }
    }
}