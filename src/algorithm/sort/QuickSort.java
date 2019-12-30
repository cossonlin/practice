package algorithm.sort;

public class QuickSort {

    static void printArray(int[] array) {
        for (int n : array) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {5, 12, 24, 7, 13, 8};
        int n = arr.length;

        QuickSort qs = new QuickSort();
        qs.sort(arr, 0, n - 1);

        System.out.println("sorted array");
        printArray(arr);
    }

    int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                if (j > i) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }

            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = pivot;
        arr[high] = temp;

        return i + 1;
    }

    void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }
}
