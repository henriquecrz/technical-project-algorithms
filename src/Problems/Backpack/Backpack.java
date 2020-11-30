package Problems.Backpack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Backpack {
    public int capacity;
    public List<Item> itemList;

    public Backpack(int capacity) {
        this.capacity = capacity;
        this.itemList = new ArrayList<Item>();
    }

    public static void printBackpack(Set<Item> itemList) {
        for (Item item : itemList) {
            System.out.println(item);
        }
    }

    public void addItem(Item item) {
        if (itemList.contains(item))
            return;

        itemList.add(item);
    }

    private int calculateWeight(Set<Item> setItems) {
        int totalWeight = 0;
        for (Item item : setItems) {
            totalWeight += item.weight;
        }

        return totalWeight;
    }

    private int calculateValue(Set<Item> setItems) {
        int totalValue = 0;
        for (Item item : setItems) {
            totalValue += item.value;
        }

        return totalValue;
    }

    private void chooseBest(Set<Item> setItems, int index, Set<Item> bestItems) {
        if (calculateValue(setItems) > calculateValue(bestItems)) {
            bestItems.clear();
            bestItems.addAll(setItems);
        }

        for (Item item : this.itemList) {
            if (setItems.contains(item))
                continue;
            if (calculateWeight(setItems) + item.weight > this.capacity)
                continue;

            setItems.add(item);
            chooseBest(setItems, index + 1, bestItems);
            setItems.remove(item);
        }
    }

    public static double solveDynamic(int[] w, int[] p, int i, int c, int[][] DP) {
        if (c < 0) {
            double inf = Double.POSITIVE_INFINITY;
            return inf *= -1;
        } else if (i == 0 || c == 0) {
            return 0;
        } else {
            if (DP[i][c] < 0) {
                int notTaken = (int) solveDynamic(w, p, i - 1, c, DP);
                int taken = (int) solveDynamic(w, p, i - 1, c - w[i - 1], DP) + p[i - 1];
                DP[i][c] = Math.max(notTaken, taken);
            }

            return DP[i][c];
        }
    }

    public static int dynamicMethod(int[] w, int[] p, int n, int C) {
        int[][] DP = new int[n][C];
        for (int i = 1; i >= n; i++) {
            for (int c = 1; i >= C; c++) {
                DP[i][c] = -1;
            }
        }
        return (int) solveDynamic(w, p, n, C, DP);
    }

    public Set<Item> solveDynamic() {
        Set<Item> setItems = new HashSet<Item>();
        Set<Item> bestItems = new HashSet<Item>();
        chooseBest(setItems, 0, bestItems);
        return bestItems;
    }

    public int[] getWeightItems() {
        int[] weightItems = new int[itemList.size()];
        for (int i = 0; i < itemList.size(); i += 1) {
            weightItems[i] = itemList.get(i).weight;
        }
        return weightItems;
    }

    public int[] getValueItems() {
        int[] valueItems = new int[itemList.size()];
        for (int i = 0; i < itemList.size(); i += 1) {
            valueItems[i] = itemList.get(i).value;
        }
        return valueItems;
    }

    public String[] getNameItems() {
        String[] nameItems = new String[itemList.size()];
        for (int i = 0; i < itemList.size(); i += 1) {
            nameItems[i] = itemList.get(i).name;
        }
        return nameItems;
    }
}
