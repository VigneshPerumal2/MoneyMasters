package com.example.financetracker;

import directories.UserDirectory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.gluonhq.charm.glisten.control.DropdownButton;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TransactionsController implements Initializable {


    @FXML
    private Button cancelButton;

    @FXML
    private DatePicker dateIncome;

    @FXML
    private DropdownButton dropdownIncomeAccount;

    @FXML
    private DropdownButton dropdownIncomeCategory;

    @FXML
    private Button saveButton;

    @FXML
    private TextField txtAmount;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtNote;
    UserDirectory userDirectory;
    Stage stage;

    User user;

    public TransactionsController(UserDirectory userDirectory, User user,Stage stage ) {
        this.userDirectory = userDirectory;
        this.stage = stage;
        this.user = user;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        saveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                saveTransaction(userDirectory,dateIncome.getAccessibleText(), txtAmount.getText() ,txtDescription.getText(), txtNote.getText(), dropdownIncomeAccount.getSelectedItem(), dropdownIncomeCategory.getSelectedItem());
            }
        });

    }

    private void saveTransaction(UserDirectory userDirectory, String accessibleText, String text, String text1, String text2, MenuItem selectedItem, MenuItem selectedItem1) {

    }
}
