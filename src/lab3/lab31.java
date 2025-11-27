package lab3;

public class lab31 {
    public static void main(String[] args) {

        System.out.printf("%-10s %-25s%n", "n", "n!");
        System.out.println("-------------------------------------");

        long factorial = 1;

        for (int n = 1; n <= 20; n++) {
            factorial *= n;
            System.out.printf("%-10d %-25d%n", n, factorial);
        }
    }
}
