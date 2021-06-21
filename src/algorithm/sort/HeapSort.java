package algorithm.sort;

public class HeapSort {
	public static void main(String[] args) {
		int[] arr = {5, 12, 24, 7, 13, 8};

		HeapSort hs = new HeapSort();
		hs.sort(arr);

		System.out.println("sorted array");
		printArray(arr);

	}

	static void printArray(int[] array) {
		for (int n : array) {
			System.out.print(n + " ");
		}
		System.out.println();
	}

	private void sort(int[] arr) {
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}

		for (int i = n - 1; i > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			heapify(arr, i, 0);
		}
	}

	private void heapify(int[] arr, int size, int root) {
		int largest = root;
		int left = 2 * root + 1;
		int right = 2 * root + 2;

		if (left < size && arr[left] > arr[largest]) {
			largest = left;
		}
		if (right < size && arr[right] > arr[largest]) {
			largest = right;
		}

		if (largest != root) {
			//swap
			int temp = arr[largest];
			arr[largest] = arr[root];
			arr[root] = temp;

			heapify(arr, size, largest);
		}
	}
}
