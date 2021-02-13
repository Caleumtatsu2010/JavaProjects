/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author admin
 */
public class DatabaseConnector 
{
    private Connection con=null;
    private Statement statement=null;
    private ResultSet resultset=null;
    public void establishConnection(String url, String user, String password) //add jar/folder first
    {
        //load driver
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            System.out.println("load driver successful");
        } catch (Exception e) 
        {
            System.out.println("Cannot loading driver");
        }
        //open connection to database
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("connect database successful");
        } catch (Exception e) {
            System.out.println("Cannot connect to database");
        }
        //create statement to execute
        try {
            statement=con.createStatement();
            System.out.println("create statement successful");
        } catch (Exception e) {
            System.out.println("Cannot create statement");
        }

    }
    public  ResultSet executeQuerry(String querry)//execute querry and return result
    {
        try {
            resultset = statement.executeQuery(querry);
        } catch (SQLException e) {
            System.out.println("cannot execute querry");
        }
        return resultset;
    }
    public void updateQuerry(String querry)//execute without return(create, update, insert, delete)
    {
        try {
            statement.executeUpdate(querry);
        } catch (SQLException e) {
            System.out.println("cannot update querry");
        }
    }
    public void closeConnection()//close connection
    {
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println("cannot close connection");
        }
    }

}
