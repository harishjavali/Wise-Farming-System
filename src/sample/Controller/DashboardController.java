package sample.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.Databases.DBHandler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class DashboardController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private ImageView backbutton;



    @FXML
    private JFXButton Croppricebutton;

    @FXML
    private JFXButton Askhelpbutton;

    @FXML
    private JFXButton Aboutbutton;

    @FXML
    private JFXButton Cropinfobutton;


    private  int UserIDe;

    private DBHandler dbHandler;

    @FXML
    void initialize() {
        dbHandler= new DBHandler();
     ///  getUserID();

        Askhelpbutton.setOnAction(event -> {

           Askhelpbutton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/UIfiles/Askhelp.fxml"));

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

        Cropinfobutton.setOnAction(event -> {

            Cropinfobutton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/UIfiles/Cropinfo.fxml"));

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
        Croppricebutton.setOnAction(event -> {

            Croppricebutton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/UIfiles/Cropprices.fxml"));

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

      Aboutbutton.setOnAction(event -> {

           Aboutbutton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/UIfiles/About.fxml"));

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
        gobacktologinpage();




    }
    public void gobacktologinpage(){
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



