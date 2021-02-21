import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: AnhNBT (anhnbt.it@gmail.com)
 * Date: 10/21/2020
 * Time: 2:07 PM
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        KhachSan khachSan = new KhachSan();
        System.out.println("===========================");
        System.out.println("Quan Ly Phong Tro by AnhNBT");
        System.out.println("===========================");

        int choice;
        do {
            System.out.println("1) Nhap thong tin khach thue tro (Checkin)");
            System.out.println("2) Danh sach khach dang tro");
            System.out.println("3) Tra phong (Checkout)");

            System.out.print("Nhap lua chon cua ban [0-Thoat]: ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhap so khach thue tro: ");
                    int number = Integer.parseInt(input.nextLine());
                    int counter = 1;
                    while (counter <= number) {
                        System.out.print("Nhap ten khach " + counter + ": ");
                        String hoTen = input.nextLine();

                        System.out.print("Nhap tuoi: ");
                        int tuoi = Integer.parseInt(input.nextLine());

                        System.out.print("Nhap CMT: ");
                        String cmnd = input.nextLine();

                        System.out.print("Nhap so ngay tro: ");
                        int soNgayTro = Integer.parseInt(input.nextLine());

                        System.out.print("Loai phong tro (Standard, VIP, Luxury): ");
                        String loaiPhongTro = input.nextLine();

                        System.out.print("Nhap gia phong tro (VND/Ngay): ");
                        double giaPhongTro = Float.parseFloat(input.nextLine());

                        khachSan.nhap(new Nguoi(cmnd, hoTen, tuoi, soNgayTro, loaiPhongTro, giaPhongTro));
                        counter++;
                    }
                    break;
                case 2:
                    khachSan.danhSach();
                    break;
                case 3:
                    System.out.print("Nhap CMND: ");
                    String cmnd = input.nextLine();
                    khachSan.tinhTien(cmnd);
                    break;
            }
        } while (choice != 0);
    }
}
