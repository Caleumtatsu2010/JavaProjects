/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngovanthang_de3;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author thang
 */
public class Phieu {
    String maPhieu;
    String ngaykiemke;
    String nhanvienkiemke;
    String chucVu;
    String kiemketaiphong;
    String maphong;
    String truongphong;
    TreeSet<TaiSan> ts= new TreeSet<TaiSan>();
    public void nhap() throws Exception{
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhap ma phieu");
        maPhieu = sc.nextLine();
        LocalDate ld = LocalDate.now();
        int date = ld.getDayOfMonth();
        int newDate = date -1;
        ngaykiemke = newDate+"/"+ld.getMonthValue()+"/"+ld.getYear();
        System.out.println("nhap nhan vien kiem ke:");
        nhanvienkiemke=sc.nextLine();
        System.out.println("nhap chuc vu");
        chucVu=sc.nextLine();
        System.out.println("nhap phong kiem ke");
        kiemketaiphong=sc.nextLine();
        System.out.println("nhap ma phong");
        maphong=sc.nextLine();
        System.out.println("nhap truong phong");
        truongphong=sc.nextLine();
        System.out.println("nhap so luong tai san");
        int n =sc.nextInt();
        for(int i=1;i<=n;i++){
            System.out.println("nhap tai san thu "+i+":");
            TaiSan tsTemp = new TaiSan();
            tsTemp.nhap();
        }
    }
    public void xuat(){
        System.out.println("\t\t\tPHIEU KIEM KE TAI SAN\n");
        System.out.println("ma phieu:"+maPhieu+"ngay kiem ke:"+ngaykiemke);
        System.out.println("nhan vien kiem ke:"+nhanvienkiemke+"Chuc vu:"+chucVu);
        System.out.println("Kiem ke tai phong:"+kiemketaiphong);
        System.out.println("ma phong:"+maphong+"truong phong"+truongphong);
        System.out.println("Ten tai san" + "So luong" + "tinh trang");
        for (TaiSan t : ts) {
            System.out.printf(t.getTenTaiSan(),t.getSoluong(),t.getTinhTrang());
        }
        
        System.out.println("So tai san kiem ke:");
        
    }
    
}
