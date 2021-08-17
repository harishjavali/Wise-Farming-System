package sample.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Databases.DBHandler;
import sample.animations.Shaker;
import sample.model.User;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class loginController {
    @FXML
    private ResourceBundle resources;


private int userid;
    private  int UserID;

    @FXML
    private URL location;
   public static int user;
    @FXML
    private JFXButton newuserbutton;

    @FXML
    private JFXTextField loginUsername;

    @FXML
    private JFXPasswordField loginpassword;

    @FXML
    private JFXButton loginbutton;

    private DBHandler dbHandler;
    @FXML
    void initialize() {
        dbHandler= new DBHandler();

        loginbutton.setOnAction(event -> {

            String loginTxt=loginUsername.getText().trim();
            String loginPwd=loginpassword.getText().trim();
            User user=new User();
            user.setUserName(loginTxt);
            user.setPassword(loginPwd);

            ResultSet userRow=dbHandler.getUser(user);

            int counter = 0;

            try {

                while (userRow.next()) {
                    System.out.println("yes2");
                    counter++;
                    UserID=userRow.getInt("user_id");
                    System.out.println("useridlogin"+ ","+UserID);
                    setuserid(UserID);

                    //  String name = UserRow.getString("firstname");
                    //userId = UserRow.getInt("user_id");


                    //   System.out.println("Welcome! " + name);



                }

                if (counter == 1) {
                    System.out.println("login successfull!");

                    showDashboard();

                }else {
                    loginpassword.setText("");
                    loginUsername.setText("");
                    Shaker userNameShaker = new Shaker(loginUsername);
                    Shaker passwordShaker = new Shaker(loginpassword);
                    passwordShaker.shake();
                    userNameShaker.shake();
                    loginpassword.setText("");
                    loginUsername.setText("");

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        newuserbutton.setOnAction(event -> {

            //Take users to signup screen
            newuserbutton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(getClass().getResource("/sample/UIfiles/Newuser.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();



        });

    }
    private void showDashboard() {
        //Take users to screen
        loginbutton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/sample/UIfiles/Dashboard.fxml"));

        try {
            loader.setRoot(loader.getRoot());
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));


        user=userid;
        System.out.println("uer login2"+user);
        stage.show();
    }


    public void setuserid(int UserID) {
        userid = UserID;

    }

    }


