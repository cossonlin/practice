package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationAndPermutation {

    private static List<List<String>> resultList = new ArrayList<>();

    public static void main(String[] args) {
        String[] dataList = {"a", "b", "c", "d", "e"};

        System.out.println("-------------combination-------------");
        resultList = combinationSelect(dataList, 3);
        for (List<String> result : resultList) {
            System.out.println(result);
        }
        resultList.clear();

        System.out.println("-------------permutation-------------");
        resultList = permute(dataList);
        for (List<String> result : resultList) {
            System.out.println(result);
        }
    }

    private static boolean[] used;

    private static List<List<String>> permute(String[] dataList) {
        if (dataList.length == 0) {
            return resultList;
        }

        used = new boolean[dataList.length];
        List<String> preList = new ArrayList<>();
        generatePermutation(dataList, 0, preList);

        return resultList;
    }

    private static void generatePermutation(String[] dataList, int index, List<String> preList) {
        if (index == dataList.length) {
            resultList.add(new ArrayList<>(preList));
            return;
        }

        for (int i = 0; i < dataList.length; i++) {
            if (!used[i]) {
                preList.add(dataList[i]);
                used[i] = true;
                generatePermutation(dataList, index + 1, preList);
                preList.remove(preList.size() - 1);
                used[i] = false;
            }
        }
        return;
    }

    /**
     * select combination with n elements from dataList
     *
     * @param dataList to be selected from
     * @param n        number of element to be selected
     */
    public static List<List<String>> combinationSelect(String[] dataList, int n) {
        List<List<String>> result = new ArrayList<>();
        combinationSelect(dataList, 0, new String[n], 0, result);
        return result;
    }

    /**
     * combinationSelect
     *
     * @param dataArray   to be selected from
     * @param index       the start index of planArr
     * @param resultArr   the result of previous (resultIndex - 1)
     * @param resultIndex result index
     * @param resultList  combination select result
     */
    private static void combinationSelect(String[] dataArray, int index, String[] resultArr, int resultIndex, List<List<String>> resultList) {
        int resultLen = resultArr.length;
        int resultCount = resultIndex + 1;
        if (resultCount > resultLen) {
            resultList.add(Arrays.asList(resultArr.clone()));
            return;
        }

        for (int i = index; i < dataArray.length + resultCount - resultLen; i++) {
            resultArr[resultIndex] = dataArray[i];
            combinationSelect(dataArray, i + 1, resultArr, resultIndex + 1, resultList);
        }
    }
}
