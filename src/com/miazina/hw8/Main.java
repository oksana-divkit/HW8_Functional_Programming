package com.miazina.hw8;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Collection<User> collection = Arrays.asList(
                new User("Вася", 16, "Днепр"),
                new User("Петя", 23, "Днепр"),
                new User("Елена", 42, "Луцк"),
                new User("Елена", 92, "Чернигов"),
                new User("Сергей", 5, "Киев"),
                new User("Марина", 32, "Киев"),
                new User("Иван Иванович", 69, "Львов"));

        System.out.println("-------");
        collection.stream()
                .filter(x -> x.getAge() > 40)
                .forEach(System.out::println);

        System.out.println("-------");
        collection.stream()
                .filter(x -> x.getAge() < 50 && x.getCity().equals("Днепр"))
                .forEach(System.out::println);

        System.out.println("-------");
        double averageAge = collection.stream()
                .filter(x -> x.getCity().equals("Львов"))
                .mapToInt(x -> x.getAge())
                .average().orElse(0);
        System.out.println(averageAge);

        System.out.println("-------");
        long countNonCapital = collection.stream()
                .filter(x -> !x.getCity().equals("Киев"))
                .count();
        System.out.println(countNonCapital);

        System.out.println("-------");
        collection.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .limit(3)
                .forEach(System.out::println);

        System.out.println("-------");
        for (User user : collection) {
            System.out.println(user.getName());
        }
    }
}