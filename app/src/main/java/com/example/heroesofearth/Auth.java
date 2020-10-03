
/**
 * NOTE:
 * This is a DEMO implementation, NOT for production.
 * Data is not persistent if the app session is destroyed.
 */

package com.example.heroesofearth;

import com.example.heroesofearth.pojos.User;

import java.util.ArrayList;

public class Auth {

    public static final String DEMO_EMAIL = "demo-email@domain";
    public static final String DEMO_PASS = "demo-pass";

    private static User currentUser;

    private static ArrayList<User> users;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static boolean login(String email, String password) {
        if (users != null) {
            for (User u : users) {
                if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                    currentUser = u;
                    // Logged In successfully
                    return true;
                }
            }
        }
        // Login failed
        return false;
    }

    public static boolean signUp(User user) {
        if (users != null) {
            for (User u : users) {
                if (u.getEmail().equals(user.getEmail())) {

                    // User already exists
                    return false;
                }
            }
        }

        if (users == null) users = new ArrayList<>();

        users.add(user);
        // Signed Up successfully
        return true;
    }

    public static User getDemoUser() {
        User demoUser = new User(DEMO_EMAIL, DEMO_PASS, "Demo User", 24,
                "Bangladesh");

        return demoUser;
    }

}
