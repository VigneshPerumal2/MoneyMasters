package com.example.financetracker;

import directories.UserDirectory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Account;
import model.User;

import java.net.URL;
import java.util.ResourceBundle;

public class AccountController implements Initializable {

    @FXML
    private Button buttonAccount;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonCancel;

    @FXML
    private Button buttonLogout;

    @FXML
    private Button buttonTansaction;

    @FXML
    private ChoiceBox<String> choiceboxType;

    @FXML
    private TextField txtAccountName;

    @FXML
    private TextField txtAmount;

    @FXML
    private TextField txtNote;


    @FXML
    private Text valAccountName;

    @FXML
    private Text valAccountType;

    @FXML
    private Text valAmount;

    @FXML
    private Text valNote;

    UserDirectory userDirectory;
    User user;
    Stage stage;

    public AccountController(UserDirectory userDirectory, User user, Stage stage, String vignesh) {
        this.stage = stage;
        this.userDirectory = userDirectory;
        this.user = user;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        for (Account account : user.getUserAccounts()) {
            choiceboxType.getItems().add(account.getAccountType());
        }

        buttonAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Boolean val = SaveUser(txtAccountName.getText(), choiceboxType.getValue(), txtAmount.getText(), txtNote.getText());

            }
        });

        buttonTansaction.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Transactions.fxml"));
                    loader.setController(new TransactionsController(userDirectory, user, stage));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }

    private Boolean SaveUser(String AccounName, String AccountType, String Amount, String Note) {

        boolean val = checkvalidation(valAccountName, valAccountType, valAmount, valNote);
        if (val) {
            Account account = new Account(AccounName, AccountType, Double.parseDouble(Amount), Note);
            user.getUserAccounts().add(account);

            txtAccountName.setText("");
            choiceboxType.setValue("");
            txtAmount.setText("");
            txtNote.setText("");

            valAccountName.setText("*");
            valAccountType.setText("*");
            valAmount.setText("*");
            valNote.setText("*");

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Account");
            alert.setHeaderText("Account Added");
            alert.setContentText("Account Added Successfully");
            alert.showAndWait();


            return true;
        } else {
            return false;
        }

    }

    private boolean checkvalidation(Text valAccountName, Text valAccountType, Text valAmount, Text valNote) {
        boolean val = true;
        if (txtAccountName.getText().isEmpty()) {
            valAccountName.setText("Account Name is required");
            val = false;
        } else {
            valAccountName.setText("*");
        }
        if (choiceboxType.getValue()==null) {
            valAccountType.setText("Account Type is required");
            val = false;
        } else {
            valAccountType.setText("*");
        }
        if (txtAmount.getText().isEmpty()) {
            valAmount.setText("Amount is required");
            val = false;
        } else {
            valAmount.setText("*");
        }
        if (txtNote.getText().isEmpty()) {
            valNote.setText("Note is required");
            val = false;
        } else {
            valNote.setText("*");
        }
        return val;
    }
}
