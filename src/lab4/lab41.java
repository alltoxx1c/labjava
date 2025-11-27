package lab4;

import java.util.Random;
import java.util.Scanner;

public class lab41 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;

        while (playAgain) {

            int number = random.nextInt(1000) + 1;
            int guess;

            System.out.println("\nУгадайте число от 1 до 1000!");

            while (true) {
                System.out.print("Введите вашу догадку: ");
                guess = scanner.nextInt();

                if (guess > number) {
                    System.out.println("Слишком большое. Попробуйте снова.");
                } else if (guess < number) {
                    System.out.println("Слишком маленькое. Попробуйте снова.");
                } else {
                    System.out.println("Поздравляем! Вы угадали число!");
                    break;
                }
            }

            System.out.print("\nХотите сыграть снова? (y/n): ");
            char answer = scanner.next().toLowerCase().charAt(0);

            playAgain = (answer == 'y');
        }

        System.out.println("\nСпасибо за игру!");
    }
}

