/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlphongthi;

import java.util.Scanner;

/**
 *
 * @author A510
 */
public class QLPHONGTHI {

    /**
     * @param args the command line arguments
     */
    private static PhongThi phongthi=null;
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        Scanner sc=new Scanner(System.in);
         System.out.println("*****QUẢN LÝ PHÒNG THI*****");
//==================================

    //Trần Thị Ngọc Ánh- bắt lỗi sl thí sinh là số nguyên nếu sai nhập lại
    int n=0;
    String soluong;
     boolean test;
        do
        {
            try{
                test=true;
                System.out.println("Nhập vào số lượng thí sinh của phòng:");
            n=Integer.parseInt(sc.nextLine());
          
            }
            catch(NumberFormatException e)
            {
                test=false;
                System.out.println(e.getMessage());
            }  
            finally
            {
                soluong=Integer.toString(n);
            }
        }
        while(test==false);
        
        
    phongthi=new PhongThi("pt01SE","Phòng 502, A9",n);
//==================================
    
    do {
        System.out.println("==============================================");
        System.out.println("1. Thêm Thí sinh mới");
        System.out.println("2. Hiệu chỉnh thông tin thí sinh");
        System.out.println("3. Xóa thí sinh khỏi phòng thi");
        System.out.println("4. Lấy thông tin Thí sinh khi biết số báo danh.");
        System.out.println("5. Lấy thông tin Thí sinh khi biết số thứ tự.");
        System.out.println("6. In danh sách thí sinh");
        System.out.println("7. Thoát");
        System.out.println("******************");
        System.out.print("\t**Chọn lựa của bạn? <1->7>:");
        int tl=sc.nextInt();
        switch(tl) {
        case 1: themTS();break;
        case 2: suaTTTS();break;
        case 3: xoaTS();break;
        case 4: layTTTS_soBD();break;
        case 5: layTTTS_chiso();break;
        case 6: inDanhsachTS();   break;
        case 7: System.out.println("BYE");  System.exit(1);
        }
    }while(true);
}
static void themTS() throws Exception {
        ThiSinh ts=new ThiSinh();
        ts.nhap();
        if(phongthi.themThiSinh(ts))
            System.out.println("Thêm thành công");
        else
            System.out.println("Không thêm được.");
}
static void xoaTS() {
    Scanner input=new Scanner(System.in);
    
        System.out.print("\tNhập số báo danh cần xóa:");
        String soBD=input.nextLine();
        input.nextLine();// dua con tro xuong dong tiep, tranh lay ky ty enter
        if(phongthi.xoaThisinh(soBD))
            System.out.println("Xóa thành công");
        else
            System.out.println("Không xóa được!");       
}
static void suaTTTS() throws Exception  {
    Scanner input=new Scanner(System.in);    
    System.out.print("\tNhập số báo danh cần sửa:");
    String soBD=input.nextLine();
    ThiSinh newTS=new ThiSinh();
    newTS.nhap();
    if(phongthi.suaThongtinTS(soBD, newTS))
         System.out.println("Sửa thành công");
    else
         System.out.println("Không sửa được!");    
}
static void layTTTS_chiso() {
    Scanner input=new Scanner(System.in);
    System.out.println("Nhập số thứ tự cần lấy thông tin:");
    int stt=input.nextInt();
    ThiSinh ts= phongthi.layThongtinTS(stt);
    if(ts==null)
        System.out.println("không có");
    else
        System.out.println(ts);
    
}
static void layTTTS_soBD() {
    Scanner input=new Scanner(System.in);
    System.out.print("\tNhập số báo danh cần lấy thông tin:");
    String soBD=input.nextLine();
    ThiSinh ts=phongthi.layThongtinTS(soBD);
    System.out.println("~~~~~~~~~~Kết quả~~~~~~~~~~~~~~");
    if(ts==null)
        System.out.println("Không có");
    else
        System.out.println(ts);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
}

static void inDanhsachTS() {
    System.out.println("==========DANH SÁCH THÍ SINH=========");
    System.out.println("Số BD \tHọ tên \tĐiểm toán \tĐiểm Lý \tĐiểm Hóa");
    for (int i = 0; i < phongthi.soThisinh(); i++) 
    {   
        ThiSinh ts=phongthi.layThongtinTS(i);
        System.out.println(ts);    
    }
    System.out.println("=====================================");
    }
    
}
