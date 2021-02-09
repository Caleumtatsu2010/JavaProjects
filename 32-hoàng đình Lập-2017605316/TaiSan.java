public class TaiSan {
    private String tenTS;
    private int soLuong;
    private String tinhTrang;

    public TaiSan(String tenTS, int soLuong, String tinhTrang) {
        this.tenTS = tenTS;
        this.soLuong = soLuong;
        this.tinhTrang = tinhTrang;
    }

    public TaiSan() {
    }

    public String getTenTS() {
        return tenTS;
    }

    public void setTenTS(String tenTS) {
        this.tenTS = tenTS;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}
