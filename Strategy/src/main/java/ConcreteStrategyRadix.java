public class ConcreteStrategyRadix implements Strategy {

    @Override
    public void sort(int[] list) {
        int max = list[0];
        for (int v : list) {
            if (v > max) {
                max = v;
            }
        }

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(list, exp);
        }
    }

    private void countSort(int[] list, int exp) {
        int n = list.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            count[(list[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int index = (list[i] / exp) % 10;
            output[count[index] - 1] = list[i];
            count[index]--;
        }

        for (int i = 0; i < n; i++) {
            list[i] = output[i];
        }
    }
}