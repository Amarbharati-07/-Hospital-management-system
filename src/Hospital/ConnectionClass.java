package Hospital;

import java.sql.*;

public class ConnectionClass
{
    Connection con;
    Statement stm;

    public ConnectionClass()
    {
        try 
        {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","amar1234");
            stm=con.createStatement();
        }
            
        
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new ConnectionClass();
    }
}
    
