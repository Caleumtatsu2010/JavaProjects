/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NguyenXuanTruong_2018603561;

import java.util.Scanner;

/**
 *
 * @author truonghdpk
 */
public class Date {
    private String ngay;
    private String thang;
    private String nam;
    Date(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ngay");
        this.ngay = sc.nextLine();
        System.out.println("Nhap thang");
        this.thang = sc.nextLine();
        System.out.println("Nhap nam");
        this.nam = sc.nextLine();
    }

    @Override
    public String toString() {
        return ngay + "/" + thang + "/" + nam;
    }
}
