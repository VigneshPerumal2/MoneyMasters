package com.example.financetracker;

import directories.TransactionDirectory;
import directories.UserDirectory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Account;
import model.Transaction;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystemNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    private Stage stage;
    @FXML
    private Button transactionButton, accountButton, profileButton, logoutButton, statsButton, budgetButton, notesButton;

    @FXML
    private TabPane tabPane;

    @FXML
    private Text txtTotalBalance;

    @FXML
    private Text txtTotalExpense;

    @FXML
    private Text txtUserName;

    @FXML
    private BarChart<String, Number> chartExpense;


    @FXML
    private BarChart<String, Number> chartIncome;

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

    public void showExpenseChart(){

        // create a map to store the expenses by category
        Map<String, Double> expensesByCategory = new HashMap<>();
        expensesByCategory.put("Food", 0.0);
        expensesByCategory.put("Social Life", 0.0);
        expensesByCategory.put("Self Development", 0.0);
        expensesByCategory.put("Transportation", 0.0);
        expensesByCategory.put("Culture", 0.0);
        expensesByCategory.put("Household", 0.0);
        expensesByCategory.put("Apparel", 0.0);
        expensesByCategory.put("Beauty", 0.0);
        expensesByCategory.put("Health", 0.0);
        expensesByCategory.put("Education", 0.0);
        expensesByCategory.put("Gift", 0.0);
        expensesByCategory.put("Other", 0.0);
        expensesByCategory.put("Phone", 0.0);

        for(Transaction transaction: user.getTransactionDirectory().getHistory()){
            System.out.println(transaction);
            if(Objects.equals(transaction.getTransactionType(), "Expense")){
                expensesByCategory.put(transaction.getCategory(),expensesByCategory.get(transaction.getCategory())+transaction.getAmount());
            }
        }

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        chartExpense.setTitle("Expense Chart");
        xAxis.setLabel("Category");
        yAxis.setLabel("Amount");
        // set the size of the chart
        chartExpense.setPrefSize(566, 350);
        chartExpense.setLegendVisible(false);

        // Create a new series for each category
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        for (Map.Entry<String, Double> entry : expensesByCategory.entrySet()) {
            String category = entry.getKey();
            Double amount = entry.getValue();
            series.getData().add(new XYChart.Data<>(category, amount));
        }
        series.setName("Expenses");

        // Add series to chart and show stage
        ObservableList<XYChart.Series<String, Number>> data = FXCollections.observableArrayList(series);
        chartExpense.setData(data);

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

        double totalBalance=0;
        for(Account account:user.getUserAccounts()){
            totalBalance+=account.getAmount();
        }
        if(totalBalance>0){
            txtTotalBalance.setText(String.valueOf(totalBalance));
        }

    }

    private void updateTotalExpense() {
        // TODO: Fetch the total balance from the MySQL server and update the totalBalanceText
        // Example: totalBalanceText.setText(String.valueOf(fetchedBalance));
        double totalExpense=0;
        for(Transaction transaction:user.getTransactionDirectory().getHistory()){
            totalExpense+=transaction.getAmount();
        }


            txtTotalExpense.setText(String.valueOf(totalExpense));


    }

    private void showStats() {
        // TODO: Implement the code for showing the Stats section
        showExpenseChart();
    }

    private void showBudget() {
        // TODO: Implement the code for showing the Budget section
    }

    private void showNotes() {
        // TODO: Implement the code for showing the Notes section
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        showExpenseChart();
        updateTotalBalance();
        updateTotalExpense();
        txtUserName.setText(user.getName());

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

