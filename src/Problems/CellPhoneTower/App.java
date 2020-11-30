package Problems.CellPhoneTower;

public class App {
    public static void main(String[] args) {
        int columns = 6;
        int rows = 6;
        Item[][] map = new Item[rows][columns];
        int propagation = 2;

        for (int row = 0; row < rows; row += 1) {
            for (int column = 0; column < columns; column += 1) {
                map[row][column] = new Item();
            }
        }

        for (int row = 0; row < rows; row += 1) {
            for (int column = 0; column < columns; column += 1) {
                Item current = map[row][column];
                current.fillTower(map, propagation, column, row);
            }
        }

        for (Item[] itemMap : map) {
            for (Item item : itemMap) {
                System.out.print(item);
            }
            System.out.println();
        }

        System.out.println("Number of fields filled " + Item.counter + " of " + rows * columns);
    }
}
