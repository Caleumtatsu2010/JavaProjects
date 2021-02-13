/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.sql.ResultSet;

import java.sql.SQLException;

public class DatabaseQuerry 
{
    DatabaseConnector db=null;
    ResultSet rs;

    public  DatabaseQuerry()
    {
        db = new DatabaseConnector();
        db.establishConnection("jdbc:derby://localhost:1527/SinhVien", "long", "1234");
    }
    public void createTable()
    {   
        String createSampleTable="create table SinhVien"
                                +"(name char(20) primary key,"
                                +"age int,"
                                +"address char(20))";
        db.updateQuerry(createSampleTable);
    }
    public void deleteTable()
    {
        db.updateQuerry("DELETE * FROM SinhVien");
    }
    public void showTable() 
    {
        try {
        rs = db.executeQuerry("SELECT * FROM SinhVien");
            System.out.println("\n");
        while(rs.next())
        {
            System.out.println(rs.getString("name")+"  "+rs.getInt("age")+"  "+rs.getString("address"));
        }
        } catch (Exception e) {
            System.out.println("cannot show data from table");
        }
    }
    public void add(String name, int age, String address)
    {
        String query="insert into SinhVien values('"+name+"', "+age+", '"+address+"')";
        try {
            db.updateQuerry(query);
        } catch (Exception e) {
            System.out.println("cannot add student");
        }
    }
    public void delete(String name)
    {
        String query="delete from SinhVien where name='"+name+"'";
        System.out.print("\n\n"+query);
        try 
        {
            db.updateQuerry(query);
        } catch (Exception ex) {
            System.out.println("Khong the xoa thong tin sv nay");
        }
    }
    
    public void fix()
    {
        String query="update SinhVien set address='JAPAN' where name='Nguyen Hoang Long'";
        System.out.print("\n\n"+query);
        try 
        {
            db.updateQuerry(query);
        } catch (Exception ex) {
            System.out.println("Khong the sua thong tin sv nay");
        }
    }
    
}
