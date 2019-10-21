import java.sql.*;
import javax.swing.*;

public class mysqlConnect {
    Connection conn = null;
    
    public static Connection connectDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //loading the driver
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mp","root","123456");
            //JOptionPane.showMessageDialog(null, "Connection is successful");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;  
        }
    }
    
}
