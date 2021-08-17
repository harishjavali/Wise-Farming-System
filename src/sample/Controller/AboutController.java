package sample.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class AboutController {

    @FXML
    private ImageView gobacktodashboard;

    @FXML
    void initialize() {

        gobacktologinpage();
    }

    public void gobacktologinpage(){
        gobacktodashboard.setOnMouseClicked(event ->
        {
            gobacktodashboard.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/UIfiles/Dashboard.fxml"));
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


