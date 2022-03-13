package Dao;

import Objects.Account;
import Objects.Category;
import Objects.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DatabaseController
{
    Connection  con;
    PreparedStatement  ps;
    ResultSet rs;
    public  DatabaseController()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wish", "root", "123456");
        } catch (Exception e)
        {
            e.getMessage();
        }
    }
    //load all product in home.jsp
    public List<Product> getAllProduct()
    {
        List<Product> list = new ArrayList<Product>();
        try
        {
           ps = con.prepareStatement("SELECT * from product");
           rs = ps.executeQuery();
           while(rs.next())
           {
               Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getInt(7));
               list.add(p);
           }
        }catch (Exception e)
        {
            e.getMessage();
        }
        return list;
    }
    //load all product by category in menu.jsp
    public List<Product> getAllProductByCategory(int cid)
    {
        List<Product> list = new ArrayList<Product>();
        try
        {
            ps = con.prepareStatement("SELECT * from product WHERE cid= ?");
            ps.setInt(1, cid);
            rs = ps.executeQuery();
            while(rs.next())
            {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                list.add(p);
            }
        }catch (Exception e)
        {
            e.getMessage();
        }
        return list;
    }
    public List<Category> getAllCategory()
    {
        List<Category> list = new ArrayList<Category>();
        try
        {
            ps = con.prepareStatement("SELECT * from category");
            rs = ps.executeQuery();
            while(rs.next())
            {
                Category c = new Category(rs.getInt(1), rs.getString(2));
                list.add(c);
            }
        }catch (Exception e)
        {
            e.getMessage();
        }
        return list;
    }
    public Product getLastProduct()
    {
        try
        {
            ps = con.prepareStatement("SELECT * FROM product ORDER BY id DESC LIMIT 1");
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getInt(7));
            }
        }catch (Exception e)
        {
            e.getMessage();
        }
        return null;

    }
    public Product getDetailProduct(int id)
    {
        try
        {
            ps = con.prepareStatement("SELECT * FROM product WHERE id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getInt(7));
            }
        }catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }
    public List<Product> getAllProductByName(String name)
    {
        List<Product> list = new ArrayList<Product>();
        try
        {
            ps = con.prepareStatement("SELECT * FROM wish.product where name like ? ");
            ps.setString(1, "%" + name + "%");
            rs = ps.executeQuery();
            while(rs.next())
            {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                list.add(p);
            }
        }catch (Exception e)
        {
            e.getMessage();
        }
        return list;
    }

    public Account login(String user, String pass)
    {
        try
        {
            ps = con.prepareStatement("select * from account where user = ? and pass = ?");
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next())
            {
                return new Account( rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
            }
        }catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }
    public boolean checkUser(String user)
    {
        boolean result=false;
        try
        {
            ps = con.prepareStatement("select * from account where user = ?");
            ps.setString(1, user);
            rs = ps.executeQuery();
            while(rs.next())
            {
                result = true;
            }
        }catch (Exception e)
        {
            e.getMessage();
        }
        return result;
    }
    public void signup(String user, String pass)
    {
        try
        {
            ps = con.prepareStatement("INSERT into account VALUES (?, ?, 0, 0)");
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.execute();
        }catch (Exception e)
        {
            e.getMessage();
        }
    }
    public List<Product> getAllProductBySell(int sell_id)
    {
        List<Product> list = new ArrayList<Product>();
        try
        {
            ps = con.prepareStatement("SELECT * FROM wish.product where sell_id = ? ");
            ps.setInt(1, sell_id);
            rs = ps.executeQuery();
            while(rs.next())
            {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                list.add(p);
            }
        }catch (Exception e)
        {
            e.getMessage();
        }
        return list;
    }
    public void deleteProductByID(int id)
    {
        try
        {
            ps = con.prepareStatement("DELETE FROM product where id = ?");
            ps.setInt(1, id);
            ps.execute();
        }catch (Exception e)
        {
            e.getMessage();
        }
    }
    public void insertProduct(int id, String name, String image, double price, String title, String sell_id, int cid)
    {
        try
        {
            ps = con.prepareStatement("insert into product values (?, ?, ?, ?, ?, ?, ? )");
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, image);
            ps.setDouble(4, price);
            ps.setString(5, title);
            ps.setString(6, sell_id);
            ps.setInt(7, cid);
            ps.execute();
        }catch (Exception e)
        {
            e.getMessage();
        }
    }
    public void updateProduct(int id, String name, String image, double price, String title, String sell_id, int cid)
    {
        try
        {
            ps = con.prepareStatement("update product set name = ?, image = ?, price = ?, title = ?, sell_id = ?, cid = ? where id = ? ");

            ps.setString(1, name);
            ps.setString(2, image);
            ps.setDouble(3, price);
            ps.setString(4, title);
            ps.setString(5, sell_id);
            ps.setInt(6, cid);
            ps.setInt(7, id);
            ps.execute();
        }catch (Exception e)
        {
            e.getMessage();
        }
    }
    public static void main(String[] args) {
        DatabaseController d = new DatabaseController();
        d.insertProduct(8, "a", "s", 2, "đ", "u", 1);
//        d.signup("long", "1234");
//        List<Product> list = d.getAllProductBySell(1);
//        for(Product i:list)
//        {
//            System.out.println(i.toString());
//        }
//        List<Category> list = d.getAllCategory();
//        for(Category i:list)
//        {
//            System.out.println(i.toString());
//        }
//        Product p = d.getDetailProduct(1);
//        System.out.println(p);

    }
}
