package Problems.CellPhoneTower;

public class Item {
    public int value;
    static public int counter;

    public Item() {
        this.value = 0;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void fillTower(Item[][] map, int propagation, int column, int row) {
        if (this.value != 0)
            return;

        for (int i = column - propagation; i < column + propagation; i += 1) {
            for (int j = row - propagation; j < row + propagation; j += 1) {
                if (i < 0 || j < 0 || i > 5 || j > 5)
                    continue;
                if (row - 1 >= 0 && map[row - 1][column].value > 0)
                    continue;
                if (row + 1 <= 5 && map[row + 1][column].value > 0)
                    continue;
                if (column - 1 >= 0 && map[row][column - 1].value > 0)
                    continue;
                if (column + 1 <= 5 && map[row][column + 1].value > 0)
                    continue;

                map[row][column].setValue(1);
                counter++;

                if (row - 1 >= 0) {
                    map[row - 1][column].setValue(2);
                    counter++;
                }

                if (row + 1 <= 5) {
                    map[row + 1][column].setValue(2);
                    counter++;
                }

                if (column - 1 >= 0) {
                    map[row][column - 1].setValue(2);
                    counter++;
                }

                if (column + 1 <= 5) {
                    map[row][column + 1].setValue(2);
                    counter++;
                }                
            }
        }

        return;
    }

    @Override
    public String toString() {
        return " " + this.value;
    }
}
