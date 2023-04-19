package com.example.financetracker;

import directories.TransactionDirectory;
import directories.UserDirectory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Account;
import model.Budget;
import model.User;

import java.io.IOException;
import java.util.ArrayList;

public class FinanaceTracker extends Application {

    static UserDirectory userDirectory ;




    @Override
    public void start(Stage stage) throws IOException {
        showLogInController(stage);

    }

    private void showLogInController(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
        SignInController controller = new SignInController(userDirectory,stage);

        loader.setController(controller);

        Parent root = loader.load();


        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Money Manager");
        stage.show();
    }


    private void showDashboard(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainDashboard.fxml"));
        DashboardController controller = new DashboardController(userDirectory,"Vignesh");

        loader.setController(controller);

        Parent root = loader.load();


        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Money Manager");
        stage.show();
    }

    public static void main(String[] args) {

        userDirectory = new UserDirectory();


        User user = new User("John Doe", 35, "Male", "johndoe@example.com", "password123", "New York City", 5551234567L, new ArrayList<Account>(), new Budget(),new TransactionDirectory());

        // Create a new user and loading it into the user directory
        userDirectory.addNewUser(user);

        launch();
    }
}