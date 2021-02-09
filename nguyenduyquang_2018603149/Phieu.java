/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyenduyquang_2018603149;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author quang
 */
public class Phieu {
    public String maPhieu;
    public String tenNhanVienKiemKe;
    public String chucVu;
    public String tenPhongKiemKe;
    public String maPhong;
    public String tenTruongPhong;
    
    public Vector<TaiSan> taiSan;

    public Phieu() {
    }

    public Phieu(String maPhieu, String tenNhanVienKiemKe, String chucVu, String tenPhongKiemKe, String maPhong, String tenTruongPhong, Vector<TaiSan> taiSan) {
        this.maPhieu = maPhieu;
        this.tenNhanVienKiemKe = tenNhanVienKiemKe;
        this.chucVu = chucVu;
        this.tenPhongKiemKe = tenPhongKiemKe;
        this.maPhong = maPhong;
        this.tenTruongPhong = tenTruongPhong;
        this.taiSan = taiSan;
    }

    

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) throws Exception {
        if(maPhieu.trim().equals("")) {
            throw new Exception("Ma Phieu is khong duoc de trong ");
        }else {
            this.maPhieu = maPhieu;
        } 
        
    }

    public String getTenNhanVien() {
        return tenNhanVienKiemKe;
    }

    public void setTenNhanVien(String tenNhanVienKiemKe) throws Exception {
        if(tenNhanVienKiemKe.trim().equals("")) {
            throw new Exception("Ten nhan vien khong duoc de trong ");
        }else {
            this.tenNhanVienKiemKe = tenNhanVienKiemKe;
        } 
        
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getTenPhongKiemKe() {
        return tenPhongKiemKe;
    }

    public void setTenPhongKiemKe(String tenPhongKiemKe) {
        this.tenPhongKiemKe = tenPhongKiemKe;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenTruongPhong() {
        return tenTruongPhong;
    }

    public void setTenTruongPhong(String tenTruongPhong) {
        this.tenTruongPhong = tenTruongPhong;
    }

    public Vector<TaiSan> getTaiSan() {
        return taiSan;
    }

    public void setTaiSan(Vector<TaiSan> taiSan) {
        this.taiSan = taiSan;
    }
    
    
    public void nhap() throws Exception{
        Scanner in = new Scanner(System.in);
        System.out.println("==============Nhap thong tin vao phieu kiem ke===================");
        
        System.out.println("Nhap ma phieu :");
        String maPhieu = in.nextLine();
        if(maPhieu.trim().equals("")) {
            throw new Exception("Ma Phieu is khong duoc de trong ");
        }else {
            this.maPhieu = maPhieu;
        } 
        
        
        System.out.println("Nhap ten nhan vien kiem ke :");
        String tenNhanVienKiemKe = in.nextLine();
        if(tenNhanVienKiemKe.trim().equals("")) {
            throw new Exception("Ten nhan vien khong duoc de trong ");
        }else {
            this.tenNhanVienKiemKe = tenNhanVienKiemKe;
        } 
        
        
        System.out.println("Nhap chuc vu :");
        String chucVu = in.nextLine();
        System.out.println("Nhap kiem ke tai phong :");
        String tenPhongKiemKe = in.nextLine();
        System.out.println("Nhap ma phong kiem ke :");
        String maPhong = in.nextLine();
        System.out.println("Nhap ten truong phong  :");
        String tenTruongPhong = in.nextLine();
        
        
        
        
        System.out.println("=================Nhap thong tin tai san  :========");
        System.out.println("Nhap so luong tai san can nhap thong tin :");
        int soLuong = in.nextInt();
        Vector<TaiSan> taiSan = new Vector();
        for(int i = 0;i<soLuong;i++){
            TaiSan a = new TaiSan();
            a.nhap();
            if(!taiSan.contains(a.getTenTaiSan())){
                taiSan.add(a);
            }  
        }
        
       
        this.chucVu = chucVu;
        this.tenPhongKiemKe = tenPhongKiemKe;
        this.maPhong = maPhong;
        this.tenTruongPhong = tenTruongPhong;
        this.taiSan = taiSan;
        
    }
    
    public void xuat(){
        Scanner in = new Scanner(System.in);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy ");  
        Date date = new Date(); 
        
        System.out.println("============== Thong tin phieu kiem ke tai san =====================");
        System.out.println("Ma phieu :" + this.getMaPhieu());
        System.out.println("Ten nhan vien kiem ke : "+this.getTenNhanVien());
        System.out.println("Ngay kiem ke : "+formatter.format(date));
        System.out.println("Chuc vu : "+this.getChucVu());
        System.out.println("Kiem ke tai phong : "+this.getTenPhongKiemKe());
        System.out.println("Ma phong kiem ke : "+this.getMaPhong());
        System.out.println("Ten truong phong  : "+this.getTenTruongPhong());
        
        Comparator<TaiSan> soSanh =  new Comparator<TaiSan>(){
            public int compare(TaiSan o1, TaiSan o2){
                int soLuong1 = o1.getSoLuong();
                int soLuong2 = o2.getSoLuong();
                if(soLuong1==soLuong2){
                    return 0;
                }
                if(soLuong1>=soLuong2){
                    return 1;
                }
                return -1;
            }
        };
        
        
        Collections.sort(this.taiSan, soSanh);
        System.out.println("============Thong tin tai san================");
        for(int i = 0;i<taiSan.size();i++){
            taiSan.get(i).xuat();
        }
        
        
        System.out.println("So tai san da thong ke : " + taiSan.size());
        
        int tong = 0;
        for(int i = 0;i<taiSan.size();i++){
            tong = tong + taiSan.get(i).getSoLuong();
        }
        System.out.println("Tong so luong : "+tong);
        
        
    }  
}
