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
        permute(Arrays.asList(dataList), new ArrayList<String>());
        for (List<String> result : resultList) {
            System.out.println(result);
        }
    }

    private static void permute(List<String> remainingList, ArrayList<String> result) {
        if (remainingList.isEmpty()) {
            resultList.add((ArrayList) result.clone());
            return;
        }
        for (String remaining : remainingList) {
            ArrayList<String> leftStrings = new ArrayList<>(remainingList);
            leftStrings.remove(remaining);
            ArrayList<String> clone = new ArrayList<>(result);
            clone.add(remaining);
            permute(leftStrings, clone);
        }
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
