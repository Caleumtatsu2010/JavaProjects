/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doan;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 *
 * @author ASUS
 */
public class ListNS {
    private ArrayList<NhanSu> list;

    public ListNS() {
        list = new ArrayList<>();
    }

    public ListNS(ArrayList<NhanSu> list) {
        this.list = list;
    }

    public ArrayList<NhanSu> getList() {
        return list;
    }

    public void setList(ArrayList<NhanSu> list) {
        this.list = list;
    }
    
    public void insert(NhanSu st) {
        list.add(st);
    }
    
    public void delete(NhanSu st) {
        for (NhanSu clns : list) {
            if (clns.getMa().equals(st.getMa())) {
                list.remove(clns);
                return;
            }
        }
    }
    
    public void update(NhanSu st ) {
        for (NhanSu clns : list) {
            if (clns.getMa().equals(st.getMa())) {
                clns.setHoTen(st.getHoTen());
                clns.setTuoi(st.getTuoi());
                clns.setGioiT(st.getGioiT());
                clns.setDiaC(st.getDiaC());
                clns.setLuong(st.getLuong());
                clns.setGC(st.getGC());
                clns.setCV(st.getCV());
            }
        }
    }
    public ArrayList<NhanSu> show() {
        return list;
    }
    
    public NhanSu find(String maSV) {
        for (NhanSu sinhVien : list) {
            if (sinhVien.getMa().equals(maSV)) {
                return sinhVien;
            }
        }
        return null;
    }
        public void MySqlConnect(){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            String dbURL = "jdbc:mysql://localhost/dbqlst";
            String username = "root";
            String password = "vertrigo";
            conn = DriverManager.getConnection(dbURL, username, password);
            if(conn != null){
                System.out.println("ket noi thanh cong");
            }
            String sql = "SELECT * FROM `dbNhanSu` WHERE 1";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                NhanSu clns = new NhanSu();
                clns.setMa(rs.getString("maSV"));
                clns.setHoTen(rs.getString("tenSV"));
                clns.setTuoi(rs.getInt("tuoi"));
                list.add(clns);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
