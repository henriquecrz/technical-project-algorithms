package Problems.Supermarket;

public class Product {
    private static int counter = 0;
    public double price;
    public String name;
    public float weight;
    public int id;

    public Product(double price, String name, float weight) {
        this.id = counter;
        this.price = price;
        this.name = name;
        this.weight = weight;
        counter += 1;
    }

    private static double randomValue(int min, int max) {
        return (Math.random() * ((max - min) + 1)) + min;
    }

    public static Product[] fillProducts(Product[] products) {
        for (int i = 0; i < products.length; i += 1) {
            double randomPrice = randomValue(10, 20);
            float randomWeight = (float) randomValue(10, 20);
            String productName = "Produto " + i;
            products[i] = new Product(randomPrice, productName, randomWeight);
        }

        return products;
    }

    public float compareBoth() {
        return this.weight + (float) this.price;
    }

    public static void sortBoth(Product[] products) {
        int n = products.length;
        Product temp;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (products[j - 1].compareBoth() > products[j].compareBoth()) {
                    temp = products[j - 1];
                    products[j - 1] = products[j];
                    products[j] = temp;
                }
            }
        }
    }
}
