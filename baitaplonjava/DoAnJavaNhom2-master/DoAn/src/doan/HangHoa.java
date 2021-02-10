/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doan;

/**
 *
 * @author Administrator
 */
public class HangHoa {
    private String Ma;
    private String TenH;
    private int SL;
    private String GiaNhap;
    private String GiaBan;
    private String DaBan;
    
    public HangHoa(){
        
    }
    public HangHoa(String Ma, String TenH, int SL, String GiaNhap, String GiaBan, String DaBan) {
        this.Ma = Ma;
        this.TenH = TenH;
        this.SL = SL;
        this.GiaNhap = GiaNhap;
        this.GiaBan = GiaBan;
        this.DaBan = DaBan;
    }
       public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public String getTenH() {
        return TenH;
    }

    public void setTenH(String TenH) {
        this.TenH = TenH;
    }

    public int getSL() {
        return SL;
    }

    public void setSL(int SL) {
        this.SL = SL;
    }

    public String getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(String GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public String getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(String GiaBan) {
        this.GiaBan = GiaBan;
    }

    public String getDaBan() {
        return DaBan;
    }

    public void setDaBan(String DaBan) {
        this.DaBan = DaBan;
    }
    @Override
    public String toString() {
        return "SinhVien{" + "Ma=" + Ma+ ", TenH=" + TenH + ", SL=" + SL + ", GiaNhap=" + GiaNhap + ", GiaBan=" + GiaBan + ", DaBan=" + DaBan + '}';
    }
}
