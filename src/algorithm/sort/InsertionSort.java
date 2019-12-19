package algorithm.sort;

public class InsertionSort {

    void sort(int[] array) {
        for(int i=1; i<array.length;i++){
            int insertValue = array[i];

            int j = i-1;
            while (j>=0 && insertValue<array[j]){
                array[j+1] = array[j];
                j--;
            }
            array[j+1]= insertValue;
        }
    }

    void print(int[] array){
        for(int i: array){
            System.out.print(i + " ");
        }
    }

    public static void main(String[] agrs) {
        int[] array = new int[]{4,8,19,1,7};
        InsertionSort is = new InsertionSort();
        is.sort(array);
        is.print(array);
    }
}
