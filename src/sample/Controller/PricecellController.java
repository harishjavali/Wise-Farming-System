package sample.Controller;

import com.jfoenix.controls.JFXListCell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import sample.Databases.DBHandler;
import sample.model.Cropprices;

import java.io.IOException;
import java.sql.ResultSet;

public class PricecellController extends JFXListCell<Cropprices> {

    @FXML
    private Label cropprice;

    @FXML
    private Label cropname;

    @FXML
    private AnchorPane cellanchorpane;
    private DBHandler dbHandler;
    private FXMLLoader fxmlLoader;
    private Cropprices cropprices;

    @FXML
    void initialize() {
    }

    @Override
    public void updateItem(Cropprices myTask, boolean empty) {


        dbHandler = new DBHandler(); //main change

        super.updateItem(myTask, empty);

        if (empty || myTask == null) {
            setText(null);
            setGraphic(null);
        } else {

            if (fxmlLoader == null) {
                fxmlLoader = new FXMLLoader(getClass()
                        .getResource("/sample/UIfiles/pricecell.fxml"));
                fxmlLoader.setController(this);

                try {
                    fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            cropname.setText(myTask.getCropname());
            cropprice.setText(myTask.getCropprice());
            //descriptionLabel.setText(myTask.getDescription());
            setText(null);
            setGraphic(cellanchorpane);
        }
    }}