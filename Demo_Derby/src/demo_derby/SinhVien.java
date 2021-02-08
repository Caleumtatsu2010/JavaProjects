/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_derby;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class SinhVien {
    private String maSV, hoTen, gioiTinh;
    private float diemToan, diemLy, diemHoa;
    
    public SinhVien(){
        maSV="0000000000";
        hoTen="no name";
        gioiTinh="unknown";
        diemToan=diemLy=diemHoa=0f;
    }
    
    public SinhVien(String maSV, String hoTen, String gioiTinh, float diemToan, float diemLy, float diemHoa){
        this.maSV=maSV;
        this.hoTen=hoTen;
        this.gioiTinh=gioiTinh;
        this.diemToan=diemToan;
        this.diemLy=diemLy;
        this.diemHoa=diemHoa;
    }
    
    
    public void input(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap ma sinh vien:");
        maSV=sc.nextLine();
        System.out.println("Nhap ho ten sinh vien:");
        hoTen=sc.nextLine();
        System.out.println("Nhap gioi tinh:");
        gioiTinh=sc.nextLine();
        System.out.println("Nhap diem toan:");
        diemToan=sc.nextFloat();
        System.out.println("Nhap diem ly:");
        diemLy=sc.nextFloat();
        System.out.println("Nhap diem hoa:");
        diemHoa=sc.nextFloat();
    }
    
    public static void showTitle(){
        System.out.printf("%n%-15s%-30s%-15s%-10s%-10s%-10s%n","MaSV","Ho va Ten", "Gioi tinh", "Diem toan", "Diem ly", "Diem hoa");
    }
    
    public String queryStruct(){
        return "'"+maSV+"'"+","+"'"+hoTen+"'"+","+"'"+gioiTinh+"'"+","+diemToan+","+diemLy+","+diemHoa;
    }
    
    @Override
    public String toString() {
        return String.format("%-15s%-30s%-10s%-10f%-10f%-10f",maSV,hoTen,gioiTinh,diemToan,diemLy,diemHoa);
    }
}
