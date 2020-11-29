package Problems.Supermarket;

public class App {
    public static void main(String[] args) {
        float limitWeight = 1000;
        double limitPrice = 1000;
        Product[] products = new Product[25000];
        Product.fillProducts(products);
        Supermarket.bruteForce(products, limitWeight, limitPrice);
        Supermarket.divideAndConquer(products, limitWeight, limitPrice);
    }
}
