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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignInController implements Initializable{

    private  UserDirectory userDirectory;


    private  Stage stage;
    @FXML
    private Button button_login;

    @FXML
    private TextField tf_password;

    @FXML
    private TextField tf_username;


    @FXML
    private Button button_signup;

    public SignInController(UserDirectory userDirectory, Stage stage) {
        this.userDirectory = userDirectory;
        this.stage = stage;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        button_login.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                if(userDirectory.login(tf_username.getText(), tf_password.getText())) {
                    try {
                        showDashboard(stage);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        });

        button_signup.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
//                DbUtil.changeScene(event, "sign-up.fxml", "Sign Up User", null, null);

            }
        });
    }



}