/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngovanthang_de3;

import java.util.Scanner;

/**
 *
 * @author thang
 */
public class TaiSan {
    String tenTaiSan;
    int soluong;
    String tinhTrang;

    public String getTenTaiSan() {
        return tenTaiSan;
    }

    public void setTenTaiSan(String tenTaiSan) {
        this.tenTaiSan = tenTaiSan;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    public void nhap() throws Exception{
        Scanner sc= new Scanner(System.in);
        System.out.println("nhap ten tai san:");
        String tentaisan = sc.nextLine();
        if(tentaisan.equals("")){
               throw new Exception("ten tai san khong de trong");
        }
        else{
                this.tenTaiSan=tentaisan;
        }
        System.out.println("nhap tinh trang:");
        tinhTrang=sc.nextLine();
        System.out.println("nhap so luong:");
        soluong=sc.nextInt();
    }
    
}
