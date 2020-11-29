package Problems.Backpack;

class App {
    public static void main(String[] args) {
        int items = 10;
        int limitWeight = 100;
        Backpack backpacks = new Backpack(items, limitWeight);

        // Por causa dos itens serem gerados aleatoriamente, existe a chance do
        // limite de peso ser ultrapassado pelo peso dos itens gerados, resultando
        // em uma solução que não há nenhum item, por justamente todos os itens
        // serem maiores que o limite de peso.
        for (int i = 0; i < items; i += 1) {
            backpacks.addItem(Item.generateRandomItem(items));
        }

        System.out.println("Brute force");
        long start = System.currentTimeMillis();
        BruteForce bruteForce = new BruteForce(backpacks, limitWeight);
        bruteForce.solve();
        bruteForce.printSolution();
        long end = System.currentTimeMillis();
        System.out.println("Solved in: " + (end - start) + "ms");

        System.out.println("\nDynamic Method");
        start = System.currentTimeMillis();
        Backpack.printBackpack(backpacks.solveDynamic());
        end = System.currentTimeMillis();
        System.out.println("Solved in: " + (end - start) + "ms");
    }
}
