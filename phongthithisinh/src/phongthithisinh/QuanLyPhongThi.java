package phongthithisinh;

import java.util.Scanner;
public class QuanLyPhongThi
{
    private static PhongThi p = new PhongThi("pt01SE","Phòng 502", "A9",2);
    public static void main(String[] args) 
    {
        System.out.println("*****QUẢN LÝ PHÒNG THI*****");
        PhongThi p = new PhongThi("pt01SE","Phòng 502", "A9",2);
        Scanner s = new Scanner(System.in);
        do
        {
            System.out.println("1. Thêm Thí sinh mới");
            System.out.println("2. Hiệu chỉnh thông tin thí sinh");
            System.out.println("3. Xóa thí sinh khỏi phòng thi");
            System.out.println("4. Lấy thông tin Thí sinh khi biết số báo danh.");
            System.out.println("5. Lấy thông tin Thí sinh khi biết số thứ tự.");
            System.out.println("6. In danh sách thí sinh");
            System.out.println("7. Thoát");
            System.out.print("\t**Chọn lựa của bạn? <1->7>:");
            int c = s.nextInt();
            switch(c)
            {
                case 1 : them(); break;
                case 2 :
            }

        }while(true);
        
    }
    public static void them()
    {
        ThiSinh ts = new ThiSinh();
        ts.nhap();
        if(p.checkThem(ts)) 
        {
            System.out.println("Them thanh cong");
        }
        else
        {
            System.out.println("Them that bai");
        }
    }
    public void xoa()
    {

    }
}
