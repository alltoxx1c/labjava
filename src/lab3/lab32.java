package lab3;

import java.util.Scanner;

public class lab32 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double totalCost = 0.0;

        System.out.println("Введите номер товара (1–5) или 0 для завершения:");

        while (true) {
            System.out.print("Номер товара: ");
            int product = input.nextInt();

            if (product == 0) {
                break;
            }

            System.out.print("Количество проданных единиц: ");
            int quantity = input.nextInt();

            double price = 0.0;

            switch (product) {
                case 1 -> price = 2.98;
                case 2 -> price = 4.50;
                case 3 -> price = 9.98;
                case 4 -> price = 4.49;
                case 5 -> price = 6.87;
                default -> {
                    System.out.println("Ошибка: такого товара нет!");
                    continue;
                }
            }

            double itemTotal = price * quantity;
            totalCost += itemTotal;

            System.out.printf("Стоимость по товару: %.2f%n%n", itemTotal);
        }

        // Итоговый результат
        System.out.printf("Общая стоимость всех товаров: $%.2f%n", totalCost);
    }
}
