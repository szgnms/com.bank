package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    static String url= "jdbc:postgresql://localhost:5432/bank_db";
    static String username="szgn";
    static String password= "22442017Ms*.";
    static Connection conn  ;
    static Statement st  ;

    static {

        try {
            conn = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        try {
            st=conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }






}
