package sample;


import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public Connection databaselink;
    // Xampp Mysql Database
    public Connection getConnection() {
        String username = "root";
        String password = "1234";
        String url = "jdbc:mysql://localhost/db_gym";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
                    databaselink = DriverManager.getConnection(url,username,password);

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    return databaselink;
    }
}








