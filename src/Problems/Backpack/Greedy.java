package Problems.Backpack;

import java.util.Arrays;
import java.util.Comparator;

public class Greedy {
    private static int maxValue;
    private static int currentWeight;

    public static int[] orderedWeights;

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

    public static void knapsackGreProc(int W[], int V[], int capacity, int n) {
        KnapsackPackage[] packs = new KnapsackPackage[n];

        for (int i = 0; i < n; i++) {
            packs[i] = new KnapsackPackage(W[i], V[i]);
        }

        Arrays.sort(packs, new Comparator<KnapsackPackage>() {
            @Override
            public int compare(KnapsackPackage kPackA, KnapsackPackage kPackB) {
                return kPackB.getCost().compareTo(kPackA.getCost());
            }
        });

        int remain = capacity;
        int i = 0;
        boolean stopProc = false;

        while (!stopProc) {            
            if (packs[i].getWeight() <= remain) {
                remain -= packs[i].getWeight();

                System.out.println("Item " + i + " - Weight " + packs[i].getWeight() + " - Value " + packs[i].getValue());

                i++;
            }
            else {
                System.out.println("peso: " + packs[i].getWeight() + " - remain: " + remain);
                stopProc = true;
            }
        }
    }
}
