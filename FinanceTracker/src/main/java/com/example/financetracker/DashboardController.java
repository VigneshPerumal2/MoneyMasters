package com.example.financetracker;

import directories.TransactionDirectory;
import directories.UserDirectory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystemNotFoundException;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    private Stage stage;
    @FXML
    private Button transactionButton, accountButton, profileButton, logoutButton, statsButton, budgetButton, notesButton;

    @FXML
    private TabPane tabPane;

    @FXML
    private Text totalBalanceText;

    public UserDirectory userDirectory ;

    public User user;
    String username;

    public DashboardController(UserDirectory userDirectory, User user,Stage stage) {
        this.userDirectory = userDirectory;
        this.username = username;
        this.stage=stage;
        this.user= user;
        System.out.println("DashboardController->"+userDirectory+username);
    }







    private void showDashboardTransaction(Stage stage) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Transactions.fxml"));
        TransactionsController controller = new TransactionsController(userDirectory,user,stage);

        loader.setController(controller);

        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Transaction Manager");
        stage.show();
    }

    private void showDashboardAccount(Stage stage) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Account.fxml"));
        AccountController controller = new AccountController(userDirectory,stage,"Vignesh");

        loader.setController(controller);

        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Account Manager");
        stage.show();
    }
    private void updateTotalBalance() {
        // TODO: Fetch the total balance from the MySQL server and update the totalBalanceText
        // Example: totalBalanceText.setText(String.valueOf(fetchedBalance));
    }

    private void showStats() {
        // TODO: Implement the code for showing the Stats section
    }

    private void showBudget() {
        // TODO: Implement the code for showing the Budget section
    }

    private void showNotes() {
        // TODO: Implement the code for showing the Notes section
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        transactionButton.setOnAction(

                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        showDashboardTransaction(stage);

                    }

                }
        );

        accountButton.setOnAction(

                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                       showDashboardAccount(stage);

                    }

                }
        );
    }
}

