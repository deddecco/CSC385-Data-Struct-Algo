public class GaussTest {

    public static void main(String[] args) {

        long startFormula = System.nanoTime();

        long resultFormula = formula(1000000000);

        long endFormula = System.nanoTime();

        System.out.println(resultFormula);
        System.out.println((endFormula - startFormula) / 10e9);
    }

    private static long formula(int n) {

        return ((long) n * (n + 1)) / 2;
    }
}
