package Problems.Backpack;

import java.util.Arrays;
import java.util.Comparator;

public class Backpack {
    // brute force

    // greedy
    public static double knapSackGreedy(int capacity, int[] items, int[] weight) {
        ItemValue[] iVal = new ItemValue[weight.length];

        for (int i = 0; i < weight.length; i++) {
            iVal[i] = new ItemValue(weight[i], items[i], i);
        }

        // sorting items by value;
        Arrays.sort(iVal, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue o1, ItemValue o2) {
                return o2.cost.compareTo(o1.cost);
            }
        });

        double totalValue = 0d;

        for (ItemValue i : iVal) {

            int curWt = (int) i.wt;
            int curVal = (int) i.val;

            if (capacity - curWt >= 0) {
                // this weight can be picked while
                capacity = capacity - curWt;
                totalValue += curVal;
            } else {
                // item cant be picked whole
                double fraction = ((double) capacity / (double) curWt);
                totalValue += (curVal * fraction);
                capacity = (int) (capacity - (curWt * fraction));
                break;
            }
        }

        return totalValue;
    }

    static class ItemValue {
        Double cost;
        double wt, val, ind;

        public ItemValue(int wt, int val, int ind) {
            this.wt = wt;
            this.val = val;
            this.ind = ind;
            cost = (double) val / (double) wt;
        }
    }

    //#region dynamic programming
    public static int knapSackDynamic(Item[] items, int capacity) {
        int[][] table = new int[items.length + 1][capacity + 1];

        for (int i = 1; i <= items.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (items[i - 1].getWeight() <= j) {
                    table[i][j] = Math.max(items[i - 1].getValue() + table[i - 1][j - items[i - 1].getWeight()],
                            table[i - 1][j]);
                } else {
                    table[i][j] = table[i - 1][j];
                }
            }
        }

        return table[items.length][capacity];
    }
    // #endregion
}
