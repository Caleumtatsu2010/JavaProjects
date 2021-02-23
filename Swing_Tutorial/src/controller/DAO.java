/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Student;

/**
 *
 * @author Than
 */
public class DAO {
    private Connection conn;
    
    public DAO(){
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SinhVien","long", "1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
                String createSampleTable="create table tblStudent"
                        +"(Id char(20) primary key,"
                        +"name nchar(20),"
                        +"dob nchar(20),"
                        +"address nchar(20),"
                        +"email nchar(20),"
                        +"mark int,"
                        +"address char(20))";
        try {
            PreparedStatement ps = conn.prepareStatement(createSampleTable);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean addStudent(Student s)
    {
        String sql = "INSERT INTO tblStudent(ID, name, dob, address, phone, email, mark) "
                + "VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getID());
            ps.setString(2, s.getName());
            ps.setDate(3, new Date(s.getDob().getTime()));
            ps.setString(4, s.getAddress());
            ps.setString(5, s.getPhone());
            ps.setString(6, s.getEmail());
            ps.setFloat(7, s.getMark());
            
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public ArrayList<Student> getListStudent(){
        ArrayList<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM tblStudent";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Student s = new Student();
                s.setID(rs.getString("ID"));
                s.setName(rs.getString("name"));
                s.setDob(rs.getDate("dob"));
                s.setAddress(rs.getString("address"));
                s.setPhone(rs.getString("phone"));
                s.setEmail(rs.getString("email"));
                s.setMark(rs.getFloat("mark"));
                
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    public static void main(String[] args) {
        new DAO();
    }
}
