package com.example.financetracker;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.text.Text;

public class DashboardController {

    @FXML
    private Button transactionsButton, accountsButton, profileButton, logoutButton, statsButton, budgetButton, notesButton;

    @FXML
    private TabPane tabPane;

    @FXML
    private Text totalBalanceText;

    @FXML
    public void initialize() {
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
