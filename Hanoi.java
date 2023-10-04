public class Hanoi {


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        hanoi(25, 'a', 'b', 'c');
        long end = System.currentTimeMillis();

        long elapsed = end - start;
        System.out.println(elapsed);
    }

    private static void hanoi(int disks, char from, char via, char to) {
        if (disks == 1) {
            System.out.println("moving disk from " + from + " to " + to);
        } else {
            hanoi(disks - 1, from, to, via);
            System.out.println("moving disk from " + from + " to " + to);
            hanoi(disks - 1, via, from, to);
        }
    }
}
