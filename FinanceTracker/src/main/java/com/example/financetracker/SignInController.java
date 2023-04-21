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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignInController implements Initializable {

    User user;
    private UserDirectory userDirectory;
    private Stage stage;
    @FXML
    private Button button_login;

    @FXML
    private TextField tf_password;

    @FXML
    private TextField tf_username;


    @FXML
    private Button button_signup;

    public SignInController(UserDirectory userDirectory, User user, Stage stage) {
        this.userDirectory = userDirectory;
        this.stage = stage;
        this.user = user;
    }

    private void showDashboard(Stage stage, User user) throws IOException {
        this.user = user;


        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainDashboard.fxml"));
            DashboardController controller = new DashboardController(userDirectory, user, stage);

            loader.setController(controller);

            Parent root = loader.load();


            Scene scene = new Scene(root, 800, 600);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("Spend Wise");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        button_login.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                if(tf_username.getText().isEmpty())
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Username is empty");
                    alert.setContentText("Please enter a username");
                    alert.showAndWait();
                    return;
                }
                if(tf_password.getText().isEmpty())
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Password is empty");
                    alert.setContentText("Please enter a password");
                    alert.showAndWait();
                    return;
                }


                User user = userDirectory.login(tf_username.getText(), tf_password.getText());
                if(user==null)
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid Credentials");
                    alert.setContentText("Please enter valid credentials");
                    alert.showAndWait();
                    return;
                }
                if (user != null) {
                    try {
                        showDashboard(stage, user);
                    } catch (IOException e) {

                        e.printStackTrace();
                    }
                }

            }
        });

        button_signup.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
//                DbUtil.changeScene(event, "sign-up.fxml", "Sign Up User", null, null);
                showDashboardSignUp(stage);
            }
        });
    }

    private void showDashboardSignUp(Stage stage) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUpPage.fxml"));
        SignUpController controller = new SignUpController(userDirectory, user, stage);

        loader.setController(controller);

        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Spend Wise");
        stage.show();
    }


}