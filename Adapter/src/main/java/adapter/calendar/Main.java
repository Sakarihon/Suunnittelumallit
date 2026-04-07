package adapter.calendar;

public class Main {

    public static void main(String[] args) {

        NewDateInterface date = new CalendarToNewDateAdapter();

        date.setDay(3);
        date.setMonth(4);
        date.setYear(2026);

        System.out.println("Initial date:");
        printDate(date);

        date.advanceDays(10);
        System.out.println("\nAfter 10 days:");
        printDate(date);

        date.advanceDays(30);
        System.out.println("\nAfter 30 more days:");
        printDate(date);
    }

    private static void printDate(NewDateInterface date) {
        System.out.println(
                date.getDay() + "." +
                        date.getMonth() + "." +
                        date.getYear()
        );
    }
}