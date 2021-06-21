package algorithm;

public class BlockOne {

	/*
	 * [1,2,7,6,8,9,5,8,3] -> 8.5
	 * [6,10,7,6,8,9,5,8,3] -> 4
	 * [6,9,7,6,8,9,5,8,3] -> 3
	 * */
	public static void main(String[] args) throws Exception {
		double[] a = new double[]{1, 2, 7, 6, 8, 9, 5, 8, 3};
		double maxProfit = profit(a);
		System.out.println(maxProfit);
		/*double[] b = new double[]{6,10,7,6,8,9,5,8,3};
		maxProfit = profit(b);
		System.out.println(maxProfit);
		double[] c = new double[]{5,4,3,2};
		maxProfit = profit(c);
		System.out.println(maxProfit);*/
	}

	private static double profit(double[] priceArray) {
		double minPrice = priceArray[0];
		double profit = 0;
		int buyDay = 0;
		int sellDay = 0;
		for (int i = 0; i < priceArray.length; i++) {
			if (sellDay > buyDay) {
				profit = priceArray[sellDay] - priceArray[buyDay] + priceArray[buyDay] * 0.1 * (sellDay - buyDay);
			}
			if (minPrice >= priceArray[i]) {
				minPrice = priceArray[i];
				buyDay = i;
			} else {
				double tempProfit = priceArray[i] - minPrice;
				if (tempProfit > profit) {
					profit = tempProfit;
					sellDay = i;
				}
			}
		}
		return profit;
	}

}
