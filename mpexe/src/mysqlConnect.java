import java.sql.*;
import javax.swing.*;

public class mysqlConnect {
    Connection conn = null;
    public static void main(String[] args) {
        connectDB();
    }
    public static Connection connectDB(){
        try {
            Class.forName("org.h2.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:h2:./database/mph2.db;MODE=MySQL", "root", "mypassword");
            //System.out.println("Database Created");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;  
        }
    }
}
