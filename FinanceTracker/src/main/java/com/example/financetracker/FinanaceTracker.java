package com.example.financetracker;

import directories.TransactionDirectory;
import directories.UserDirectory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Account;
import model.Transaction;
import model.User;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FinanaceTracker extends Application {

    static UserDirectory userDirectory ;
    static User user;



    @Override
    public void start(Stage stage) throws IOException {
        showLogInController(stage);

    }

    private void showLogInController(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
        SignInController controller = new SignInController(userDirectory,user,stage);

        loader.setController(controller);

        Parent root = loader.load();


        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Money Manager");
        stage.show();
    }

    private static TransactionDirectory loadTransactionData(){

        TransactionDirectory  transactionDirectory = new TransactionDirectory();

// create a new Account object with some sample values
        Account account2 = new Account("Checking Account", "Checking", 2500.0, "Paycheck deposit");

// create a SimpleDateFormat object to parse date strings
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

// create an array of sample transaction data
        String[][] transactionData = {
                {"2023-01-01", "Food", "Bought groceries for the week", "85.23", "Expense"},
                {"2023-01-02", "Transportation", "Filled up gas", "45.12", "Expense"},
                {"2023-01-03", "Culture", "Went to a museum", "22.50", "Expense"},
                {"2023-01-04", "Apparel", "Bought new shoes", "89.99", "Expense"},
                {"2023-01-05", "Household", "Bought cleaning supplies", "25.00", "Expense"},
                {"2023-01-06", "Social Life", "Had dinner with friends", "67.89", "Expense"},
                {"2023-01-07", "Beauty", "Bought skincare products", "45.00", "Expense"},
                {"2023-01-08", "Transportation", "Filled up gas", "50.00", "Expense"},
                {"2023-01-09", "Food", "Bought groceries for the week", "92.75", "Expense"},
                {"2023-01-10", "Culture", "Went to a concert", "75.00", "Expense"},
                {"2023-01-11", "Apparel", "Bought new clothes", "100.00", "Expense"},
                {"2023-01-12", "Social Life", "Had drinks with colleagues", "38.00", "Expense"},
                {"2023-01-13", "Household", "Bought new curtains", "70.00", "Expense"},
                {"2023-01-14", "Beauty", "Bought makeup products", "30.00", "Expense"},
                {"2023-01-15", "Transportation", "Filled up gas", "55.00", "Expense"},
                {"2023-01-16", "Food", "Bought groceries for the week", "78.32", "Expense"},
                {"2023-01-17", "Culture", "Went to the movies", "20.00", "Expense"},
                {"2023-01-18", "Apparel", "Bought new jeans", "50.00", "Expense"},
                {"2023-01-19", "Social Life", "Had dinner with family", "112.45", "Expense"},
                {"2023-01-20", "Beauty", "Bought hair care products", "25.00", "Expense"},
                {"2023-01-21", "Transportation", "Filled up gas", "48.80", "Expense"},
                {"2023-01-22", "Food", "Bought groceries for the week", "87.12", "Expense"},
                {"2023-01-23", "Culture", "Went to an art gallery", "15.00", "Expense"},
                {"2023-01-23", "Culture", "Went to an art gallery", "15.00", "Expense"},
                {"2023-01-23", "Culture", "Went to an art gallery", "15.00", "Expense"},
                {"2023-01-23", "Culture", "Went to an art gallery", "15.00", "Expense"}};



// use a loop to create 50 Transaction objects with realistic data
        for (int i = 0; i < transactionData.length; i++) {
            try {
                // parse the date string from the transaction data array
                Date transactionDate = dateFormat.parse(transactionData[i][0]);

                // create a new Transaction object with the parsed data and type
                transactionDirectory.addNewTransaction(new Transaction(
                                Double.parseDouble(transactionData[i][3]), // amount
                        account2, // account
                        transactionDate, // transactionDate
                        transactionData[i][1], // category
                        transactionData[i][2], // note
                        transactionData[i][4] // transactionType
                ));
            } catch (ParseException e) {
                System.out.println("Error parsing date");
                e.printStackTrace();
            }
        }


        return transactionDirectory;
    }

    private void showDashboard(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainDashboard.fxml"));
        DashboardController controller = new DashboardController(userDirectory,user,stage);

        loader.setController(controller);

        Parent root = loader.load();


        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Money Manager");
        stage.show();
    }

    public static void main(String[] args) {

        userDirectory = new UserDirectory();

        ArrayList<Account> accountList = new ArrayList<>();

        Account account1 = new Account("Savings Account", "Savings", 5000.0, "Initial deposit");
        accountList.add(account1);

        Account account2 = new Account("Checking Account", "Checking", 2500.0, "Paycheck deposit");
        accountList.add(account2);

        Account account3 = new Account("Credit Card", "Credit", -1000.0, "Monthly payment");
        accountList.add(account3);

        Account account4 = new Account("Investment Account", "Investment", 10000.0, "Stock purchase");
        accountList.add(account4);

        Account account5 = new Account("Retirement Account", "Retirement", 50000.0, "401(k) contribution");
        accountList.add(account5);

        User user = new User("John Doe", 35, "Male", "123", "123", "New York City", 5551234567L, accountList,loadTransactionData());

        // Create a new user and loading it into the user directory
        userDirectory.addNewUser(user);

        launch();
    }
}