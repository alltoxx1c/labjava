package lab7;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Storage<T> {

    private final List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public List<T> getAll() {
        return new ArrayList<>(items);
    }

    public List<T> filter(Predicate<T> predicate) {
        return items.stream().filter(predicate).collect(Collectors.toList());
    }

    public Optional<T> find(Predicate<T> predicate) {
        return items.stream().filter(predicate).findFirst();
    }

    public List<T> sort(Comparator<T> comparator) {
        return items.stream().sorted(comparator).collect(Collectors.toList());
    }

    public boolean remove(Predicate<T> predicate) {
        return items.removeIf(predicate);
    }
}

class UUser {
    String name;
    int age;

    public UUser(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String toString() { return name + " (" + age + ")"; }
}

class Product {
    String title;
    double price;

    public Product(String title, double price) {
        this.title = title;
        this.price = price;
    }
    public String toString() { return title + " $" + price; }
}

public class lab72 {
    public static void main(String[] args) {

        Storage<UUser> userStorage = new Storage<>();
        userStorage.add(new UUser("Алиса", 25));
        userStorage.add(new UUser("Денис", 17));
        userStorage.add(new UUser("Женя", 30));

        System.out.println("\n=== Пользователи старше 18 ===");
        userStorage.filter(u -> u.age > 18).forEach(System.out::println);

        System.out.println("\n=== Сортировка по возрасту ===");
        userStorage.sort(Comparator.comparingInt(u -> u.age)).forEach(System.out::println);

        System.out.println("\n=== Поиск Charlie ===");
        userStorage.find(u -> u.name.equals("Charlie"))
                .ifPresent(System.out::println);


        Storage<Product> productStorage = new Storage<>();
        productStorage.add(new Product("Книга", 15));
        productStorage.add(new Product("Ноутбук", 1200));
        productStorage.add(new Product("Ручка", 2.5));

        System.out.println("\n=== Товары дешевле 20 ===");
        productStorage.filter(p -> p.price < 20).forEach(System.out::println);

        System.out.println("\n=== Сортировка по цене ===");
        productStorage.sort(Comparator.comparingDouble(p -> p.price)).forEach(System.out::println);

        System.out.println("\n=== Удаление товаров дороже 100 ===");
        productStorage.remove(p -> p.price > 100);

        productStorage.getAll().forEach(System.out::println);
    }
}

