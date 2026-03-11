public class main {

    public static void main(String[] args) {

        int smallSize = 30;
        int largeSize = 100_000;

        int[] smallArray = generateRandomArray(smallSize);
        int[] largeArray = generateRandomArray(largeSize);

        Context context = new Context();

        context.setStrategy(new ConcreteStrategyBubble());
        testContextStrategy("Bubble Sort (small)", context, smallArray.clone());

        context.setStrategy(new ConcreteStrategyQuick());
        testContextStrategy("Quick Sort (small)", context, smallArray.clone());

        context.setStrategy(new ConcreteStrategyRadix());
        testContextStrategy("Radix Sort (small)", context, smallArray.clone());

        context.setStrategy(new ConcreteStrategyBubble());
        testContextStrategy("Bubble Sort (large)", context, largeArray.clone());

        context.setStrategy(new ConcreteStrategyQuick());
        testContextStrategy("Quick Sort (large)", context, largeArray.clone());

        context.setStrategy(new ConcreteStrategyRadix());
        testContextStrategy("Radix Sort (large)", context, largeArray.clone());
    }

    private static int[] generateRandomArray(int size) {
        java.util.Random rand = new java.util.Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(1000);
        }
        return arr;
    }

    private static void testContextStrategy(String name, Context context, int[] arr) {
        long start = System.nanoTime();
        context.executeStrategy(arr);
        long end = System.nanoTime();
        System.out.println(name + " time: " + (end - start) + " ns");
    }
}