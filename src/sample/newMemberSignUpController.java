package sample;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;


import javafx.stage.Stage;


import java.sql.Connection;
import java.sql.Statement;



public class newMemberSignUpController {

    @FXML
    private Button cancelMemberSignUpButton;

    @FXML
    private TextField getMemberName;
    @FXML
    private TextField getMemberGender;
    @FXML
    private TextField getMemberWeight;
    @FXML
    private TextField getMemberHeight;
    @FXML
    private Label CreateMemberMessageLabel;









    public void registerMemberButtonOnAction(){
        if(getMemberName.getText().isBlank()==false && getMemberGender.getText().isBlank()==false && getMemberHeight.getText().isBlank()==false && getMemberWeight.getText().isBlank()==false ){
            System.out.println("added a new Member");
            CreateMemberMessageLabel.setText("Added a new Member");
            registerMember();
        }else{
            CreateMemberMessageLabel.setText("Please Enter your Details");
        }
    }

    public void registerMember(){
        DatabaseConnection db = new DatabaseConnection();
        Connection connectDb = db.getConnection();

        String memberName = getMemberName.getText();
        String memberGender = getMemberGender.getText();
        double intMemberHeight = Double.parseDouble(getMemberHeight.getText());
        double intMemberWeight = Double.parseDouble(getMemberWeight.getText());

        double memberBmi = 10000 * intMemberWeight / intMemberHeight / intMemberHeight;

        String insertFieldMember = "INSERT INTO `tbl_member` (`name`, `gender`, `weight`, `height`, `bmi`) VALUES (";
        String insertValuesMember = "'"+memberName+"', '"+memberGender+"', '"+intMemberWeight+"', '"+intMemberHeight+"','"+memberBmi+"')";
        String insertToRegisterMember = insertFieldMember + insertValuesMember;

        try{
            Statement stmt = connectDb.createStatement();
            stmt.executeUpdate(insertToRegisterMember);

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }



    public void cancelMemberSignUpButtonOnAction(){
        Stage cancelMemberSignUpButtonStage = (Stage) cancelMemberSignUpButton.getScene().getWindow();
        getCancelMemberSignUpButton();
        cancelMemberSignUpButtonStage.close();
    }

    public void getCancelMemberSignUpButton(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("adminPage.fxml"));
            Stage cancelMemberSignUpButtonStage = new Stage();
            cancelMemberSignUpButtonStage.setTitle("Build Gym");
            cancelMemberSignUpButtonStage.setScene(new Scene(root, 800, 600));
            cancelMemberSignUpButtonStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }


}
