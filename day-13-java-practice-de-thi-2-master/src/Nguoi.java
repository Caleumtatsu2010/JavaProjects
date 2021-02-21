/**
 * Created by IntelliJ IDEA.
 * User: AnhNBT (anhnbt.it@gmail.com)
 * Date: 10/21/2020
 * Time: 1:46 PM
 */
public class Nguoi {
    private String cmnd;
    private String hoTen;
    private int tuoi;


    private int soNgayTro;
    private String loaiPhongTro;
    private double giaPhongTro;

    public Nguoi() {}

    public Nguoi(String cmnd, String hoTen, int tuoi) {
        this.cmnd = cmnd;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
    }

    public Nguoi(String cmnd, String hoTen, int tuoi, int soNgayTro, String loaiPhongTro, double giaPhongTro) {
        this.cmnd = cmnd;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.soNgayTro = soNgayTro;
        this.loaiPhongTro = loaiPhongTro;
        this.giaPhongTro = giaPhongTro;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public int getSoNgayTro() {
        return soNgayTro;
    }

    public void setSoNgayTro(int soNgayTro) {
        this.soNgayTro = soNgayTro;
    }

    public String getLoaiPhongTro() {
        return loaiPhongTro;
    }

    public void setLoaiPhongTro(String loaiPhongTro) {
        this.loaiPhongTro = loaiPhongTro;
    }

    public double getGiaPhongTro() {
        return giaPhongTro;
    }

    public void setGiaPhongTro(double giaPhongTro) {
        this.giaPhongTro = giaPhongTro;
    }

    @Override
    public String toString() {
        return "Nguoi{" +
                "cmnd='" + cmnd + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", tuoi=" + tuoi +
                ", soNgayTro=" + soNgayTro +
                ", loaiPhongTro='" + loaiPhongTro + '\'' +
                ", giaPhongTro=" + giaPhongTro +
                '}';
    }
}
