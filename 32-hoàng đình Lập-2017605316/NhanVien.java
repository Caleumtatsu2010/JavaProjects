
public class NhanVien {
    private String ten;
    private String chucVu;
    private String phong;

    public NhanVien(String ten, String chucVu, String phong) {
        this.ten = ten;
        this.chucVu = chucVu;
        this.phong = phong;
    }

    public NhanVien() {
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }
}
