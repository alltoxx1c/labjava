package lab4;

import java.util.Scanner;

public class lab43 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean[] seats = new boolean[10]; // false = свободно, true = занято

        while (true) {

            if (isPlaneFull(seats)) {
                System.out.println("Все места заняты. Следующий рейс отправляется через 3 часа.");
                break;
            }

            System.out.println("\nПожалуйста, введите 1 для бизнес-класса.");
            System.out.println("Пожалуйста, введите 2 для эконом-класса.");
            System.out.print("Ваш выбор: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                if (!assignBusiness(seats, scanner)) {
                    break;
                }
            } else if (choice == 2) {
                if (!assignEconomy(seats, scanner)) {
                    break;
                }
            } else {
                System.out.println("Некорректный ввод, попробуйте снова.");
            }
        }
    }

    public static boolean assignBusiness(boolean[] seats, Scanner scanner) {

        for (int i = 0; i < 5; i++) {
            if (!seats[i]) {
                seats[i] = true;
                System.out.println("Ваше место в бизнес-классе: " + (i + 1));
                return true;
            }
        }

        System.out.println("Бизнес-класс заполнен. Желаете место в эконом-классе? (y/n)");
        char answer = scanner.next().toLowerCase().charAt(0);

        if (answer == 'y') {
            return assignEconomy(seats, scanner);
        } else {
            System.out.println("Следующий рейс отправляется через 3 часа.");
            return false;
        }
    }

    public static boolean assignEconomy(boolean[] seats, Scanner scanner) {

        for (int i = 5; i < 10; i++) {
            if (!seats[i]) {
                seats[i] = true;
                System.out.println("Ваше место в эконом-классе: " + (i + 1));
                return true;
            }
        }

        System.out.println("Эконом-класс заполнен. Желаете место в бизнес-классе? (y/n)");
        char answer = scanner.next().toLowerCase().charAt(0);

        if (answer == 'y') {
            return assignBusiness(seats, scanner);
        } else {
            System.out.println("Следующий рейс отправляется через 3 часа.");
            return false;
        }
    }

    public static boolean isPlaneFull(boolean[] seats) {
        for (boolean seat : seats) {
            if (!seat) return false;
        }
        return true;
    }
}
