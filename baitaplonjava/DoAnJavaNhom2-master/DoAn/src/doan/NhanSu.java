/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doan;

/**
 *
 * @author ASUS
 */
public class NhanSu {
    private String Ma;
    private String HoTen;
    private int Tuoi;
    private String GioiT;
    private String DiaC;
    private String SDT;
    private String Luong;
    private String GC;
    private String CV;
    public NhanSu() {
    }

   

    public NhanSu(String Ma, String HoTen, int Tuoi, String GioiT, String DiaC, String SDT, String Luong, String GC, String CV) {
        this.Ma = Ma;
        this.HoTen = HoTen;
        this.Tuoi = Tuoi;
        this.GioiT = GioiT;
        this.DiaC = DiaC;
        this.SDT = SDT;
        this.Luong = Luong;
        this.GC = GC;
        this.CV = CV;
    }

     public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getGioiT() {
        return GioiT;
    }

    public void setGioiT(String GioiT) {
        this.GioiT = GioiT;
    }

    public String getDiaC() {
        return DiaC;
    }

    public void setDiaC(String DiaC) {
        this.DiaC = DiaC;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getLuong() {
        return Luong;
    }

    public void setLuong(String Luong) {
        this.Luong = Luong;
    }

    public String getGC() {
        return GC;
    }

    public void setGC(String GC) {
        this.GC = GC;
    }

    public String getCV() {
        return CV;
    }

    public void setCV(String CV) {
        this.CV = CV;
    }
    public int getTuoi() {
        return Tuoi;
    }
    public void setTuoi(int tuoi) {
        this.Tuoi = Tuoi;
    }

    @Override
    public String toString() {
        return "SinhVien{" + "Ma=" + Ma+ ", HoTen=" + HoTen + ", tuoi=" + Tuoi + ", GioiT=" + GioiT + ", DiaC=" + DiaC + ", SDT=" + SDT + ", Luong=" + Luong + ", GC=" + GC + ",CV=" + CV +'}';
    }
}
