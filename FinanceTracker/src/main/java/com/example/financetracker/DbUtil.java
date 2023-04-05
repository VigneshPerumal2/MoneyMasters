package com.example.financetracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Objects;

public class DbUtil {

	
	public static void changeScene(ActionEvent event,String fxmlFile,String title,String username,String favChannel)
	{
		
		System.out.println(fxmlFile);
		
		 Parent root=null;
		if(username!=null && favChannel!=null)
		{
			try {
				FXMLLoader loader=new FXMLLoader(DbUtil.class.getResource(fxmlFile));
				 root=loader.load();
				 LoggedInController loggedInController=loader.getController();
				 loggedInController.setUserInformation(username, favChannel);
			}
			catch(IOException e) {
				e.printStackTrace();
			}

		} 
		else {
			try {
				System.out.println(DbUtil.class.getResource(fxmlFile));
				URL url=DbUtil.class.getResource(fxmlFile);
				System.out.println(url);

				root=FXMLLoader.load(Objects.requireNonNull(DbUtil.class.getResource(fxmlFile)));

						
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		
		Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
		
		stage.setTitle(title);
		stage.setScene(new Scene(root,600,400));
		stage.show();
		
	}
	
	public static void signUpUser(ActionEvent event,String username,String password,String favChannel)
	{
		PreparedStatement psInsert=null;
		PreparedStatement psCheckUserExists=null;
		ResultSet resultSet=null;
		Connection connection=null;
		String DB_URL = "jdbc:mysql://localhost:3306/users?autoReconnect=true&useSSL=false";
        String USER = "root";
        String PASS = "root1234";

         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
         }
         catch (ClassNotFoundException e)
         {
             e.printStackTrace();
         }

         try{
        	  connection=DriverManager.getConnection(DB_URL,USER,PASS);
              psCheckUserExists= connection.prepareStatement("SELECT * FROM user where username= ? ");
              psCheckUserExists.setString(1, username);
              
              resultSet =psCheckUserExists.executeQuery();
              if(resultSet.isBeforeFirst())
              {
            	  System.out.println("User Already Exist");
            	  Alert alert=new Alert(Alert.AlertType.ERROR);
            	  alert.setContentText("You cannnot use this username");
				  alert.show();
              }
              else
              {
            	  psInsert=connection.prepareStatement("Insert into users.user (username,password,favchannel) VALUES(?,?,?)");
				  System.out.println(username+"   "+password+"   "+favChannel);
            	  psInsert.setString(1, username);
            	  psInsert.setString(2, password);
            	  psInsert.setString(3, favChannel);
				  psInsert.executeUpdate();
            	  changeScene(event, "logged-in.fxml", "Welcome", username, favChannel);
              }
          
	}
         catch(SQLException e)
         {
        	 e.printStackTrace();
         }
         finally {
        	 if(resultSet!=null)
        	 {
        		 try {
        			 resultSet.close();
        		 }
        		 catch (SQLException e) {
					e.printStackTrace();
				}
        	 }
        	 
        	 if(psCheckUserExists!=null)
        	 {
        		 try {
        			 psCheckUserExists.close();
        		 }
        		 catch (SQLException e) {
					e.printStackTrace();
				}
        	 }
        	 if(psInsert!=null)
        	 {
        		 try {
        			 psInsert.close();
        		 }
        		 catch (SQLException e) {
					e.printStackTrace();
				}
        	 }
        	 if(connection!=null)
        	 {
        		 try {
        			 connection.close();
        		 }
        		 catch (SQLException e) {
					e.printStackTrace();
				}
        	 }
         }
}
	
	public static void logInUser(ActionEvent event,String username,String password)
	{
		
		PreparedStatement psInsert=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Connection connection=null;
		String DB_URL = "jdbc:mysql://localhost:3306/users?autoReconnect=true&useSSL=false";
        String USER = "root";
        String PASS = "root1234";
         try {
        	 connection=DriverManager.getConnection(DB_URL,USER,PASS);
        	 preparedStatement=connection.prepareStatement("Select password,favchannel from users.user where username = ? ");
        	 preparedStatement.setString(1,username);
			 System.out.println(preparedStatement);
        	 resultSet=preparedStatement.executeQuery();
        	 
        	 if(!resultSet.isBeforeFirst())
        	 {
        		 System.out.println("User not found in the database");
        		  Alert alert=new Alert(Alert.AlertType.ERROR);
            	  alert.setContentText("Provided Credentials are incorrect");
            	  alert.show();
        	 }
        	 else
        	 {
        		 while(resultSet.next())
        		 {
        			 String retrivePassword=resultSet.getString("password");
        			 String retriveChannel=resultSet.getString("favchannel");
        			if(retrivePassword.equals(password))
        			{
        				changeScene(event, "logged-in.fxml", "Welcome",username, retriveChannel);
        			}
        			else
        			{
        				System.out.println("Password Not Match");
        				 Alert alert=new Alert(Alert.AlertType.ERROR);
                   	     alert.setContentText("Provided Credentials are incorrect");
                   	     alert.show();
        			}
        		 }
        		 
        	 }
        	 
         }
         catch(SQLException e)
         {
        	 e.printStackTrace();
         }
         

        	 finally {
            	 if(resultSet!=null)
            	 {
            		 try {
            			 resultSet.close();
            		 }
            		 catch (SQLException e) {
    					e.printStackTrace();
    				}
            	 }
            	 
            	 if(preparedStatement!=null)
            	 {
            		 try {
            			 preparedStatement.close();
            		 }
            		 catch (SQLException e) {
    					e.printStackTrace();
    				}
            	 }
            	 if(psInsert!=null)
            	 {
            		 try {
            			 psInsert.close();
            		 }
            		 catch (SQLException e) {
    					e.printStackTrace();
    				}
            	 }
            	 if(connection!=null)
            	 {
            		 try {
            			 connection.close();
            		 }
            		 catch (SQLException e) {
    					e.printStackTrace();
    				}
            	 }
            	 
             }
	}
	
}
