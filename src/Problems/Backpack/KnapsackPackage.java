package Problems.Backpack;

public class KnapsackPackage {
    private double weight;
    private double value;
    private Double cost;

    public KnapsackPackage(double weight, double value) {
        this.weight = weight;
        this.value = value;
        this.cost = new Double(value / weight);
    }

    public double getWeight() {
        return weight;
    }

    public double getValue() {
        return value;
    }

    public Double getCost() {
        return cost;
    }
}
