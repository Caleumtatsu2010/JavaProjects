/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyenduyquang_2018603149;

import java.util.Scanner;

/**
 *
 * @author quang
 */
public class TaiSan {
    public String tenTaiSan;
    public int soLuong;
    public String tinhTrang;

    public TaiSan() {
    }

    public TaiSan(String tenTaiSan, int soLuong, String tinhTrang) {
        this.tenTaiSan = tenTaiSan;
        this.soLuong = soLuong;
        this.tinhTrang = tinhTrang;
    }

    public String getTenTaiSan() {
        return tenTaiSan;
    }

    public void setTenTaiSan(String tenTaiSan) {
        this.tenTaiSan = tenTaiSan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
    public void nhap(){
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap ten tai san :");
        String tenTaiSan = in.nextLine();
        
        System.out.println("Nhap so luong cua tai san :");
        int soLuong  = in.nextInt();
        in.nextLine();
        
        System.out.println("Nhap tinh trang cua tai san :");
        String tinhTrang = in.nextLine();
        
        this.tenTaiSan = tenTaiSan;
        this.soLuong = soLuong;
        this.tinhTrang = tinhTrang;
    }
    
    
    public void xuat(){
        
        
        System.out.println("Ten tai san : " + this.getTenTaiSan());
        System.out.println("So luong tai san : "+this.getSoLuong());
        System.out.println("Tinh trang tai san : "+this.getTinhTrang());
    }
}
