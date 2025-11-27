package lab3;

public class lab33 {
    public static void main(String[] args) {

        final int MAX_TERMS = 200_000;
        double pi = 0.0;
        boolean found = false;
        int termReached = -1;

        System.out.printf("%-10s %-20s%n", "Terms", "Approximation of PI");
        System.out.println("----------------------------------------");

        for (int k = 0; k < MAX_TERMS; k++) {

            double term = 4.0 * ((k % 2 == 0 ? 1.0 : -1.0) / (2 * k + 1));

            pi += term;

            if ((k + 1) % 20000 == 0) {
                System.out.printf("%-10d %-20.10f%n", (k + 1), pi);
            }

            if (!found && String.format("%.5f", pi).equals("3.14159")) {
                found = true;
                termReached = k + 1;
            }
        }

        System.out.println("----------------------------------------");

        if (found) {
            System.out.println("Впервые значение, начинающееся с 3.14159, получено на шаге: " + termReached);
        } else {
            System.out.println("За первые 200 000 членов значение 3.14159 не достигнуто.");
        }
    }
}
