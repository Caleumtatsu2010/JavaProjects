package phongthithisinh;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ThiSinh
{
    protected String sbd;
    protected String hoten;
    protected float diemtoan;
    protected float diemly;
    protected float diemhoa;
    public ThiSinh(String sbd)
    {
        this.sbd = sbd;

    }
    public ThiSinh(String sbd, String hoten, float diemtoan, float diemly, float diemhoa)
    {
        sbd = this.sbd;
        hoten = this.hoten;
        diemtoan = this.diemtoan;
        diemly = this.diemly;
        diemhoa = this.diemhoa;
    }
    public ThiSinh(){}
    public void nhap()
    {
        Scanner s = new Scanner(System.in);
            do
            {
                try
                {
                    System.out.println("Nhap vao so bao danh: ");
                    checkSbd(s.nextLine());
                }catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }while(sbd == null);
            System.out.println("Nhap vao ho ten: ");
            hoten = s.nextLine();
            do
            {
                try
                {
                    System.out.println("Nhap vao diem toan: ");// sai thi throw ra exception
                    setDiemToan(checkDiem(s.nextFloat()));// gan thanh cong thi diem toan se khac null
                    System.out.println("Nhap vao diem ly: ");
                    setDiemLy(checkDiem(s.nextFloat());
                    System.out.println("Nhap vao diem hoa: ");
                    setDiemHoa(checkDiem(s.nextFloat());
                }catch(Exception e1)
                {
                    System.out.println(e1.getMessage());
                }
            }while();
 
    }
    public void setDiemToan(float diem)
    {
        try
        {
            this.diemtoan = diem;
        }
        catch(InputMismatchException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void setDiemLy(float diem)
    {
        try
        {
            this.diemly = diem;
        }
        catch(InputMismatchException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void setDiemHoa(float diem)
    {
        try
        {
            this.diemhoa= diem;
        }
        catch(InputMismatchException e)
        {
            System.out.println(e.getMessage());
        }
    }
    //kiem tra diem nhap vao
    public void checkSbd(String so) throws Exception
    {
        if(so.equals("")) throw new Exception("So bao danh ko duoc de chong");
        else
        {
            this.sbd = so;
        }
    }
    public float checkDiem(float diem) throws Exception
    {
        String diem1 = Float.toString(diem);
        DecimalFormat d = new DecimalFormat("###.0");
        String diem2 = d.format(diem);
        if(diem2.equals(diem1) == false)
        {
            throw new Exception("Diem phai dung dinh dang ###.0");
        }
        else if(diem < 0 || diem >10)
        {
            throw new Exception("Diem phai nam trong 0-10");
        }
        else
        {
            return diem;
        }

    }
    @Override
    public String toString() 
    {
        return "SBD: "+sbd+"\tHo Ten: "+hoten+"\tDiem Toan: "+diemtoan+"\tDiem Ly: "+diemly+"\tDiem Hoa: "+diemhoa; 
    }
    public boolean kiemTra()
    {
        tongdiem = diemtoan+diemly+diemhoa;
        if(tongDiem >=15 && diemtoan >=3 && diemhoa >=3 && diemly >=3) 
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static void main(String[] args) 
    {
        ThiSinh t = new ThiSinh();
        t.nhap();
        
    }
}