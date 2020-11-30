package Problems.CellPhoneTower;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        int dimension = 6;
        Item[][] map = new Item[dimension][dimension];
        List<Item> towers = getTowers();

        System.out.println("Number of fields filled " + fillMap(towers, map) + " of " + (dimension * dimension));

        printMap(map);
    }

    static List<Item> getTowers() {
        List<Item> towers = new ArrayList<Item>();
        Item item = new Item();
        item.propagation = 2;
        item.value = 0;

        for (int i = 0; i < 6; i++) {
            towers.add(item);
        }

        return towers;
    }

    static int fillMap(List<Item> towers, Item[][] map) {
        int towersQuantity = 0;
        boolean hasToJump = false;

        for (Item tower : towers) {
            for (int row = 0; row < map[0].length; row++) {
                for (int column = 0; column < map[1].length; column++) {
                    int leftColumnIndex = column - tower.propagation - 1;
                    int rightColumnIndex = column + tower.propagation - 1;
                    int aboveRowIndex = row - tower.propagation - 1;
                    int belowRowIndex = row + tower.propagation - 1;

                    if (map[row][column] == null && map[row][leftColumnIndex < 0 ? 0 : leftColumnIndex] == null
                            && map[row][rightColumnIndex > map[1].length - 1 ? map[1].length - 1
                                    : rightColumnIndex] == null
                            && map[aboveRowIndex < 0 ? 0 : aboveRowIndex][column] == null
                            && map[belowRowIndex > map[0].length - 1 ? map[0].length - 1
                                    : belowRowIndex][column] == null) {
                        map[row][column] = tower;
                        towersQuantity += 1;

                        if (leftColumnIndex >= 0) {
                            System.out.println("esq:" + row + " " + column);
                            Item item = new Item();
                            item.value = 1;
                            map[row][leftColumnIndex] = item;
                            towersQuantity += 1;
                        }

                        if (rightColumnIndex <= map[1].length - 1) {
                            System.out.println("dir:" + row + " " + column);
                            Item item = new Item();
                            item.value = 1;
                            map[row][rightColumnIndex] = item;
                            towersQuantity += 1;
                        }

                        if (aboveRowIndex >= 0) {
                            System.out.println("cima:" + row + " " + column);
                            Item item = new Item();
                            item.value = 1;
                            map[aboveRowIndex][column] = item;
                            towersQuantity += 1;
                        }

                        if (belowRowIndex <= map[0].length - 1) {
                            System.out.println("baixo:" + row + " " + column);
                            Item item = new Item();
                            item.value = 1;
                            map[belowRowIndex][column] = item;
                            towersQuantity += 1;
                        }

                        // hasToJump = true;

                        break;
                    } else {
                        hasToJump = false;
                    }
                }

                if (hasToJump) {
                    break;
                }
            }

            if (hasToJump) {
                break;
            }
        }

        return towersQuantity;
    }

    static void printMap(Item[][] map) {
        for (int row = 0; row < map[0].length; row++) {
            for (int column = 0; column < map[1].length; column++) {
                System.out.print(map[row][column] != null ? map[row][column].value : "-");
                System.out.print(" ");
            }

            System.out.println();
        }
    }
}
