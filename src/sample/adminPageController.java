package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class adminPageController implements Initializable {

    @FXML
    private Button signOutButton;
    @FXML
    private Button createMemberAccount;
    @FXML
    private TableView<Members> memberListTableview;

    @FXML
    private TableColumn<Members, Integer> idTableColumn;

    @FXML
    private TableColumn<Members,String> nameTableColumn;

    @FXML
    private TableColumn<Members, String> genderTableColumn;

    @FXML
    private TableColumn<Members, Double> weightTableColumn;

    @FXML
    private TableColumn<Members, Double> heightTableColumn;

    @FXML
    private TableColumn<Members, Double> bmiTableColumn;

    ObservableList<Members> membersObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDb = connection.getConnection();

        String memberViewQuery = "SELECT `Id`, `Name`, `Gender`, `Weight`, `Height`, `Bmi` FROM `tbl_member`";

        try{
            Statement statement = connectDb.createStatement();
            ResultSet querySet = statement.executeQuery(memberViewQuery);


            while(querySet.next()){
                Integer queryId = querySet.getInt("Id");
                String queryName = querySet.getString("Name");
                String queryGender = querySet.getString("Gender");
                Double queryWeight = querySet.getDouble("Weight");
                Double queryHeight = querySet.getDouble("Height");
                Double queryBmi = querySet.getDouble("Bmi");

                membersObservableList.add(new Members(queryId, queryName,queryGender, queryWeight,queryHeight,queryBmi ));

            }
            idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            genderTableColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
            weightTableColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
            heightTableColumn.setCellValueFactory(new PropertyValueFactory<>("height"));
            bmiTableColumn.setCellValueFactory(new PropertyValueFactory<>("Bmi"));

            memberListTableview.setItems(membersObservableList);

        }catch (SQLException e){
            Logger.getLogger(newMemberSignUpController.class.getName()).log(Level.SEVERE,null,e);
            e.printStackTrace();
        }

    }



    public void createMemberAccountOnAction(){
        Stage createMemberAccountStage = (Stage) createMemberAccount.getScene().getWindow();
        getCreateMemberAccount();
        createMemberAccountStage.close();
    }


    public void adminSignOutButtonOnAction(){
        Stage adminSignOutStage = (Stage) signOutButton.getScene().getWindow();
        adminSignOut();
        adminSignOutStage.close();
    }

    public void adminSignOut(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("adminLoginpage.fxml"));
            Stage adminSignOutStage = new Stage();
            adminSignOutStage.setTitle("Build Gym");
            adminSignOutStage.setScene(new Scene(root, 800, 600));
            adminSignOutStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void getCreateMemberAccount(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("newMemberSignUp.fxml"));
            Stage createMemberAccountStage = new Stage();
            createMemberAccountStage.setTitle("Build Gym");
            createMemberAccountStage.setScene(new Scene(root, 800, 600));
            createMemberAccountStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

}
