package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class adminLogInController {
@FXML
    private Button addAdminbutton;
@FXML
private Button adminloginButton;
@FXML
private Button backAdmin;
@FXML
    private TextField adminName;
@FXML
    private PasswordField adminPassword;
@FXML
    private Label loginMessageLabel;


    public void newAdminButtonOnAction(ActionEvent event){
    Stage gotoadminSignUp = (Stage) addAdminbutton.getScene().getWindow();
    adminSignUp();
    gotoadminSignUp.close();
    }

    public void adminloginButtonOnAction(ActionEvent event){

    if(adminName.getText().isBlank()==false && adminPassword.getText().isBlank()==false){

        validateLogIn();


    }else{
        loginMessageLabel.setText("Please Enter Username or Password");
    }
    }
    public void backAdminOnAction(ActionEvent event){
    Stage backToLanding = (Stage) backAdmin.getScene().getWindow();
      landing();
      backToLanding.close();
    }

    public void validateLogIn(){
    DatabaseConnection db = new DatabaseConnection();
    Connection connectDb = db.getConnection();
    //System.out.println("connected to database!!");
        Stage adminLoginButtonStage = (Stage) adminloginButton.getScene().getWindow();

    String verifyLogin = "SELECT count(1) FROM tbl_admin where username ='"+ adminName.getText().toLowerCase() + "' and password ='"+ adminPassword.getText().toLowerCase() +"'";

    try {
        Statement statement = connectDb.createStatement();
        ResultSet querySet = statement.executeQuery(verifyLogin);

        while(querySet.next()){
            if (querySet.getInt(1)==1){
                logInAdmin();
                adminLoginButtonStage.close();
                loginMessageLabel.setText("Login Successful");

            }
            else if(querySet.getInt(1)==0){
                loginMessageLabel.setText("Wrong Username Or Password");
            }
            else{
                loginMessageLabel.setText("Login Invalid");
            }

        }
    }catch(Exception e){
        e.printStackTrace();
        e.getCause();
    }


}

public void adminSignUp(){
    try{
        Parent root = FXMLLoader.load(getClass().getResource("adminSignUpPage.fxml"));
        Stage signUpAdminStage = new Stage();
        signUpAdminStage.setTitle("Build Gym");
        signUpAdminStage.setScene(new Scene(root, 800, 600));
        signUpAdminStage.show();
    }catch (Exception e){
        e.printStackTrace();
        e.getCause();
    }


}
public void landing(){
    try{
        Parent root = FXMLLoader.load(getClass().getResource("landing.fxml"));
        Stage backToAdmin = new Stage();
        backToAdmin.setTitle("Build Gym");
        backToAdmin.setScene(new Scene(root, 800, 600));
        backToAdmin.show();
        //System.out.println("Backed to landingpage");
    }catch (Exception e){
        e.printStackTrace();
        e.getCause();
    }
}

public void logInAdmin(){
    try{
        Parent root = FXMLLoader.load(getClass().getResource("adminPage.fxml"));
        Stage logInStage = new Stage();
        logInStage.setTitle("Build Gym");
        logInStage.setScene(new Scene(root, 800, 600));
        logInStage.show();
        //System.out.println("Backed to landingpage");
    }catch (Exception e){
        e.printStackTrace();
        e.getCause();
    }
}




}
