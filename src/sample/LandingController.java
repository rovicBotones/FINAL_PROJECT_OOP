package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class LandingController implements Initializable {
    @FXML
    private Button gotoAdmin;
    @FXML
    private Button closeLanding;
    @FXML
    private ImageView tokenImageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*File token = new File("images/logo.png");
        Image tokenImage = new Image(token.toURI().toString());
        tokenImageView.setImage(tokenImage);*/
    }


    public void gotoAdminOnAction(ActionEvent event) {
        Stage gotoadminstage = (Stage) gotoAdmin.getScene().getWindow();
        adminLogIn();
        gotoadminstage.close();
        System.out.println("clicked!!");
    }
    public void closeOnAction(ActionEvent event){
        Stage closeStage = (Stage) closeLanding.getScene().getWindow();
        closeStage.close();
    }


    public void adminLogIn(){ //to go to the
        try{
            Parent root = FXMLLoader.load(getClass().getResource("adminLoginpage.fxml"));
            Stage adminStage = new Stage();
            adminStage.setTitle("Build Gym");
            adminStage.setScene(new Scene(root, 800, 600));
            adminStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }



}


