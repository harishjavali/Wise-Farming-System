package sample.Databases;

import sample.model.Askhelp;
import sample.model.User;
import sample.Controller.loginController;

import java.sql.*;

public class DBHandler extends conf{


    Connection dbconnection;

    public Connection getDbconnection() throws ClassNotFoundException, SQLException {
        String connectionstring = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        // Class.forName("com.mysql.jdbc.Driver");
        dbconnection = DriverManager.getConnection(connectionstring, dbUser, dbPass);
        return dbconnection;
    }
    public ResultSet getUser(User user) {
        ResultSet resultSet = null;


        if (!user.getUserName().equals("") || !user.getPassword().equals("")) {
            String query = "SELECT * FROM " + Const.USERS_TABLE + " WHERE "
                    + Const.USERS_USERNAME + "=?" + " AND " + Const.USERS_PASSWORD
                    + "=?";

            // select all from users where username="harish" and password="password"

            try {
                PreparedStatement preparedStatement = getDbconnection().prepareStatement(query);
                preparedStatement.setString(1, user.getUserName());
                preparedStatement.setString(2, user.getPassword());

                resultSet = preparedStatement.executeQuery();


            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        } else {
            System.out.println("Please enter your credentials");

        }

        System.out.println("yesss!");
        return resultSet;
    }
    public void signUpUser(User user) {

        String insert = "INSERT INTO " + Const.USERS_TABLE + "(" + Const.USERS_FIRSTNAME
                + "," + Const.USERS_LASTNAME + "," + Const.USERS_USERNAME + ","
                + Const.USERS_PASSWORD + "," + Const.USERS_EMAIL + ","
                + Const.USERS_LOCATION + ")" + "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbconnection().prepareStatement(insert);

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUserName());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getLocation());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
    public void inserthelp(Askhelp askhelp){
        String insert = "INSERT INTO " + Const.ASK_HELP_TABLE + "(" + Const.ASK_HELP_USER_ID
                + "," + Const.ASK_HELP_SUBJECT + ","
                + Const.ASK_HELP_PRB_DESC + "," + Const.ASK_HELP_DATE
                + ")" + "VALUES(?,?,?,?)";
        try {
            System.out.println("user id dbhandler-"+loginController.user);
            System.out.println("sub dbhandler-"+askhelp.getSubject());
            System.out.println("problem dbhandler-"+askhelp.getProblem_description());
            System.out.println("date dbhandler-"+askhelp.getDateandtime());
            PreparedStatement preparedStatement = getDbconnection().prepareStatement(insert);
            preparedStatement.setInt(1,loginController.user );
            preparedStatement.setString(2, askhelp.getSubject());
            preparedStatement.setString(3, askhelp.getProblem_description());
            preparedStatement.setTimestamp(4, askhelp.getDateandtime());
           // preparedStatement.setString(4, askhelp.getDateandtime());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
    public ResultSet getAllTasks() throws SQLException, ClassNotFoundException {
        //ResultSet resultSet = null;

        String query = "SELECT * FROM " + Const.CROPRICE_TABLE;


        PreparedStatement preparedStatement = getDbconnection().prepareStatement(query);


        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;

//
//        while (resultSet.next()) {
//            return resultSet.getInt(1);
//        }
//        return resultSet.getInt(1);
//    }
    }
}
