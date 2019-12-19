package algorithm.telepathy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BestPlanSelection {
    private static final Feature feature0 = new Feature("feature0");
    private static final Feature feature1 = new Feature("feature1");
    private static final Feature feature2 = new Feature("feature2");
    private static final Feature feature3 = new Feature("feature3");
    private static final Feature feature4 = new Feature("feature4");
    private static final Feature feature5 = new Feature("feature5");

    private static final Plan plan0 = new Plan("plan0", 1, new Feature[]{feature0});
    private static final Plan plan1 = new Plan("plan1", 2, new Feature[]{feature1});
    private static final Plan plan2 = new Plan("plan2", 3, new Feature[]{feature2});
    private static final Plan plan3 = new Plan("plan3", 4, new Feature[]{feature3});
    private static final Plan plan4 = new Plan("plan4", 5, new Feature[]{feature4});
    private static final Plan plan5 = new Plan("plan5", 6, new Feature[]{feature5});
    private static final Plan plan6 = new Plan("plan6", 2.5, new Feature[]{feature0, feature1});
    private static final Plan plan7 = new Plan("plan7", 5.5, new Feature[]{feature2, feature3});
    private static final Plan plan8 = new Plan("plan8", 9.5, new Feature[]{feature4, feature5});
    private static final Plan plan9 = new Plan("plan9", 4.5, new Feature[]{feature0, feature1, feature2});
    private static final Plan plan10 = new Plan("plan10", 12.5, new Feature[]{feature3, feature4, feature5});
    private static final Plan[] allPlans = {plan0, plan1, plan2, plan3, plan4, plan5, plan6, plan7, plan8, plan9, plan10};

    public static void main(String[] args) {
        Feature[] selectedFeatures = {feature0, feature1, feature2, feature3};
        Plan[] eligiblePlans = filterOutPlanBySelectedFeature(allPlans, selectedFeatures);
        Double lowestCost = Double.MAX_VALUE;
        List<Plan> cheapestCombination = null;
        for (int i = 1; i <= eligiblePlans.length; i++) {
            List<List<Plan>> planLists = combinationSelect(eligiblePlans, i);
            for (List<Plan> planList : planLists) {
                if (coverAllFeatures(planList, selectedFeatures) && Double.compare(costOfPlans(planList), lowestCost) < 0) {
                    lowestCost = costOfPlans(planList);
                    cheapestCombination = planList;
                }
            }
        }
        System.out.println("The cheapest combination is: ");
        cheapestCombination.stream().forEach(item -> System.out.print(" " + item.Name));
        System.out.println(" \nat the cost of " + lowestCost);
    }

    /**
     * Check whether the plan list contain all selected features
     *
     * @param planList         the combination of plans
     * @param selectedFeatures selected features
     */
    private static boolean coverAllFeatures(List<Plan> planList, Feature[] selectedFeatures) {
        List<Feature> featureList = new LinkedList<>(Arrays.asList(selectedFeatures.clone()));
        for (Plan plan : planList) {
            featureList.removeAll(Arrays.asList(plan.Features));
            if (featureList.size() == 0) {
                return true;
            }
        }
        return false;
    }

    private static Double costOfPlans(List<Plan> planList) {
        double cost = 0;
        for (Plan plan : planList) {
            cost += plan.Cost;
        }
        return cost;
    }

    /**
     * filter out the plans which at least include one selected feature
     *
     * @param allPlans         all available plans
     * @param selectedFeatures selected features
     */
    private static Plan[] filterOutPlanBySelectedFeature(Plan[] allPlans, Feature[] selectedFeatures) {
        List<Plan> planList = new ArrayList<>();
        //planList.contains();
        for (int i = 0; i < allPlans.length; i++) {
            for (int j = 0; j < selectedFeatures.length; j++) {
                if (Arrays.asList(allPlans[i].Features).contains(selectedFeatures[j])) {
                    planList.add(allPlans[i]);
                    break;
                }
            }
        }
        Plan[] planArr = new Plan[planList.size()];
        return planList.toArray(planArr);
    }

    /**
     * select combination with n elements from dataList
     *
     * @param dataList to be selected from
     * @param n        number of element to be selected
     */
    public static List<List<Plan>> combinationSelect(Plan[] dataList, int n) {
        List<List<Plan>> result = new ArrayList<>();
        combinationSelect(dataList, 0, new Plan[n], 0, result);
        return result;
    }

    /**
     * combinationSelect
     *
     * @param planArr     to be selected from
     * @param planIndex   the start index of planArr
     * @param resultArr   the result of previous (resultIndex - 1)
     * @param resultIndex result index
     * @param resultList  combination select result
     */
    private static void combinationSelect(Plan[] planArr, int planIndex, Plan[] resultArr, int resultIndex, List<List<Plan>> resultList) {
        int resultLen = resultArr.length;
        int resultCount = resultIndex + 1;
        if (resultCount > resultLen) {
            resultList.add(Arrays.asList(resultArr.clone()));
            return;
        }

        for (int i = planIndex; i < planArr.length + resultCount - resultLen; i++) {
            resultArr[resultIndex] = planArr[i];
            combinationSelect(planArr, i + 1, resultArr, resultIndex + 1, resultList);
        }
    }

    static class Feature {
        public String Name;

        public Feature(String name) {
            Name = name;
        }
    }

    static class Plan {
        public String Name;
        public double Cost;
        public Feature[] Features;

        public Plan(String name, double cost, Feature[] features) {
            Name = name;
            Cost = cost;
            Features = features;
        }
    }
}
