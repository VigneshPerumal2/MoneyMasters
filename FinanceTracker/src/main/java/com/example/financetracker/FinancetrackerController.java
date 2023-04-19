package com.example.financetracker;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class FinancetrackerController implements Initializable {

    @FXML
    private Button button_logout;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

        button_logout.setOnAction(new EventHandler<ActionEvent>() {


            @Override
            public void handle(ActionEvent event) {
                // TODO Auto-generated method stub
//                DbUtil.changeScene(event, "LoginPage.fxml", "log in!", null, null);
            }

        });
    }
}
