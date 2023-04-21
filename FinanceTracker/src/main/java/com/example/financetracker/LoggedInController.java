package com.example.financetracker;

import directories.TransactionDirectory;
import directories.UserDirectory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;


public class LoggedInController implements Initializable{

	private  UserDirectory userDirectory;
	private  TransactionDirectory transactionDirectory;
	@FXML
    private Button button_logout;
    @FXML
    private Label label_fav_channel;
	@FXML
	private Button button_financeTracker;
    @FXML
    private Label label_welcome;

	public LoggedInController(UserDirectory userDirectory, TransactionDirectory transactionDirectory) {
		this.userDirectory = userDirectory;
		this.transactionDirectory = transactionDirectory;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		 
		 button_logout.setOnAction(new EventHandler<ActionEvent> () {


			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
//				DbUtil.changeScene(event, "LoginPage.fxml", "log in!", null, null);
			}
			 
		 });


		 button_financeTracker.setOnAction(new EventHandler<ActionEvent>() {
			 @Override
			 public void handle(ActionEvent event) {

//				 DbUtil.changeScene(event,"financetracker.fxml","log in",null,null);
			 }
		 });
	}
	 
	 public void setUserInformation(String name,String favChannel)
	 {
		 label_welcome.setText("Welcome "+name);
		 label_fav_channel.setText("Your favorite Youtube channel is "+favChannel+"!");
	 }
}

