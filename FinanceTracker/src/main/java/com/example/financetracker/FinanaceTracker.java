package com.example.financetracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FinanaceTracker extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        try {
//            System.out.println((HBox)FXMLLoader.load(getClass().getResource("Sample.fxml")));
//            HBox root = (HBox)FXMLLoader.load(getClass().getResource("Sample.fxml"));
//            Scene scene = new Scene(root,600,500);
//            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//            stage.setScene(scene);
//            stage.show();
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
        showDashboard(stage);
    }
    private void showDashboard(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainDashboard.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Money Manager");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}