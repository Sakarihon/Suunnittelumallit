public class ConcreteStrategyQuick implements Strategy {

    @Override
    public void sort(int[] list) {
        quickSort(list, 0, list.length - 1);
    }

    private void quickSort(int[] list, int low, int high) {
        if (low < high) {
            int pi = partition(list, low, high);

            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
    }

    private int partition(int[] list, int low, int high) {
        int pivot = list[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (list[j] < pivot) {
                i++;
                swap(list, i, j);
            }
        }

        swap(list, i + 1, high);
        return i + 1;
    }

    private void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}