package DAO;

import entity.ProductEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ProductDAO
{
   static List<ProductEntity>  products=null;

    public static List<ProductEntity> getAllProducts()
    {
        Session session = Utils.getSession();
        try {

            String sql = "select st from ProductEntity st";
            Query query =  session.createQuery(sql);
            products =  query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        }
        return products;
    }
    public static void main(String[] args) {
        List<ProductEntity> productList =  ProductDAO.getAllProducts();
        for (ProductEntity item:productList) {
            System.out.println(item.getName());

        }
    }



}
