package com.example.financetracker;

import directories.UserDirectory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Account;
import model.Transaction;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

public class TransactionsController implements Initializable {


    UserDirectory userDirectory;
    Stage stage;
    User user;
    @FXML
    private Button buttonExpenseCancel;
    @FXML
    private Button buttonIncomeCancel;
    @FXML
    private Button buttonIncomeSave;
    @FXML
    private Button buttonSaveExpense;
    @FXML
    private Button buttonTransferCancel;
    @FXML
    private Button buttonTransferSave;

    @FXML
    private Button dashboardButton;
    @FXML
    private Button buttonTransaction;
    @FXML
    private Button buttonAccount;
    @FXML
    private Button buttonProfile;
    @FXML
    private ComboBox<String> choiceBoxTransferTo;
    @FXML
    private ComboBox<String> choiceBoxTransferFrom;
    @FXML
    private ComboBox<String> choiceboxExpenseAccount;
    @FXML
    private ComboBox<String> choiceboxExpenseCategory;
    @FXML
    private ComboBox<String> choiceboxIncomeAcount;
    @FXML
    private ComboBox<String> choiceboxIncomeCategory;
    @FXML
    private DatePicker dateExpense;
    @FXML
    private DatePicker dateIncome;
    @FXML
    private DatePicker dateTransfer;
    @FXML
    private TextField txtExpenseAmount;
    @FXML
    private TextField txtExpenseDescription;
    @FXML
    private TextField txtExpenseNote;
    @FXML
    private TextField txtIncomeAmount;
    @FXML
    private TextField txtIncomeDescription;
    @FXML
    private TextField txtIncomeNote;
    @FXML
    private TextField txtTransferAmount;
    @FXML
    private TextField txtTransferDescription;
    @FXML
    private TextField txtTransferNote;
    @FXML
    private Label valExpenseAccount;
    @FXML
    private Label valExpenseAmount;
    @FXML
    private Label valExpenseCategory;
    @FXML
    private Label valExpenseDate;
    @FXML
    private Label valExpenseDescription;
    @FXML
    private Label valExpenseNote;
    @FXML
    private Label valIncomeAccount;
    @FXML
    private Label valIncomeAmount;
    @FXML
    private Label valIncomeCategory;
    @FXML
    private Label valIncomeDate;
    @FXML
    private Label valIncomeDescription;
    @FXML
    private Label valIncomeNote;
    @FXML
    private Label valTransferAmount;
    @FXML
    private Label valTransferDate;
    @FXML
    private Label valTransferDescription;
    @FXML
    private Label valTransferFrom;
    @FXML
    private Label valTransferNote;
    @FXML
    private Label valTransferTo;

    @FXML
    private Text txtUserName;

    @FXML
    private Button btnLogOut;

    public TransactionsController(UserDirectory userDirectory, User user, Stage stage) {
        this.userDirectory = userDirectory;
        this.stage = stage;
        this.user = user;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        txtUserName.setText(user.getName());
        for (Account userAccount : user.getUserAccounts()) {
            choiceboxExpenseAccount.getItems().add(userAccount.getAccountName().toString());
            choiceboxIncomeAcount.getItems().add(userAccount.getAccountName().toString());
            choiceBoxTransferFrom.getItems().add(userAccount.getAccountName().toString());
            choiceBoxTransferTo.getItems().add(userAccount.getAccountName().toString());

        }

        choiceboxExpenseCategory.getItems().add("Food");
        choiceboxExpenseCategory.getItems().add("Transportation");
        choiceboxExpenseCategory.getItems().add("Entertainment");
        choiceboxExpenseCategory.getItems().add("Shopping");
        choiceboxExpenseCategory.getItems().add("Health");
        choiceboxExpenseCategory.getItems().add("Education");
        choiceboxExpenseCategory.getItems().add("Bills");
        choiceboxExpenseCategory.getItems().add("Other");

        choiceboxIncomeCategory.getItems().add("Salary");
        choiceboxIncomeCategory.getItems().add("Gift");
        choiceboxIncomeCategory.getItems().add("Other");


        buttonIncomeSave.setOnAction(new EventHandler<ActionEvent>() {


            @Override
            public void handle(ActionEvent event) {
                boolean val = saveIncomeTransaction(userDirectory, user, dateIncome.getValue(), txtIncomeAmount.getText(), txtIncomeDescription.getText(), txtIncomeNote.getText(), choiceboxIncomeCategory.getValue(), choiceboxIncomeAcount.getValue());
            }
        });

        buttonSaveExpense.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean val = saveExpenseTransaction(userDirectory, user, dateExpense.getValue(), txtExpenseAmount.getText(), txtExpenseDescription.getText(), txtExpenseNote.getText(), choiceboxExpenseCategory.getValue(), choiceboxExpenseAccount.getValue());
            }
        });

        buttonTransferSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean val = saveTransferTransaction(userDirectory, user, dateTransfer.getValue(), txtTransferAmount.getText(), txtTransferDescription.getText(), txtTransferNote.getText(), choiceBoxTransferFrom.getValue(), choiceBoxTransferTo.getValue());
            }
        });

        buttonAccount.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Account.fxml"));
                    AccountController accountController = new AccountController(userDirectory, user, stage, "test");
                    loader.setController(accountController);
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        dashboardButton.setOnAction(

                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        try {
                            showDashboard(stage);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    }

                }
        );
        btnLogOut.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        try {
                            showLogInController(stage);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }


                    }
                });


    }

    private void showLogInController(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
        SignInController controller = new SignInController(userDirectory, user, stage);

        loader.setController(controller);

        Parent root = loader.load();


        Scene scene = new Scene(root, 800, 600);
        // Add the CSS file to the scene's stylesheets
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Spend Wise");
        stage.show();
    }

    private boolean checkvalidationIncome(Label valIncomeDescription, Label valIncomeAmount, Label valIncomeCategory, Label valIncomeAccount, Label valIncomeDate, Label valIncomeNote) {
        boolean flag = true;
        if (txtIncomeDescription.getText().isEmpty()) {
            valIncomeDescription.setText("Description is required");
            flag = false;
        } else {
            valIncomeDescription.setText("*");
        }
        if (txtIncomeAmount.getText().isEmpty()) {

            valIncomeAmount.setText("Amount is required");
            flag = false;
        } else {
            try {
                double val = Double.parseDouble(txtIncomeAmount.getText().toString());
            } catch (NumberFormatException e) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("Amount should be a number");
                alert.showAndWait();
                valIncomeAmount.setText("Amount should be a number");
                flag = false;
            }
            valIncomeAmount.setText("*");
        }
        if (choiceboxIncomeCategory.getValue() == null) {
            valIncomeCategory.setText("Category is required");
            flag = false;
        } else {
            valIncomeCategory.setText("*");
        }
        if (choiceboxIncomeAcount.getValue() == null) {
            valIncomeAccount.setText("Account is required");
            flag = false;
        } else {
            valIncomeAccount.setText("*");
        }

        if (dateIncome.getValue() == null) {
            valIncomeDate.setText("Date is required");

            flag = false;
        } else {
            valIncomeDate.setText("*");
        }
        if (txtIncomeNote.getText().isEmpty()) {
            valIncomeNote.setText("Note is required");
            flag = false;
        } else {
            valIncomeNote.setText("*");
        }
        return flag;
    }


    private boolean saveTransferTransaction(UserDirectory userDirectory, User user, LocalDate value, String text, String text1, String text2, String value1, String value2) {

        boolean val = checkValidationTransfer(valIncomeDescription, valIncomeAmount, valIncomeCategory, valIncomeAccount, valIncomeDate, valIncomeNote);
        if (!val) {
            return false;
        }
        if (userDirectory.getAccount(value1, user).getAmount() - Double.parseDouble(text) < 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Insufficient Balance your balance is " + userDirectory.getAccount(value1, user).getAmount());
            alert.showAndWait();
            return false;

        }
        Date date1 = Date.from(value.atStartOfDay(ZoneId.systemDefault()).toInstant());
        userDirectory.getAccount(value1, user).setAmount(userDirectory.getAccount(value1, user).getAmount() - Double.parseDouble(text));

        userDirectory.getAccount(value2, user).setAmount(userDirectory.getAccount(value2, user).getAmount() + Double.parseDouble(text));
        Transaction transaction = new Transaction(Double.parseDouble(text), userDirectory.getAccount(value1, user), date1, value2, text1, text2);
        Transaction transaction1 = new Transaction(Double.parseDouble(text), userDirectory.getAccount(value2, user), date1, value1, text1, text2);
        user.getTransactionDirectory().addNewTransaction(transaction);
        user.getTransactionDirectory().addNewTransaction(transaction1);
        System.out.println(transaction.toString());
        System.out.println(transaction1.toString());


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Transaction Successful");
        alert.setContentText("Transaction Successful New balance is" + userDirectory.getAccount(value1, user).getAmount());
        alert.showAndWait();


        txtTransferAmount.setText("");
        txtTransferDescription.setText("");
        txtTransferNote.setText("");
        choiceBoxTransferFrom.setValue("");
        choiceBoxTransferTo.setValue("");
        dateTransfer.setValue(null);
        valTransferAmount.setText("*");
        valTransferDescription.setText("*");
        valTransferNote.setText("*");
        valTransferFrom.setText("*");
        valTransferTo.setText("*");
        valTransferDate.setText("*");

        return true;
    }

    private boolean checkValidationTransfer(Label valIncomeDescription, Label valIncomeAmount, Label valIncomeCategory, Label valIncomeAccount, Label valIncomeDate, Label valIncomeNote) {
        boolean flag = true;
        if (txtTransferDescription.getText().isEmpty()) {
            valTransferDescription.setText("Description is required");
            flag = false;
        } else {
            valTransferDescription.setText("*");
        }

        if (txtTransferAmount.getText().isEmpty()) {

            valTransferAmount.setText("Amount is required");
            flag = false;
        } else {
            try {
                double val = Double.parseDouble(txtTransferAmount.getText().toString());
            } catch (NumberFormatException e) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("Amount should be a number");
                alert.showAndWait();
                valTransferAmount.setText("Amount should be a number");
                flag = false;
            }
            valTransferAmount.setText("*");
        }
        if (choiceBoxTransferFrom.getValue() == null) {
            valTransferFrom.setText("From is required");
            flag = false;
        } else {
            valTransferFrom.setText("*");
        }
        if (choiceBoxTransferTo.getValue() == null) {
            valTransferTo.setText("To is required");
            flag = false;
        } else {
            valTransferTo.setText("*");
        }

        if (dateTransfer.getValue() == null) {
            valTransferDate.setText("Date is required");

            flag = false;
        } else {
            valTransferDate.setText("*");
        }
        if (txtTransferNote.getText().isEmpty()) {
            valTransferNote.setText("Note is required");
            flag = false;
        } else {
            valTransferNote.setText("*");
        }
        return flag;
    }

    private boolean saveIncomeTransaction(UserDirectory userDirectory, User user, LocalDate date, String amount, String income, String incomedescription, String incomecategory, String accountname) {


        boolean val = checkvalidationIncome(valIncomeDescription, valIncomeAmount, valIncomeCategory, valIncomeAccount, valIncomeDate, valIncomeNote);
        if (!val) {
            return false;
        }

        Date date1 = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
        userDirectory.getAccount(accountname, user).setAmount(userDirectory.getAccount(accountname, user).getAmount() + Double.parseDouble(amount));
        Transaction transaction = new Transaction(Double.parseDouble(amount), userDirectory.getAccount(accountname, user), date1, incomecategory, incomedescription, "Income");
        user.getTransactionDirectory().addNewTransaction(transaction);
        System.out.println(transaction.toString());


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Transaction Successful");
        alert.setContentText("Transaction Successful New balance in " + userDirectory.getAccount(accountname, user).getAccountName() + " = " + userDirectory.getAccount(accountname, user).getAmount());
        alert.showAndWait();

        txtIncomeAmount.setText("");
        txtIncomeDescription.setText("");
        txtIncomeNote.setText("");
        choiceboxIncomeAcount.setValue("");
        choiceboxIncomeCategory.setValue("");
        dateIncome.setValue(null);
        valIncomeCategory.setText("*");
        valIncomeAccount.setText("*");
        valIncomeAmount.setText("*");
        valIncomeDate.setText("*");
        valIncomeDescription.setText("*");
        valIncomeNote.setText("*");

        return true;


    }

    private boolean saveExpenseTransaction(UserDirectory userDirectory, User user, LocalDate date, String amount, String expense, String expensedescription, String expensecategory, String accountname) {

        boolean val = checkValdationExpense(valExpenseDescription, valExpenseAmount, valExpenseCategory, valExpenseAccount, valExpenseDate, valExpenseNote);
        if (val == false) {
            return false;
        }
        Date date1 = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
        if (userDirectory.getAccount(accountname, user).getAmount() - Double.parseDouble(amount) < 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Insufficient Balance");
            alert.setContentText("Insufficient Balance" + userDirectory.getAccount(accountname, user).getAmount());
            alert.showAndWait();

            return true;
        }
        userDirectory.getAccount(accountname, user).setAmount(userDirectory.getAccount(accountname, user).getAmount() - Double.parseDouble(amount));

        Transaction transaction = new Transaction(Double.parseDouble(amount), userDirectory.getAccount(accountname, user), date1, expensecategory, expensedescription, "Expense");
        user.getTransactionDirectory().addNewTransaction(transaction);
        System.out.println(transaction.toString());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Transaction Successful");
        alert.setContentText("Transaction Successful New balance is" + userDirectory.getAccount(accountname, user).getAmount());
        alert.showAndWait();


        txtExpenseAmount.setText("");
        txtExpenseDescription.setText("");
        txtExpenseNote.setText("");
        choiceboxExpenseAccount.setValue("");
        choiceboxExpenseCategory.setValue("");
        dateExpense.setValue(null);
        valExpenseAmount.setText("*");
        valExpenseAccount.setText("*");
        valExpenseCategory.setText("*");
        valExpenseDate.setText("*");
        valExpenseDescription.setText("*");
        valExpenseNote.setText("*");

        return true;
    }

    private void showDashboard(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainDashboard.fxml"));
        DashboardController controller = new DashboardController(userDirectory, user, stage);

        loader.setController(controller);

        Parent root = loader.load();


        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("Spend Wise");
        stage.show();
    }

    private boolean checkValdationExpense(Label valExpenseDescription, Label valExpenseAmount, Label valExpenseCategory, Label valExpenseAccount, Label valExpenseDate, Label valExpenseNote) {
        boolean flag = true;
        if (txtExpenseDescription.getText().isEmpty()) {
            valExpenseDescription.setText("Description is required");
            flag = false;
        } else {
            valExpenseDescription.setText("*");
        }
        if (txtExpenseAmount.getText().isEmpty()) {

            valExpenseAmount.setText("Amount is required");
            flag = false;
        } else {
            valExpenseAmount.setText("*");
        }
        if (choiceboxExpenseCategory.getValue() == null) {
            valExpenseCategory.setText("Category is required");
            flag = false;
        } else {
            valExpenseCategory.setText("*");
        }
        if (choiceboxExpenseAccount.getValue() == null) {
            valExpenseAccount.setText("Account is required");
            flag = false;
        } else {
            try {
                Double.parseDouble(txtExpenseAmount.getText());
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Amount should be a number");
                alert.setContentText("Amount should be a number");
                alert.showAndWait();

                valExpenseAmount.setText("Amount should be a number");
                flag = false;
            }
            valExpenseAccount.setText("*");
        }

        if (dateExpense.getValue() == null) {
            valExpenseDate.setText("Date is required");

            flag = false;
        } else {
            valExpenseDate.setText("*");
        }
        if (txtExpenseNote.getText().isEmpty()) {
            valExpenseNote.setText("Note is required");
            flag = false;
        } else {
            valExpenseNote.setText("*");
        }
        return flag;

    }

}
