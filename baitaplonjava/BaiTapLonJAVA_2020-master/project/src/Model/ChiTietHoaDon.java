/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author quang
 */
public class ChiTietHoaDon {
    private MatHang bangDia;
    private int soNgayDuocMuon;
    private int soLuong;
    private boolean tinhTrang;  // true: đã trả, false: đang thuê

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public MatHang getBangDia() {
        return bangDia;
    }

    public void setBangDia(MatHang bangDia) {
        this.bangDia = bangDia;
    }

    public int getSoNgayDuocMuon() {
        return soNgayDuocMuon;
    }

    public void setSoNgayDuocMuon(int soNgayDuocMuon) {
        this.soNgayDuocMuon = soNgayDuocMuon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(MatHang bangDia, int soNgayDuocMuon, int soLuong) {
        this.bangDia = bangDia;
        this.soNgayDuocMuon = soNgayDuocMuon;
        this.soLuong = soLuong;
        this.tinhTrang = false;
    }

    public ChiTietHoaDon(MatHang bangDia, int soNgayDuocMuon, int soLuong, boolean tinhTrang) {
        this.bangDia = bangDia;
        this.soNgayDuocMuon = soNgayDuocMuon;
        this.soLuong = soLuong;
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDon{" +
                "bangDia=" + bangDia +
                ", soNgayDuocMuon=" + soNgayDuocMuon +
                ", soLuong=" + soLuong +
                ", tinhTrang=" + tinhTrang +
                '}';
    }
}
