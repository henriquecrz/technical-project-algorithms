package Problems.Backpack;

public class Item {
	private static int counter = 1;
	public int weight;
	public int value;
	public String name;

	public Item(int weight, int value, String name) {
		this.weight = weight;
		this.value = value;
		this.name = name;
		counter += 1;
	}

	private static int randomValue(int min, int max) {
		return (int) (Math.random() * ((max - min) + 1)) + min;
	}

	public static Item generateRandomItem(int capacity) {
		int weight = randomValue(1, capacity);
		int value = randomValue(1, capacity);
		String name = "Item " + counter;
		return new Item(weight, value, name);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object item) {
		if (this == item)
			return true;
		if (item == null)
			return false;
		if (getClass() != item.getClass())
			return false;

		Item other = (Item) item;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.name + ": weight " + this.weight + " value: " + this.value;
	}
}
