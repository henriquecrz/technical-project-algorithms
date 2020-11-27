package Problems.Backpack;

public class Item {
    private int _value;
    private int _weight;

    public Item(int value, int weight) {
        this._value = value;
        this._weight = weight;
    }

    public int getValue() {
        return _value;
    }

    public int getWeight() {
        return _weight;
    }

    @Override
    public String toString() {
        return "Value = " + this._value + "\nWeight = " + this._weight;
    }
}
