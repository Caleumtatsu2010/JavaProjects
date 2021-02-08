/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_derby;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Demo_Derby 
{
    static DBConnector dbc=new DBConnector();
    static ResultSet rs=null;
    static String query=null;
    
    private static final String createSampleTable="create table SinhVien"
                                +"(maSV char(10) primary key,"
                                +"hoTen varchar(30) not null,"
                                +"gioiTinh varchar(3),"
                                +"diemToan float,"
                                +"diemLy float,"
                                +"diemHoa float)";
    private static final String insertSampleData="insert into SinhVien values"
                                +"('1000000000', 'Nguyen Van An', 'Nam', 6, 7, 8),"
                                +"('1000000001', 'Le Thanh Son', 'Nam', 7.5, 7, 8.5),"
                                +"('1000000002', 'Tran Thi Trang', 'Nu', 8.5, 8, 9.5),"
                                +"('1000000003', 'Nguyen Thu Huong', 'Nu', 7.5, 7, 9),"
                                +"('1000000004', 'Do Duc Hung', 'Nam', 6, 6.5, 7.5)";

    
    static void taoBangMau() throws Exception
    {
         dbc.updateData(createSampleTable);
         dbc.updateData(insertSampleData);
    }
    
    static void themSV()
    {
        query="insert into SinhVien values('1000000005', 'Nguyen Thanh Tuyen', 'Nam', 6.5,8.5,7)";
        System.out.print("\n\n"+query);
        try 
        {
            dbc.updateData(query);
        } catch (Exception ex) {
            System.out.println("Khong the them moi sinh vien");
        }
    }
    
    static void suaSV(){
        query="update SinhVien set hoTen='Tran Minh Duc' where maSV='1000000001'";
        System.out.print("\n\n"+query);
        try 
        {
            dbc.updateData(query);
        } catch (Exception ex) {
            System.out.println("Khong the sua thong tin sv nay");
        }
    }
    
    static void xoaSV(){
        query="delete from SinhVien where maSV='1000000005'";
        System.out.print("\n\n"+query);
        try 
        {
            dbc.updateData(query);
        } catch (Exception ex) {
            System.out.println("Khong the xoa thong tin sv nay");
        }
    }
    
    static void inDS() throws Exception
    {
        rs=dbc.queryData("select * from SinhVien");
        SinhVien.showTitle();
        try 
        {
            while(rs.next()){
                String s= String.format("%-15s%-30s%-15s%-10s%-10s%-10s",
                        rs.getString("maSV"),rs.getString("hoTen"),rs.getString("gioiTinh"),
                        rs.getFloat("diemToan"),rs.getFloat("diemLy"),rs.getFloat("diemHoa"));
                
                System.out.println(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Demo_Derby.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        static void preparedStmtSample() throws SQLException, Exception
    {
        Connection con2=DriverManager.getConnection("jdbc:derby://localhost:1527/SinhVienDB","long","1234");
        System.out.println("Minh hoa prepared statement");
        System.out.print("update SinhVien set hoTen=? where MaSV=? //hoTen=New_Name, MaSV=1000000004");
        PreparedStatement pst=con2.prepareStatement("update SinhVien set hoTen=? where MaSV=?");
        pst.setString(1, "New_Name");
        pst.setString(2,"1000000004");
        pst.executeUpdate();
        inDS();
        con2.close();
    }
    
    
    public static void main(String[] args) throws SQLException, Exception 
    {
        dbc.establishConnection("jdbc:sqlserver://DESKTOP-7BD77N3\\SQLEXPRESS:1433/test", "long", "1234");
        taoBangMau();
        System.out.println("Bang SinhVien sau lan tao dau tien");
        inDS();
        themSV();
        inDS();
        suaSV();
        inDS();
        xoaSV();
        inDS();
        dbc.updateData("drop table SinhVien");
        dbc.closeConnection();
    }
  
        
        //Thao tac them/sua/xoa voi Statement
//        themSV();
//        inDS();
//        suaSV();
//        inDS();
//        xoaSV();
//        inDS();
        
        //Minh hoa PreparedStatement
//        System.out.println("");
//        preparedStmtSample();

}
