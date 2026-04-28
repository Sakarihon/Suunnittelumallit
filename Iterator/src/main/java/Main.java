import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        FibonacciSequence sequence = new FibonacciSequence();
        Iterator<Integer> it = sequence.iterator();

        for (int i = 0; i < 10; i++) {
            System.out.println(it.next());
        }
    }
}