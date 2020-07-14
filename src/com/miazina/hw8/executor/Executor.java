package com.miazina.hw8.executor;

import com.miazina.hw8.user.User;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class Executor {
    public static void start() {
        Collection<User> collection = getUsers();

        System.out.println("\n\n1.1 Users over 40");
        System.out.println("-------");
        collection.stream()
                .filter(x -> x.getAge() > 40)
                .forEach(System.out::println);

        System.out.println("\n\n1.2 Users under 50 from Dnepr");
        System.out.println("-------");
        collection.stream()
                .filter(x -> x.getAge() < 50 && x.getCity().equals("Днепр"))
                .forEach(System.out::println);

        System.out.println("\n\n1.3 Average age of users from Lviv");
        System.out.println("-------");
        double averageAge = collection.stream()
                .filter(x -> x.getCity().equals("Львов"))
                .mapToInt(x -> x.getAge())
                .average().orElse(0);
        System.out.println(averageAge);

        System.out.println("\n\n1.4 Number of nun-capital users");
        System.out.println("-------");
        long countNotCapital = collection.stream()
                .filter(x -> !x.getCity().equals("Киев"))
                .count();
        System.out.println(countNotCapital);

        System.out.println("\n\n1.5 Three youngest users");
        System.out.println("-------");
        collection.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .limit(3)
                .forEach(System.out::println);
    }

    private static Collection<User> getUsers() {
        Collection<User> collection = Arrays.asList(
                new User("Вася", 16, "Днепр"),
                new User("Петя", 23, "Днепр"),
                new User("Елена", 42, "Луцк"),
                new User("Елена", 92, "Чернигов"),
                new User("Сергей", 5, "Киев"),
                new User("Марина", 32, "Киев"),
                new User("Иван Иванович", 69, "Львов"));

        return collection;
    }
}
