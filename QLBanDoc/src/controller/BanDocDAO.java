/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import model.BanDoc;

/**
 *
 * @author Than
 */
public class BanDocDAO {
    private Connection conn;
    //net.ucanaccess.jdbc.UcanaccessDriver
    // .accdb 
    public BanDocDAO() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            conn = DriverManager.getConnection("jdbc:ucanaccess://QLBanDoc.accdb");
        } catch (Exception e) {
        }
    }
    
    public ArrayList<BanDoc> selectQuery(){
        ArrayList<BanDoc> list = new ArrayList<>();
        String sql="SELECT * FROM tblBanDoc";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                BanDoc b = new BanDoc();
                b.setId(rs.getInt(8));
                b.setName(rs.getString(1));
                b.setAddress(rs.getString(2));
                b.setPhoneNumber(rs.getString(3));
                b.setKindOfReader(rs.getString(4));
                b.setDateOfBirth(rs.getDate(5));
                b.setStartDate(rs.getDate(6));
                b.setEndDate(rs.getDate(7));
                list.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    public boolean addNewReader(BanDoc b){
       String sql= "INSERT INTO tblBanDoc(ID, Name, Address, PhoneNumber, KindOfReader, DateOfBirth, StartDate, EndDate)"
               + "VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, b.getId());
            ps.setString(2, b.getName());
            ps.setString(3, b.getAddress());
            ps.setString(4, b.getPhoneNumber());
            ps.setString(5, b.getKindOfReader());
            ps.setTimestamp(6, new Timestamp(b.getDateOfBirth().getTime()));
            ps.setTimestamp(7, new Timestamp(b.getStartDate().getTime()));
            ps.setTimestamp(8, new Timestamp(b.getEndDate().getTime()));
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
}
