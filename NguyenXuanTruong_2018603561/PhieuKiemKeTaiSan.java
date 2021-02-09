/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NguyenXuanTruong_2018603561;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author truonghdpk
 */
public class PhieuKiemKeTaiSan {

    private String maphieu;
    private Date date;
    private String tenNhanVien;
    private String chucVu;
    private String phong;
    private String maPhong;
    private String truongPhong;
    private int tongSl = 0;
    HashSet<TaiSan> dsTS = new HashSet();

    public PhieuKiemKeTaiSan() {
        int slTaiSanNhap;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma phieu : ");
        this.maphieu = sc.nextLine();
        System.out.println("Nhap ngay kiem ke : ");
        this.date = new Date();
        System.out.println("Nhap ten nhan vien : ");
        this.tenNhanVien = sc.nextLine();
        System.out.println("Nhap chuc vu : ");
        this.chucVu = sc.nextLine();
        System.out.println("Nhap ten phong kiem ke : ");
        this.phong = sc.nextLine();
        System.out.println("Nhap ma phong : ");
        this.maPhong = sc.nextLine();
        System.out.println("Nhap so luong tai san : ");
        slTaiSanNhap = sc.nextInt();
        for (int i = 0; i < slTaiSanNhap; i++) {
            this.dsTS.add(new TaiSan());
        }
    }

    public void inPhieuKiemKe() {
        System.out.println("===========================PHIEU KIEM KE TAI SAN======================");
        System.out.println("Ma phieu : " + this.maphieu);
        System.out.println("Ngay kiem ke : " + this.date.toString());
        System.out.println("Nham vien kiem ke : " + this.tenNhanVien);
        System.out.println("Chuc vu : " + this.chucVu);
        System.out.println("Kiem ke tai phong : " + this.phong);
        System.out.println("Ma phong : " + this.maPhong);
        System.out.println("Truong phong : " + this.truongPhong);
        System.out.println("Ten tai san, So luong, Tinh trang");
        Iterator<TaiSan> it = dsTS.iterator();
        while (it.hasNext()) {
            this.tongSl += it.next().getSl();
            System.out.println(it.next());
        }
        System.out.println("So tai san da kiem ke : " + this.dsTS.size());
        System.out.println("Tong so luong : "+ this.tongSl);
        System.out.println("=================================END===================================");
    }

    public static void main(String[] args) {
        PhieuKiemKeTaiSan phieu1 = new PhieuKiemKeTaiSan();
        phieu1.inPhieuKiemKe();
    }
}
