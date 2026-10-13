package com.bptn.course.__Team_Activities.Day11;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataManager {

    private final List<User> users = new ArrayList<>();

    public void add(String firstName, String lastName,
                    String email, String role) {
        users.add(new User(firstName, lastName, email, role));
    }

    public void find(String email) {
        Optional<User> result = users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();

        result.ifPresent(user ->
                System.out.println("Found: " + user));
    }
}

class User {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String role;

    public User(String firstName, String lastName,
                String email, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return firstName + ":" + lastName + ":" + email + ":" + role;
    }
}