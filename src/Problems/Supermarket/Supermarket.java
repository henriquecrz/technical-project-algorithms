package Problems.Supermarket;

import java.util.ArrayList;
import java.util.List;

class Supermarket {
    public static List<Product> loadList(Product[] products, float limitWeight, double limitPrice) {
        List<Product> productList = new ArrayList<Product>();

        for (Product product : products) {
            if (product.weight > limitWeight || product.price > limitPrice)
                return productList;
            limitWeight -= product.weight;
            limitPrice -= product.price;
            productList.add(product);
        }
        return productList;
    }

    public static void bruteForce(Product[] products, float limitWeight, double limitPrice) {
        System.out.println("\nBrute force:");
        long start = System.currentTimeMillis();

        Product.sortBoth(products);
        List<Product> sortedBoth = loadList(products, limitWeight, limitPrice);

        long end = System.currentTimeMillis();
        System.out.println(sortedBoth.size() + " items: " + (end - start) + "ms");
    }

    public static void divideAndConquer(Product[] products, float limitWeight, double limitPrice) {
        System.out.println("\nMerge Sort:");
        long start = System.currentTimeMillis();

        SortMethods.mergeSort(products, 0, products.length - 1);
        long end = System.currentTimeMillis();
        List<Product> sortedBoth = loadList(products, limitWeight, limitPrice);

        System.out.println(sortedBoth.size() + " items: " + (end - start) + "ms");
    }

    
}
