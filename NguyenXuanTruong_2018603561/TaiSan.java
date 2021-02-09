/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NguyenXuanTruong_2018603561;

import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author truonghdpk
 */
public class TaiSan implements Comparable {

    private String tenTaiSan;
    private int sl;
    private String tinhTrang;

    TaiSan() {
        boolean loop = true;
        while (loop) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Khoi tao tai san moi \n");
                System.out.println("Nhap ten tai san : ");
                this.tenTaiSan = sc.nextLine();
                if (this.tenTaiSan.length() == 0) {
                    throw new Exception("Ten tai san khong duoc de trong!");
                }
                System.out.println("Nhap so luong tai san : ");
                this.sl = sc.nextInt();
                if (this.sl < 0) {
                    throw new Exception("So luong tai san phai lon hon bang 0!");
                }
                sc.nextLine();
                System.out.println("Nhap tinh trang tai san : ");
                this.tinhTrang = sc.nextLine();
                loop = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        return tenTaiSan + ", " + sl + ", " + tinhTrang;
    }

    public void xuat() {
        System.out.println(this.tenTaiSan + ", " + this.sl + ", " + this.tinhTrang);
    }

    public String getTenTaiSan() {
        return tenTaiSan;
    }

    public int getSl() {
        return sl;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.tenTaiSan);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TaiSan other = (TaiSan) obj;
        if (!Objects.equals(this.tenTaiSan, other.tenTaiSan)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Object t) {
        TaiSan sv = (TaiSan) t;
        return tenTaiSan.compareToIgnoreCase(sv.getTenTaiSan());

    }
}
