package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.Statement;

public class adminSignUpController {
   @FXML
    private TextField adminname;
   @FXML
    private PasswordField adminPassword;
   @FXML
    private PasswordField confirmAdminPassword;
   @FXML
    private Button adminConfirmButton;
   @FXML
    private Button adminBackButton;
   @FXML
   private Label AdminSignUpMessageLabel;


   public void adminConfirmButtonOnAction(){

       if(adminPassword.getText().equals(confirmAdminPassword.getText())){
            if(adminPassword.getText().isBlank()==false && adminname.getText().isBlank()==false){
                AdminSignUpMessageLabel.setText("SignUp Success!");
                registerAdmin();
            }else {
                AdminSignUpMessageLabel.setText("Please Enter AdminName or Password");
            }

       }else{
           AdminSignUpMessageLabel.setText("Password didn't match");
       }
   }

   public void registerAdmin(){
       DatabaseConnection db = new DatabaseConnection();
       Connection connectDb = db.getConnection();

        String adminName = adminname.getText();
        String adminPass = adminPassword.getText();

        String insertField = "INSERT INTO tbl_admin (username, password) VALUES (";
        String insertValues = "'" + adminName + "'" +","+ "'" + adminPass+"')";
        String insertToRegister = insertField + insertValues;


       try {
           Statement statement = connectDb.createStatement();
           statement.executeUpdate(insertToRegister);

       }catch(Exception e){
           e.printStackTrace();
           e.getCause();
       }

   }

   public void adminBackButtonOnAction(){

            Stage backToLanding = (Stage) adminBackButton.getScene().getWindow();
            backToLoginAdmin();
            backToLanding.close();

   }

    //back button
   public void backToLoginAdmin(){
       try{
           Parent root = FXMLLoader.load(getClass().getResource("adminLoginpage.fxml"));
           Stage backtoLoginAdminStage = new Stage();
           backtoLoginAdminStage.setTitle("Build Gym");
           backtoLoginAdminStage.setScene(new Scene(root, 800, 600));
           backtoLoginAdminStage.show();
       }catch (Exception e){
           e.printStackTrace();
           e.getCause();
       }
   }


}
