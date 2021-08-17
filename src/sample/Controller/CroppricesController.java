package sample.Controller;

import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.Databases.DBHandler;
import sample.model.Cropprices;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CroppricesController {
    @FXML
    private JFXListView<Cropprices> listviewpage;

    @FXML
    private ImageView goback;
   // private Cropprices cropprices;
    private ObservableList<Cropprices> cropprices1;
    private DBHandler dbHandler;


    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        System.out.println("initialize called");

        cropprices1 = FXCollections.observableArrayList();
    dbHandler=new DBHandler();
        ResultSet resultSet=dbHandler.getAllTasks();
        while (resultSet.next()){
       Cropprices cropprices=new Cropprices();
       cropprices.setCropname(resultSet.getString("cropname"));
            System.out.println("cropnames--"+resultSet.getString("cropname"));
       cropprices.setCropprice(resultSet.getString("cropprice"));
            System.out.println("cropprices--"+resultSet.getString("cropprice"));
       cropprices1.addAll(cropprices);

        }
       listviewpage.setItems(cropprices1);
        listviewpage.setCellFactory(PricecellController->new PricecellController());
        gobacktodashboard();
    }

    public void gobacktodashboard(){
        goback.setOnMouseClicked(event ->
        {
            goback.getScene().getWindow().hide();
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
