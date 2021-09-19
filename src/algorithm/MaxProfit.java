package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxProfit {

	/*
	 * [1,2,7,6,8,9,5,8,3] -> 8.5
	 * [6,10,7,6,8,9,5,8,3] -> 4
	 * [6,9,7,6,8,9,5,8,3] -> 3
	 * */
	public static void main(String[] args) {
		double[] a = new double[]{10, 2, 7, 6, 8, 9, 5, 8, 3};
		//double maxProfit = profitWithoutInterest(a);
		//System.out.println(maxProfit);
		double[] b = new double[]{6, 10, 7, 6, 8, 9, 5, 8, 3};
		System.out.println(profitWithInterest(b));
		double[] c = new double[]{6, 10, 7, 6, 8, 9, 5, 8, 9};
		System.out.println(profitWithInterest(c));
	}

	private static double profitWithoutInterest(double[] priceArray) {
		double minPrice = priceArray[0];
		double profit = 0;
		for (int i = 1; i < priceArray.length; i++) {
			if (priceArray[i] < minPrice) {
				minPrice = priceArray[i];
			} else if (priceArray[i] - minPrice > profit) {
				profit = priceArray[i] - minPrice;
			}
		}
		return profit;
	}

	private static double profitWithInterest(double[] priceArray) {
		Map<Integer, Integer> tempResult = new HashMap<>();
		List<Double> doubleList = new ArrayList<>();
		double minPrice = priceArray[0];
		double profit = 0;
		int tempBuyDay = 0;
		int buyDay = 0;
		int sellDay = 0;
		for (int i = 1; i < priceArray.length; i++) {
			if (minPrice > priceArray[i]) {
				minPrice = priceArray[i];
				tempBuyDay = i;
			} else if (priceArray[i] - minPrice > profit) {
				profit = priceArray[i] - minPrice;
				sellDay = i;
				buyDay = tempBuyDay;
				tempResult.clear();
				tempResult.put(buyDay, sellDay);
			} else if (priceArray[i] - minPrice == profit) {
				sellDay = i;
				buyDay = tempBuyDay;
				tempResult.put(buyDay, sellDay);
			}
		}

		tempResult.forEach((k, v) -> doubleList.add(priceArray[v] - priceArray[k] + priceArray[k] * 0.1 * (v - k)));

		return doubleList.stream().max(Double::compareTo).orElse(Double.valueOf(0));

		/*tempResult.entrySet().stream().map((key, value) -> {
				return priceArray[value] - priceArray[key]});

		return profit + (sellDay - buyDay) * 0.1 * priceArray[buyDay];*/
	}

}
