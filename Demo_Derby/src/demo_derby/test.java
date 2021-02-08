/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_derby;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author admin
 */
public class test 
{
    private Connection con=null;
    private Statement st=null;
    private ResultSet rs=null;
    
    
    // nạp driver của JavaDB và 
    
    public void establishConnection()
    {
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        try {
            Class.forName(driver);
            System.out.println("nap driver thanh cong");
        } catch (ClassNotFoundException ex) {
            System.out.println("Loi: khong the nap Driver!");
            System.exit(1);
        }
        //khởi tạo kết nối đến CSDL
  
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=test", "long", "1234");
        } catch (SQLException ex) {
            System.out.println("Loi: khong the ket noi den Database");
            System.exit(1);
        }
    }
    public static void main(String[] args) {
        test t = new test();
        t.establishConnection();
    }
}
        
