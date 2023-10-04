public class Fibonacci {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long result = fibonacci(44);
        long end = System.currentTimeMillis();

        long elapsed = end - start;

        System.out.println(result);

        System.out.println(elapsed);
    }

    private static long fibonacci(int index) {
        if (index == 0 || index == 1) {
            return 1;
        }
        return fibonacci(index - 1) + fibonacci(index - 2);
    }
}
