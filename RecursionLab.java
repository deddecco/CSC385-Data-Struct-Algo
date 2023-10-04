public class RecursionLab {
    public static void main(String[] args) {
        /*System.out.println(reverseString("Hello world."));
        System.out.println(sumDigits(3919));
        System.out.println(sumPositives(new int[]{9, 0, -3, 5, 7, -6}, 0));*/
        System.out.println(solvable1DMaze(new int[]{0, 1, 0, 0, 1}, 0, 2));
        // System.out.println(targetSum(new int[]{-51, -99, 88, -89, 34, 63, -100, 77, 43, 12}, 0, 0, 33));
    }

    private static String reverseString(String s) {
        return s.length() <= 1 ? s : reverseString(s.substring(1)) + s.charAt(0);
    }

    private static int sumDigits(int num) {
        return num == 0 ? 0 : num % 10 + sumDigits(num / 10);
    }

    private static int sumPositives(int[] arr, int idx) {
        if (arr[idx] < 0 || arr[idx] > arr.length) {
            return 0;
        }
        if (arr[idx] > 0) {
            return arr[idx] + sumPositives(arr, idx + 1);
        } else {
            return sumPositives(arr, idx + 1);
        }
    }

    private static boolean solvable1DMaze(int[] maze, int idx, int jump) {
        // idx = next attempted location

        // if the index is less than 0, return false
        if (idx < 0) {
            return false;
        }

        // if you've managed to escape, return true
        if (checkEscaped(maze, idx)) {
            return true;
        }

        // if you can't move, return false
        if (checkOccupied(maze, idx)) {
            return false;
        }


        // mark the current square visited
        maze[idx] = 1;

        // check if moving forward once solves the maze
        boolean solvedForward = solvable1DMaze(maze, idx + 1, 0);
        // check if moving backward once solves the maze
        boolean solvedBack = solvable1DMaze(maze, idx - 1, 0);
        // check if jumping forward solves the maze
        boolean solvedJump = solvable1DMaze(maze, idx + jump, jump);

        // true if any of these are true, false only if all are false
        return solvedJump || solvedBack || solvedForward;
    }


    // helper method to see if a target square is occupied
    private static boolean checkOccupied(int[] maze, int idx) {
        return maze[idx] == 1;
    }

    // helper method to see if the maze has been broken out of
    private static boolean checkEscaped(int[] maze, int idx) {
        return idx >= maze.length - 1;
    }

    private static boolean targetSum(int[] arr, int idx, int sum, int target) {
        if (idx >= arr.length) {
            return sum == target;
        }

        return targetSum(arr, idx + 1, sum + arr[idx], target) || targetSum(arr, idx + 1, sum, target);
    }
}
