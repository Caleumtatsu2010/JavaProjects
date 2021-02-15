package phongthithisinh;

import java.util.ArrayList;
import java.util.Scanner;

public class PhongThi 
{
    private String maphong;
    private String tenphong;
    private String diachi;
    private int sothisinh;
    public ArrayList<ThiSinh> a = new ArrayList<ThiSinh>();
    public PhongThi(){}
    public PhongThi(String maphong, String tenphong, String diachi, int sothisinh)
    {
        this.maphong = maphong;
        this.tenphong = tenphong;
        this.diachi = diachi;
        this.sothisinh = sothisinh;
    }

    public boolean checkThem(ThiSinh ts)// nhap dc goi = sothisinh
    {
        
        if(a.contains(ts) == true) return false;// doi tuong da co trong mang 
        else
        {
            a.add(ts);//add du n lan se tu ngung
            return true;
        }
    }
    public boolean checkXoa(String id)//tim sbd trong mang roi xoa
    {
        for(int i=0;i<a.size();i++)
        {
            if(a.get(i).sbd = id)
            {
                a.remove(i);
                return true;
            }
            else
            {
                return false;
            }
        }
    }
    public boolean checkSuaTT(ThiSinh ts , String id)// sua doi tuong da co mat trong mang
    {
        ThiSinh t = new ThiSinh(id);
        if(a.contains(ts))
        {
            a.set(a.indexOf(t), ts)
            return true;
        }
        else
        {
            return false;
        }  
    }
    public void checkLayTT(String id)
    {
        ThiSinh ts = new ThiSinh(id);
        if(a.contains(ts))
        {
            return a.get(a.indexOf(ts));
        }
    }

}