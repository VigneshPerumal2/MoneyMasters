package com.example.financetracker;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable{
	
	@FXML
    private Button button_login;

    @FXML
    private Button button_signup;

    @FXML
    private RadioButton rb_prashant;

    @FXML
    private RadioButton rd_sidhhant;

    @FXML
    private TextField tf_password;

    @FXML
    private TextField tf_username;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		ToggleGroup toggleGroup=new ToggleGroup();
		rb_prashant.setToggleGroup(toggleGroup);
		rd_sidhhant.setToggleGroup(toggleGroup);
		
		rb_prashant.setSelected(true);
		
		button_signup.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				String toggleName=((RadioButton) toggleGroup.getSelectedToggle()).getText();
				
				if(!tf_username.getText().trim().isEmpty() && !tf_password.getText().trim().isEmpty())
				{
//					DbUtil.signUpUser(event, tf_username.getText(), tf_password.getText(), toggleName);
				}
				else
				{
					System.out.print("Please fill all the information");
					Alert alert=new Alert(Alert.AlertType.ERROR);
					alert.setContentText("Please fill in all information to sign up");
					alert.show();
				}
			}
		} );
		
		button_login.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
//				DbUtil.changeScene(event, "sample.fxml", "Log in!", null, null);
				
			}
		});
		
	}

}
