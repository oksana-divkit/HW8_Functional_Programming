package com.miazina.hw8.tasks;

import com.miazina.hw8.model.User;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskWithUsers {
    Collection<User> usersList = Arrays.asList(
            new User("Вася", 16, "Днепр"),
            new User("Петя", 23, "Днепр"),
            new User("Елена", 42, "Луцк"),
            new User("Елена", 92, "Чернигов"),
            new User("Сергей", 5, "Киев"),
            new User("Марина", 32, "Киев"),
            new User("Иван Иванович", 69, "Львов"));

    static int countTitles = 0;

    public void printResults() {
        printTitle("Users over 40");
        getUsersByMinAge(40).forEach(System.out::println);

        printTitle("Users under 50 from Dnepr");
        getUsersByMaxAgeAndCity(50, "Днепр").forEach(System.out::println);

        printTitle("Average age of users from Lviv");
        System.out.println(getAverageAgeByCity("Львов"));

        printTitle("Number of nun-capital users");
        System.out.println(usersList.size() - getCountByCity("Киев"));

        printTitle("Three youngest users");
        getNUsersSortedByAge(3).forEach(System.out::println);
    }

    private void printTitle(String title) {
        countTitles++;

        System.out.printf("\n\n1.%d %s\n", countTitles, title);
        System.out.println("-------");
    }

    private List<User> getUsersByMinAge(int minAge) {
        return usersList.stream()
                .filter(x -> x.getAge() > minAge)
                .collect(Collectors.toList());
    }

    private List<User> getUsersByMaxAgeAndCity(int maxAge, String city) {
        return usersList.stream()
                .filter(x -> x.getAge() < maxAge && x.getCity().equals(city))
                .collect(Collectors.toList());
    }

    private double getAverageAgeByCity(String city) {
        return usersList.stream()
                .filter(x -> x.getCity().equals(city))
                .mapToInt(x -> x.getAge())
                .average()
                .orElse(0);
    }

    private long getCountByCity(String city) {
        return usersList.stream()
                .filter(x -> x.getCity().equals(city))
                .count();
    }

    private List<User> getNUsersSortedByAge(int count) {
        return usersList.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .limit(count)
                .collect(Collectors.toList());
    }
}
