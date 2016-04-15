package projekti;

import java.sql.*;
import javax.swing.*;

public class SqlConnection {

    public static Connection connect()
    {
         
        Connection con = null;
        try
        {
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  // load the driver
            // line below needs to be modified to include the database name, user, and password (if any)
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=SpitaliDB;user=sa;password=12;");

            System.out.println("Connected to database !");
            //JOptionPane.showMessageDialog(null, "Connected to database !");
            return con;
        }
        catch(SQLException e)
        {
           JOptionPane.showMessageDialog(null, e);
           return null;
        }
    }
}
