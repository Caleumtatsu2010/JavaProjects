/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class MySqlConnect {
    private  Connection conn;
    private String url = "jdbc:mysql://localhost/qlst";
    public void connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            try {
                conn = DriverManager.getConnection(url,"root","");
                System.out.println("ket noi thanh cong");
            } catch (SQLException ex) {
                Logger.getLogger(MySqlConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        catch(ClassNotFoundException ex){
             Logger.getLogger(MySqlConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet GetData(String jTable1) throws SQLException{
        ResultSet Kq = null;
        Statement st = conn.createStatement();
        String sql= "SELECT * FROM nhansu";
        Kq = st.executeQuery(sql);
        return Kq;
    }
}
