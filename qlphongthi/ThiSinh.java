/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlphongthi;

import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author A510
 */
public class ThiSinh {

    private String soBD;
    private String hoTen;

    private float diemToan;

    
    private float diemLy;
    private float diemHoa;
//Bước 2: xây dựng hàm tạo

    public ThiSinh() {
        soBD = "";
        hoTen = "no-name";
        diemToan = diemLy = diemHoa = 0f;
    }

    public ThiSinh(String soBD) {
        this.soBD = soBD;
    }
//ghi đè phương thức nhận diện khóa

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.soBD);
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
        final ThiSinh other = (ThiSinh) obj;
        if (!Objects.equals(this.soBD, other.soBD)) {
            return false;
        }
        return true;
    }
//nhập thông tin ts
    //Trần Thị Ngọc Ánh-bắt lỗi sbd không được để trống

    public void setSoBD(String soBD) throws Exception {
        if (soBD.trim().equals("")) {
            throw new Exception("Số báo danh không được để trống.");
        } else {
            this.soBD = soBD;
        }
    }

    //Trần Thị Ngọc Ánh-bắt lỗi điểm có 1 chữ số trong phần thập phân và điểm từ 0-10
    public boolean batloist(float diem) throws Exception {
        boolean test=true;
        String diemstr = Float.toString(diem);
        float t = diem;
        String pattern = "###.0";
        DecimalFormat df = new DecimalFormat(pattern);
        String diemcheck = df.format(t);
        if ((diemstr.equals(diemcheck) == false) && (diem < 0 || diem > 10)) {
            test=false;
            throw new Exception("Điểm phải đúng định dạng: ###.# và điểm phải trong khoảng từ 0-10");
        } else if (diemstr.equals(diemcheck) == false) {
            test=false;
            throw new Exception("Điểm phải đúng định dạng: ###.#");
        } else if (diem < 0 || diem > 10) {
            test=false;
            throw new Exception("Điểm phải trong khoảng từ 0-10");
        }
        return test;
        
    }

    //Trần Thị Ngọc Ánh-bắt lỗi điểm Toán nhập vào là số thực
    public void setDiemToan(String so) {
        try {
            
            this.diemToan = Float.parseFloat(so);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        
    }
    //Trần Thị Ngọc Ánh-bắt lỗi điểm Lý nhập vào là số thực
    public void setDiemLy(String so) {
        try {
            
            this.diemLy = Float.parseFloat(so);
            
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        
    }
    //Trần Thị Ngọc Ánh-bắt lỗi điểm Hóa nhập vào là số thực
    public void setDiemHoa(String so) {
        try {
            
            this.diemHoa = Float.parseFloat(so);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        
    }
    //Trần Thị Ngọc Ánh- nếu dữ liệu nhập vào k đúng yêu cầu nhập lại
    public void nhap() throws Exception {
        Scanner sc = new Scanner(System.in);
        do
            {
        try {
            
            System.out.print("\tNhập số báo danh:");
            setSoBD(sc.nextLine());
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }
        }
            while(soBD.trim().equals(""));

        System.out.print("\tNhập họ tên thí sinh:");
        hoTen = sc.nextLine();
        
               
         boolean checkToan=false;
        do
       {
           System.out.print("\tNhập điểm Toán:");
            setDiemToan(sc.nextLine());          
         try {
            
            checkToan=batloist(diemToan);
        } catch (Exception e) {
            System.out.println(e.getMessage());
       }
        }
       while(checkToan==false);
        
        
         boolean checkLy=false;
      do
       {
           System.out.print("\tNhập điểm lý:");
            setDiemLy(sc.nextLine());
           
         try {
            
            checkLy=batloist(diemLy);
        } catch (Exception e) {
            System.out.println(e.getMessage());
       }
        }
       while(checkLy==false);
       

        boolean checkHoa=false;
      do
       {
           System.out.print("\tNhập điểm Hóa:");
            setDiemHoa(sc.nextLine());
           
         try {
            
            checkHoa=batloist(diemHoa);
        } catch (Exception e) {
            System.out.println(e.getMessage());
       }
        }
       while(checkHoa==false);
    }

    @Override
    public String toString() {
        String tsValue;
        tsValue = "SBD:" + soBD + "\t Ho ten:" + hoTen + "\tdiem toan:" + diemToan + "\t điểm lý:";
        tsValue = tsValue + diemLy + "\tđiem hóa:" + diemHoa;
        return tsValue;
    }

    /*
 * Bước 7: Viết các business methods của đối tượng.
Đây là bước quan trọng nhất bởi nó định nghĩa tập các dịch vụ của đối tượng cung cấp cho bên ngoài.
 *
     */
    /**
     * Kiểm tra 1 thí sinh có đậu hay không
     *
     * @return true nếu sinh viên có tổng số điểm trên 15 và không có điểm nào
     * dưới 3.
     */
    public boolean CheckPassed() {
        return tongDiem() > 15 && diemToan >= 3 && diemHoa >= 3 && diemLy >= 3;
    }

    /**
     * Tổng điểm của thí sinh
     *
     * @return: tổng điểm
     */
    public float tongDiem() {
        return diemHoa + diemLy + diemToan;
    }
}
