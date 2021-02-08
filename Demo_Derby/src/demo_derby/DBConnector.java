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
 * @author Administrator
 */
public class DBConnector {
    private Connection con=null;
    private Statement st=null;
    private ResultSet rs=null;
    
    
    // nạp driver của JavaDB và 
    public void establishConnection(String url, String user, String password){
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
            con= DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("Loi: khong the ket noi den Database");
            System.exit(1);
        }
    }
    
    
    //Hàm này tạo ra đối tượng statement thực thi câu lệnh
    protected  Statement getStatement()throws Exception{
        if(this.st==null || this.st.isClosed())
        {
            this.st=this.con.createStatement();
        }
        return this.st;
    }
    
    
    //Hàm truyền vào câu lệnh truy vấn, trả về đối tượng ResultSet chứa kết quả
    public ResultSet queryData(String query) throws Exception{
        try {
            rs=getStatement().executeQuery(query);
        } catch (SQLException ex) {
            throw new Exception("Loi: Thuc thi cau lenh khong thanh cong");
        }
        return rs;
    }
    
    
    //Hàm thực thi các lệnh update,insert,delete...
    public void updateData(String query) throws Exception{
        try {
            getStatement().executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("Loi: Khong the update du lieu");
        }
    }
   
    
    //Hàm đóng kết nối đến CSDL
    public void closeConnection(){
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println("Loi: Dong ket noi that bai, khong the ket noi den CSDL");
        }
    }
}
