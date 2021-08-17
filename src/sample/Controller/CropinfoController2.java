package sample.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class CropinfoController2 {

    @FXML
    private ImageView gobackcropinfo;

    @FXML
    void initialize() {
        gobacktocropinfo();
    }
    public void gobacktocropinfo(){
        gobackcropinfo.setOnMouseClicked(event ->
        {
            gobackcropinfo.getScene().getWindow().hide();
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



    }
}
