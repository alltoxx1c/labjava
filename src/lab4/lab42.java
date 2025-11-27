package lab4;

import java.util.Random;

public class lab42 {
    public static void main(String[] args) {

        final int ROLLS = 36_000_000;
        int[] sumCount = new int[13];

        Random random = new Random();

        for (int i = 0; i < ROLLS; i++) {
            int dice1 = random.nextInt(6) + 1;  // число от 1 до 6
            int dice2 = random.nextInt(6) + 1;  // число от 1 до 6

            int sum = dice1 + dice2;
            sumCount[sum]++;
        }

        System.out.printf("%-10s %-15s %-15s%n", "Сумма", "Количество", "Вероятность");
        System.out.println("----------------------------------------------------");

        for (int sum = 2; sum <= 12; sum++) {
            double probability = (double) sumCount[sum] / ROLLS * 100.0;
            System.out.printf("%-10d %-15d %-15.5f%%%n", sum, sumCount[sum], probability);
        }
    }
}
