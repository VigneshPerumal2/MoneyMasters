package model;

import directories.TransactionDirectory;


import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private int age;
    private String gender, emailId, password, location;
    private long phoneNumber;

    private ArrayList<Account> userAccounts;

    private TransactionDirectory transactionDirectory;

    private Budget budget;

    public User(String name, int age, String gender, String emailId, String password, String location, long phoneNumber, ArrayList<Account> userAccounts, Budget budget, TransactionDirectory transactionDirectory) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.emailId = emailId;
        this.password = password;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.userAccounts = userAccounts;
        this.budget = budget;
        this.transactionDirectory=transactionDirectory;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", emailId='" + emailId + '\'' +
                ", password='" + password + '\'' +
                ", location='" + location + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", userAccounts=" + userAccounts +
                ", transactionDirectory=" + transactionDirectory +
                ", budget=" + budget +
                '}';
    }

    public ArrayList<Account> getUserAccounts() {
        return userAccounts;
    }

    public void setUserAccounts(ArrayList<Account> userAccounts) {
        this.userAccounts = userAccounts;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
