package com.example.financetracker;

import directories.UserDirectory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.text.Text;

import java.nio.file.FileSystemNotFoundException;

public class DashboardController {

    @FXML
    private Button transactionsButton, accountsButton, profileButton, logoutButton, statsButton, budgetButton, notesButton;

    @FXML
    private TabPane tabPane;

    @FXML
    private Text totalBalanceText;

    public UserDirectory userDirectory ;
    String username;

    public DashboardController(UserDirectory userDirectory,String username) {
        this.userDirectory = userDirectory;
        this.username = username;
        System.out.println("DashboardController->"+userDirectory+username);
    }



    @FXML
    public void initialize(UserDirectory userDirectory) {
        // Fetch the total balance from the MySQL server
        updateTotalBalance();

        // Set up actions for buttons
//        statsButton.setOnAction(e -> showStats());
//        budgetButton.setOnAction(e -> showBudget());
//        notesButton.setOnAction(e -> showNotes());
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
}
