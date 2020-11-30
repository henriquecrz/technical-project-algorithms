package Problems.Backpack;

class App {
    public static void main(String[] args) {
        int capacity = 100;
        // int limitWeight = 100;
        Backpack backpack = new Backpack(capacity);

        // Por causa dos itens serem gerados aleatoriamente, existe a chance do
        // limite de peso ser ultrapassado pelo peso dos itens gerados, resultando
        // em uma solução que não há nenhum item, por justamente todos os itens
        // serem maiores que o limite de peso.
        for (int i = 0; i < 10; i += 1) {
            backpack.addItem(Item.generateRandomItem(capacity));
        }

        System.out.println("Brute force");
        long start = System.currentTimeMillis();
        BruteForce bruteForce = new BruteForce(backpack, capacity);
        bruteForce.solve();
        bruteForce.printSolution();
        long end = System.currentTimeMillis();
        System.out.println("Solved in: " + (end - start) + "ms");

        System.out.println("\nGreedy");
        start = System.currentTimeMillis();
        Greedy.knapsackGreProc(backpack.getWeightItems(), backpack.getValueItems(), backpack.capacity, backpack.itemList.size());
        end = System.currentTimeMillis();
        System.out.println("Solved in: " + (end - start) + "ms");

        System.out.println("\nDynamic Method");
        start = System.currentTimeMillis();
        Backpack.printBackpack(backpack.solveDynamic());
        end = System.currentTimeMillis();
        System.out.println("Solved in: " + (end - start) + "ms");
    }
}
