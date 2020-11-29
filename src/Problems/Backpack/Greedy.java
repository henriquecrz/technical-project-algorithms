package Problems.Backpack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Greedy {    
    private static int capacity;
    private static int[] prices;
    private static int[] weight;
    private static int numItems;

    private static int maxValue;
    private static int currentWeight;

    // rearranged weight array
    public static int[] orderedWeights;

    // Constructors
    public Greedy(int capacity, int[] prices, int[] weight, int numItems) {
        this.capacity = capacity;
        this.numItems = numItems;
        this.prices = prices;
        this.weight = weight;
        this.orderedWeights = new int[numItems];
    }

    // Methods

    /**
     * finds the solution to the 0/1 knapsack problem
     *
     * Pre-condition: Array has a length > 0, the integers in the price and weight
     * array are positive, and the prices array has the same number of items as the
     * weights array
     *
     * Post condition: The return value is the max value with the capacity allotted.
     **/
    public static int greedy(int capacity, int[] prices, int[] weight, int numItems) {
        // checking preconditions
        assert (numItems > 0);
        assert (prices.length == weight.length);
        for (int i = 0; i < numItems; i++) {
            assert (prices[i] >= 0);
            assert (weight[i] >= 0);
        }

        // sort price list in non-ascending order
        HeapSort h = new HeapSort();
        int[] OGPrices = Arrays.copyOf(prices, numItems);

        h.sort(prices);
        // System.out.println(Arrays.toString(prices));

        // rearrange weight list accordingly
        orderedWeights = newWeights(prices, OGPrices, weight, numItems);
        // System.out.println(Arrays.toString(orderedWeights));

        // fill the knapsack using the greedy idea
        currentWeight = 0;
        int w = 0;
        while (currentWeight <= capacity && w < numItems) {
            if (orderedWeights[w] <= (capacity - currentWeight)) {
                // System.out.print(prices[w] + " ");
                currentWeight += orderedWeights[w];
                maxValue += prices[w];

            }
            w++;
        }
        return maxValue;
    }

    // used to rearrange weight array to match new, ordered, price array
    public static int[] newWeights(int[] newPrices, int[] OGPrices, int[] weight, int numItems) {
        for (int j = 0; j < numItems; j++) {
            int i = 0;
            boolean found = false;
            while (!found && i < numItems) {
                if (newPrices[j] == OGPrices[i]) {
                    OGPrices[i] = Integer.MAX_VALUE;
                    orderedWeights[j] = weight[i];
                    found = true;
                }
                i++;
            }
        }

        System.out.println();
        return orderedWeights;
    }
}