package sample.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.Databases.DBHandler;
import sample.model.Askhelp;

import java.io.IOException;
import java.util.Calendar;

public class AskhelpController {

    private int UserIDa;
    @FXML
    private JFXTextArea querydescription;


    @FXML
    private ImageView querybackbutton;

    @FXML
    private JFXButton submitbutton;

    @FXML
    private Label queryreply;

    @FXML
    private JFXTextField querysubject;

    private DBHandler dbHandler;
  //  private Object Askhelp;

    @FXML
    void initialize() {
        dbHandler = new DBHandler();
      //  Askhelp askhelp = new Askhelp();
        gobacktodashboard();
       // submithelp();
        System.out.println("userid-----" + loginController.user);

    //public void submithelp(){

        submitbutton.setOnAction(event -> {
           Askhelp askhelp=new Askhelp();

            Calendar calendar = Calendar.getInstance();

            java.sql.Timestamp timestamp =
                    new java.sql.Timestamp(calendar.getTimeInMillis());

        String asksubject=querysubject.getText();
        String askdesc=querydescription.getText();
        querysubject.setText("");
        querydescription.setText("");
        queryreply.setVisible(true);

       if(!asksubject.equals("")||!askdesc.equals("")){
//           System.out.println("ss");
     askhelp.setUserid(loginController.user);
//           askhelp.setSubject(asksubject);
//           askhelp.setProblem_description(askdesc);
//           askhelp.setDateandtime("fsdfd");
          // String d="adsads";
           int u=loginController.user;
           System.out.println("u is"+","+u);
           Askhelp askhelp1=new Askhelp(asksubject,askdesc,timestamp);

           dbHandler.inserthelp(askhelp1);
       }
       else {
           System.out.println("Nothing added!");

       }

    });
}



    public void gobacktodashboard(){
        querybackbutton.setOnMouseClicked(event ->
        {
            querybackbutton.getScene().getWindow().hide();
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



