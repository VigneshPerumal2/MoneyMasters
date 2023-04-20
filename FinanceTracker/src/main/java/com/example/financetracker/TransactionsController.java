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
import javafx.stage.Stage;
import com.gluonhq.charm.glisten.control.DropdownButton;
import model.Account;
import model.Transaction;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.ResourceBundle;

public class TransactionsController implements Initializable {


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

        for(Account userAccount: user.getUserAccounts()){
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
//                if(checkvalidationIncome(valIncomeDescription, valIncomeAmount, valIncomeCategory, valIncomeAccount, valIncomeDate, valIncomeNote)==false)
//                {
//
//                    Alert  alert = new Alert(Alert.AlertType.ERROR);
//                    alert.setTitle("Error");
//                    alert.setHeaderText("Error");
//                    alert.setContentText("Please fill all the fields");
//                    alert.showAndWait();
//
//                    return;
//                }
//                else
//                    {
                        boolean val=saveIncomeTransaction(userDirectory,user, dateIncome.getValue(), txtIncomeAmount.getText(), txtIncomeDescription.getText(), txtIncomeNote.getText(), choiceboxIncomeCategory.getValue(), choiceboxIncomeAcount.getValue());
                  //  }

            }
        });

        buttonSaveExpense.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
               boolean val= saveExpenseTransaction(userDirectory,user, dateExpense.getValue(), txtExpenseAmount.getText(), txtExpenseDescription.getText(), txtExpenseNote.getText(), choiceboxExpenseCategory.getValue(), choiceboxExpenseAccount.getValue());
            }
        });

        buttonTransferSave.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                saveTransferTransaction(userDirectory,user, dateTransfer.getValue(), txtTransferAmount.getText(), txtTransferDescription.getText(), txtTransferNote.getText(), choiceBoxTransferFrom.getValue(), choiceBoxTransferTo.getValue());
            }
        });
//
//            String incomedescription = txtIncomeDescription.getText();
//            String incomenote = txtIncomeDescription.getText();
//            String incomeaccount = choiceboxIncomeAcount.getValue();
//            String incomecategory = choiceboxIncomeCategory.getValue();
//            Double amountvalue = Double.parseDouble(txtIncomeAmount.getText());
//            LocalDate localDate = dateIncome.getValue();
//            String Note= txtIncomeNote.getText();
//
//
//            @Override
//            public void handle(ActionEvent event) {
//                saveTransaction(userDirectory,user, localDate, amountvalue ,incomedescription, incomenote, choiceboxIncomeCategory.getValue(), choiceboxIncomeAcount.getValue());
//            }
//        });

    }

    private boolean checkvalidationIncome(Label valIncomeDescription, Label valIncomeAmount, Label valIncomeCategory, Label valIncomeAccount, Label valIncomeDate, Label valIncomeNote) {
        boolean flag = true;
        if(txtIncomeDescription.getText().isEmpty()){
           valIncomeDescription.setText("Description is required");
            flag = false;
        }
        if(txtIncomeAmount.getText().isEmpty()){

            valIncomeAmount.setText("Amount is required");
            flag = false;
        }
        if(choiceboxIncomeCategory.getValue()==null){
            valIncomeCategory.setText("Category is required");
            flag = false;
        }
        if(choiceboxIncomeAcount.getValue()==null){
            valIncomeAccount.setText("Account is required");
            flag = false;
        }

        if(dateIncome.getValue()==null){
            valIncomeDate.setText("Date is required");

            flag = false;
        }
        if(txtIncomeNote.getText().isEmpty()){
            valIncomeNote.setText("Note is required");
            flag = false;
        }
        return flag;
    }


    private boolean saveTransferTransaction(UserDirectory userDirectory, User user, LocalDate value, String text, String text1, String text2, String value1, String value2) {
        Date date1 = Date.from(value.atStartOfDay(ZoneId.systemDefault()).toInstant());
        if(userDirectory.getAccount(value1,user).getAmount()-Double.parseDouble(text)<0)
        {
            Alert  alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Insufficient Balance your balance is "+userDirectory.getAccount(value1,user).getAmount());
            alert.showAndWait();
        }
        userDirectory.getAccount(value1,user).setAmount(userDirectory.getAccount(value1,user).getAmount()-Double.parseDouble(text));

        userDirectory.getAccount(value2,user).setAmount(userDirectory.getAccount(value2,user).getAmount()+Double.parseDouble(text));
        Transaction transaction = new Transaction(Double.parseDouble(text), userDirectory.getAccount(value1,user), date1, value2, text1, text2);
        Transaction transaction1 = new Transaction(Double.parseDouble(text), userDirectory.getAccount(value2,user), date1, value1, text1, text2);
        user.getTransactionDirectory().addNewTransaction(transaction);
        user.getTransactionDirectory().addNewTransaction(transaction1);
        System.out.println(transaction.toString());
        System.out.println(transaction1.toString());

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

    private boolean saveIncomeTransaction(UserDirectory userDirectory, User user,LocalDate date, String  amount, String income, String incomedescription, String incomecategory, String accountname) {


        boolean val=checkvalidationIncome(valIncomeDescription, valIncomeAmount, valIncomeCategory, valIncomeAccount, valIncomeDate, valIncomeNote);
        if(!val)
        {
            return false;
        }

        Date date1 = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
        userDirectory.getAccount(accountname,user).setAmount(userDirectory.getAccount(accountname,user).getAmount()+Double.parseDouble(amount));
        Transaction transaction = new Transaction(Double.parseDouble(amount), userDirectory.getAccount(accountname,user), date1, incomecategory, incomedescription, income);
        user.getTransactionDirectory().addNewTransaction(transaction);
        System.out.println(transaction.toString());

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

    private boolean saveExpenseTransaction(UserDirectory userDirectory, User user,LocalDate date, String  amount, String expense, String expensedescription, String expensecategory, String accountname) {

        boolean val=checkValdationExpense(valExpenseDescription, valExpenseAmount, valExpenseCategory, valExpenseAccount, valExpenseDate, valExpenseNote);
        if(val==false)
        {
            return false;
        }
        Date date1 = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
        if(userDirectory.getAccount(accountname,user).getAmount()-Double.parseDouble(amount)<0)
        {
            Alert  alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Insufficient Balance");
            alert.setContentText("Insufficient Balance"+userDirectory.getAccount(accountname,user).getAmount());
            alert.showAndWait();

            return true;
        }
        userDirectory.getAccount(accountname,user).setAmount(userDirectory.getAccount(accountname,user).getAmount()-Double.parseDouble(amount));

        Transaction transaction = new Transaction(Double.parseDouble(amount), userDirectory.getAccount(accountname,user), date1, expensecategory, expensedescription, expense);
        user.getTransactionDirectory().addNewTransaction(transaction);
        System.out.println(transaction.toString());

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

    private boolean checkValdationExpense(Label valExpenseDescription, Label valExpenseAmount, Label valExpenseCategory, Label valExpenseAccount, Label valExpenseDate, Label valExpenseNote) {
        boolean flag = true;
        if(txtExpenseDescription.getText().isEmpty()){
            valExpenseDescription.setText("Description is required");
            flag = false;
        }
        if(txtExpenseAmount.getText().isEmpty()){

            valExpenseAmount.setText("Amount is required");
            flag = false;
        }
        if(choiceboxExpenseCategory.getValue()==null){
            valExpenseCategory.setText("Category is required");
            flag = false;
        }
        if(choiceboxExpenseAccount.getValue()==null){
            valExpenseAccount.setText("Account is required");
            flag = false;
        }

        if(dateExpense.getValue()==null){
            valExpenseDate.setText("Date is required");

            flag = false;
        }
        if(txtExpenseNote.getText().isEmpty()){
            valExpenseNote.setText("Note is required");
            flag = false;
        }
        return flag;

    }

}
