import static java.lang.Math.max;
import static java.lang.Math.random;

public class Islands {


    public static void main(String[] args) {
        int[][] map = new int[200][200];
        int maxValue = 100;
        int dropChance = 25;
        randomIslands(map, maxValue, dropChance);
        //printIslands(map);

        long start = System.currentTimeMillis();
        System.out.println("There is an island with a value of " + maxValueIsland(map));
        long end = System.currentTimeMillis();
        long elapsed = end - start;
        System.out.println(elapsed);
    }

    // for every position, calculate the value of its island, and store either that value or
    // the previously-stored biggest value, whichever is bigger. after doing this calculation for the whole grid,
    public static int maxValueIsland(int[][] map) {

        // array of booleans of the same size as the map initially all false to be used for
        // tracking which positions in the grid have been visited so far
        boolean[][] visited = new boolean[map.length][map[0].length];

        // the maximum value of the islands is initially the value at [0][0]
        // then it gets updated by a recursive call made for every cell in
        // the grid, and the final return value is the value of maxValue at the conclusion of the loop
        int maxValue = map[0][0];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                maxValue = max(getIslandValue(map, visited, i, j), maxValue);
            }
        }


        return maxValue;
    }

    // find the value of the island of which the position is a member
    public static int getIslandValue(int[][] map, boolean[][] visited, int row, int col) {
        int islandValue;


        // only consider making recursive calls for non-zero grid values
        if (map[row][col] != 0) {
            islandValue = map[row][col];
            visited[row][col] = true;
            // north neighbor
            if ((row - 1) >= 0 && !visited[row - 1][col]) {
                islandValue += getIslandValue(map, visited, row - 1, col);
            }// south neighbor
            if ((row + 1) <= (map.length - 1) && !visited[row + 1][col]) {
                islandValue += getIslandValue(map, visited, row + 1, col);
            }// west neighbor
            if ((col - 1) >= 0 && !visited[row][col - 1]) {
                islandValue += getIslandValue(map, visited, row, col - 1);
            }// east neighbor
            if ((col + 1) <= (map[0].length - 1) && !visited[row][col + 1]) {
                islandValue += getIslandValue(map, visited, row, col + 1);
            }


            // the total value of an island is the value of a non-zero cell,
            // plus the value of the non-zero cells to its north,
            // plus the value of the non-zero cells to its south,
            // plus the value of the non-zero cells to its east,
            // plus the value of the non-zero cells to its west, applied recursively
            return islandValue;
        }

        // if none of the recursive calls are ever triggered, 0 will be returned
        return 0;
    }


    //This takes a 2D array of integers and will randomly decide
    // whether to place a value at a location.
    // maxPossibleValue is the maximum possible value.
    // The value is random between 1 and maxPossibleValue.
    // Chance is the percentage a non-zero value
    // gets placed at a location.
    // All other locations will have a zero.
    public static void randomIslands(int[][] map, int maxPossibleValue, int chance) {
        if (maxPossibleValue <= 0) {
            throw new IllegalArgumentException("The max possible value must be a positive integer.");
        }
        if (chance > 100 || chance < 0) {
            throw new IllegalArgumentException("The chance of money drop must be between 0 <= p <= 100");
        }
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[r].length; c++) {
                int possible = (int) (random() * 100) + 1;
                if (possible <= chance) {
                    map[r][c] = (int) (random() * maxPossibleValue) + 1;
                }
            }
        }
    }

    public static void printIslands(int[][] island) {
        int maxDigits = getMaxDigits(island);
        for (int[] ints : island) {
            for (int value : ints) {
                String s = "%" + maxDigits + "d";
                if (value != 0) {
                    System.out.print(" |");
                    System.out.printf(s, value);
                    System.out.print("| ");
                } else {
                    System.out.print("  ");
                    System.out.printf("%" + maxDigits + "s", "-");
                    System.out.print("  ");
                }
            }
            System.out.println(" ");
        }
    }

    private static int getMaxDigits(int[][] arr) {
        int maxDigitSize = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                int value = anInt;
                int digits = 0;
                while (value != 0) {
                    digits += 1;
                    value /= 10;
                }
                if (digits > maxDigitSize) {
                    maxDigitSize = digits;
                }
            }
        }
        return maxDigitSize;
    }
}