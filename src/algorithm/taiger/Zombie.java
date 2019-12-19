package algorithm.taiger;

import java.util.ArrayList;
import java.util.List;

public class Zombie {
    public static void main(String[] args) {
        int arr[][] = {
                {1, 0, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 1, 1, 0, 0},
                {1, 1, 0, 1, 0},
                {0, 0, 0, 0, 1}
        };
        //Initialise the zombie list, should be equal with arr length
        List<Integer> zombiesList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            zombiesList.add(i);
        }
        int group = 0;

        //Find the zombie group and remove them from full list
        while (zombiesList.size() > 0) {
            group++;
            int firstItem = zombiesList.get(0);
            List<Integer> list = new ArrayList<>();
            list.add(firstItem);
            List<Integer> connectedZombies = getConnectedZombies(firstItem, arr, list);
            zombiesList.removeAll(connectedZombies);
        }

        System.out.println(group);
    }

    //Recursive getting all connected zombies
    static List<Integer> getConnectedZombies(int row, int[][] arr, List<Integer> list){
        int[] zombie = arr[row];
        for (int i = 0; i< zombie.length; i++){
            if (zombie[i] == 1 && !list.contains(i)) {
                list.add(i);
                list.addAll(getConnectedZombies(i, arr, list));
            }
        }
        return list;
    }
}


