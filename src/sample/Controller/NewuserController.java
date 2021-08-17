package sample.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.Databases.DBHandler;
import sample.model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewuserController {
    @FXML
    private ResourceBundle resources;



    @FXML
    private URL location;

    @FXML
    private JFXTextField newuseremail;

    @FXML
    private JFXButton gobacktologin;


    @FXML
    private Label successlabel;

    @FXML
    public ImageView backbutton;

    @FXML
    private JFXTextField newusername;

    @FXML
    private JFXTextField newuserlname;

    @FXML
    private JFXTextField newuserfname;

    @FXML
    private JFXButton signupbutton;

    @FXML
    private JFXPasswordField newuserpassword;

    @FXML
    private JFXTextField newuserlocation;
    @FXML
    void initialize() {
        gobacktologin();
        signupbutton.setOnAction(event -> {

            createUser();
            goback();
        });}



//            FXMLLoader loader = new FXMLLoader();
//
//
//
//            try {
//                loader.load();
//
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            Parent root = loader.getRoot();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//
//            stage.show();
//
//
//
//        });


  //  }

    private void createUser() {

        DBHandler databaseHandler = new DBHandler();


        String name = newuserfname.getText();
        String lastName = newuserlname.getText();
        String userName = newusername.getText();
        String password = newuserpassword.getText();
        String email = newuseremail.getText();
        String location = newuseremail.getText();


        User user = new User(name, lastName, userName, password, email, location);


        databaseHandler.signUpUser(user);
    }

         public void goback() {
             successlabel.setVisible(true);
             gobacktologin.setVisible(true);
             newusername.setText("");
             newuserfname.setText("");
             newuserlname.setText("");
             newuserpassword.setText("");
             newuseremail.setText("");
             newuserlocation.setText("");

             gobacktologin.setOnAction(event -> {

                 gobacktologin.getScene().getWindow().hide();
                 FXMLLoader loader = new FXMLLoader();
                 loader.setLocation(getClass().getResource("/sample/UIfiles/login.fxml"));
                 try {
                     loader.load();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }

                 Parent root = loader.getRoot();
                 Stage stage = new Stage();
                 stage.setScene(new Scene(root));
                 stage.show();


             });
         }
         public void gobacktologin(){
        backbutton.setOnMouseClicked(event ->
        {
            backbutton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/UIfiles/login.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        });



    }



    }

