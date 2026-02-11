import java.util.Random;

public class WeatherStation extends Observable implements Runnable {

    private int temperature;
    private final int MIN_TEMP = -30;
    private final int MAX_TEMP = 40;
    private final Random random = new Random();
    private boolean running = true;

    public WeatherStation() {
        this.temperature = random.nextInt(MAX_TEMP - MIN_TEMP + 1) + MIN_TEMP;
        System.out.println("Initial temperature: " + temperature + "°C");
    }

    public int getTemperature() {
        return temperature;
    }

    private void updateTemperature() {
        int change = random.nextBoolean() ? 1 : -1;
        temperature += change;

        if (temperature > MAX_TEMP) temperature = MAX_TEMP;
        if (temperature < MIN_TEMP) temperature = MIN_TEMP;

        notifyObservers(temperature);
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            updateTemperature();

            try {
                Thread.sleep((random.nextInt(5) + 1) * 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
