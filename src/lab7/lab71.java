package lab7;

import java.util.*;
import java.util.stream.*;

class User {
    private final String name;
    private final int age;
    private final String city;
    private final List<String> tags;

    public User(String name, int age, String city, List<String> tags) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.tags = tags;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCity() { return city; }
    public List<String> getTags() { return tags; }

    @Override
    public String toString() {
        return name + " (" + age + ", " + city + ", " + tags + ")";
    }
}

public class lab71 {
    public static void main(String[] args) {

        List<User> users = Arrays.asList(
                new User("Алиса", 25, "Берлин", List.of("Спорт", "Музыка")),
                new User("Женя", 17, "Париж", List.of("Гейминг", "Путешествие")),
                new User("Денис", 30, "Берлин", List.of("Музыка")),
                new User("Диана", 15, "Рим", List.of("Спорт")),
                new User("Иван", 21, "Лондон", List.of("Гейминг")),
                new User("Фиона", 12, "Берлин", List.of("Путешествие")),
                new User("Григорий", 40, "Париж", List.of("Спорт", "Путешествие")),
                new User("Нина", 19, "Рим", List.of("Музыка")),
                new User("Игорь", 28, "Лондон", List.of("Спорт", "Гейминг")),
                new User("Юлия", 35, "Берлин", List.of("Музыка", "Путешествие"))
        );

        System.out.println("=== Пользователи старше 18 ===");
        users.stream()
                .filter(u -> u.getAge() > 18)
                .forEach(System.out::println);

        System.out.println("\n=== Пользователи из Берлин ===");
        users.stream()
                .filter(u -> u.getCity().equals("Берлин"))
                .forEach(System.out::println);

        System.out.println("\n=== Пользователи с тегом Спорт ===");
        users.stream()
                .filter(u -> u.getTags().contains("Спорт"))
                .forEach(System.out::println);

        System.out.println("\n=== Сортировка по возрасту ===");
        users.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .forEach(System.out::println);

        System.out.println("\n=== Сортировка по имени ===");
        users.stream()
                .sorted(Comparator.comparing(User::getName))
                .forEach(System.out::println);

        System.out.println("\n=== Сортировка по городу, затем по имени ===");
        users.stream()
                .sorted(Comparator.comparing(User::getCity)
                        .thenComparing(User::getName))
                .forEach(System.out::println);

        System.out.println("\n=== Список имён ===");
        List<String> names = users.stream()
                .map(User::getName)
                .toList();
        System.out.println(names);

        System.out.println("\n=== Длины имён ===");
        List<Integer> lengths = users.stream()
                .map(u -> u.getName().length())
                .toList();
        System.out.println(lengths);

        System.out.println("\n=== Все уникальные теги ===");
        Set<String> tags = users.stream()
                .flatMap(u -> u.getTags().stream())
                .collect(Collectors.toSet());
        System.out.println(tags);

        System.out.println("\n=== Группировка по городу ===");
        Map<String, List<User>> byCity = users.stream()
                .collect(Collectors.groupingBy(User::getCity));
        byCity.forEach((c, list) -> System.out.println(c + " -> " + list));

        System.out.println("\n=== Группировка по возрастным категориям ===");
        Map<String, List<User>> byCategory = users.stream()
                .collect(Collectors.groupingBy(u -> {
                    if (u.getAge() <= 12) return "child";
                    if (u.getAge() <= 17) return "teen";
                    return "adult";
                }));
        byCategory.forEach((cat, list) -> System.out.println(cat + " -> " + list));

        System.out.println("\n=== Суммарный возраст ===");
        int sumAge = users.stream()
                .map(User::getAge)
                .reduce(0, Integer::sum);
        System.out.println(sumAge);

        System.out.println("\n=== Средний возраст ===");
        double avgAge = users.stream()
                .collect(Collectors.averagingInt(User::getAge));
        System.out.println(avgAge);

        System.out.println("\n=== Самый старший пользователь ===");
        users.stream()
                .max(Comparator.comparingInt(User::getAge))
                .ifPresent(System.out::println);

        System.out.println("\n=== Самый молодой пользователь ===");
        users.stream()
                .min(Comparator.comparingInt(User::getAge))
                .ifPresent(System.out::println);
    }
}
