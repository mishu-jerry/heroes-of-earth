package com.example.heroesofearth.pojos;

public class User {

    private String email;
    private String password;

    private String profileName;
    private int age;
    private String location;

    private int profilePhotoResId = -1;

    public User(String email, String password, String profileName, int age, String location) {

        this.email = email;
        this.password = password;
        this.profileName = profileName;
        this.age = age;
        this.location = location;
        this.profilePhotoResId = profilePhotoResId;
    }

    public User(String email, String password, String profileName) {
        this.email = email;
        this.password = password;
        this.profileName = profileName;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;

        this.profileName = "undefined";
        this.age = -1;
        this.location = "undefined";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getProfilePhotoResId() {
        return profilePhotoResId;
    }

    public void setProfilePhotoResId(int profilePhotoResId) {
        this.profilePhotoResId = profilePhotoResId;
    }
}
