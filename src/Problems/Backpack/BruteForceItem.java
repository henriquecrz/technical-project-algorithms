package Problems.Backpack;

import java.util.Comparator;

public class BruteForceItem {
    public static Comparator<BruteForceItem> byLabel() {
        return new Comparator<BruteForceItem>() {
            public int compare(BruteForceItem i1, BruteForceItem i2) {
                return i1.label - i2.label;
            }
        };
    }

    public static Comparator<BruteForceItem> byRatio() {
        return new Comparator<BruteForceItem>() {
            public int compare(BruteForceItem i1, BruteForceItem i2) {
                return Double.compare(i2.getRatio(), i1.getRatio());
            }
        };
    }

    public int label;
    public double value;
    public double weight;

    public double getRatio() {
        return value / weight;
    }
}
