package Problems.Supermarket;

import java.util.List;

public class App {
    public static void main(String[] args) {
        float limitWeight = 50;
        double limitPrice = 50;
        Product[] products = new Product[10];
        Product.fillProducts(products);
        List<Product> byBubbleSort = Supermarket.bruteForce(products, limitWeight, limitPrice);
        List<Product> byMergeSort = Supermarket.divideAndConquer(products, limitWeight, limitPrice);

        System.out.println("Bubble Sort Items");
        Product.printList(byBubbleSort);

        System.out.println();

        System.out.println("Merge Sort Items");
        Product.printList(byMergeSort);
    }
}
