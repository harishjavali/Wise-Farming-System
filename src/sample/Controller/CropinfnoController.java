package sample.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class CropinfnoController {
    @FXML
    private ImageView nextpage;

    @FXML
    private ImageView gobacktodashboard;



    @FXML
    void initialize() {
        gobacktodashboard();
        tonextpage();
        // final Random rng = new Random();
        // VBox content = new VBox(5);
        //ScrollPane scroller = new ScrollPane(content);
        //scroller.setFitToWidth(true);
//       ScrollPane scrollPane=new ScrollPane();
//       scrollPane.setContent(scrolpane);
//       scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
//        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
//        BorderPane.setMargin(scrolpane,new Insets(0,0,10,10));

        // ScrollPane scrollPane = new ScrollPane();
        //scrollPane.setContent(scrolpane);

        // Pannable.
        //scrollPane.setPannable(true);

        //Stage stage=new Stage();
        // primaryStage.setTitle("ScrollPane Demo 2 (o7planning.org)");
        //Scene scene = new Scene(scrollPane, 550, 200);
        //stage.setScene(scene);
        //stage.show();
    }

        public void gobacktodashboard () {
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

            public void tonextpage () {
            nextpage.setOnMouseClicked(event ->
            {
                nextpage.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/UIfiles/Cropinfo2.fxml"));
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

