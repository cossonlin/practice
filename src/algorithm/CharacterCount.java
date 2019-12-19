package algorithm;

public class CharacterCount {
    static int shortestLength(int[] array, int target){

        for(int length = 1; length<=array.length; length++){
            if(checkExist(array, target, length)){
                return length;
            }
        }
        return 0;
    }

    static boolean checkExist(int[] array, int target, int length){
        int temp = 0;
        for(int j=0; j<length; j++){
            temp = array[j] + temp;
        }
        if(temp==target) {
            return true;
        }
        for(int i=1; i<=array.length-length; i++){
            temp = temp + array[i+length-1] - array[i-1];
            if (temp==target){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,2};
        int sum = 13;
        int length = shortestLength(array, sum);
        System.out.print(length);
    }
}
