public class Phong {
    private String maPhong;
    private String truongPhong;

    public Phong(String maPhong, String truongPhong) {
        this.maPhong = maPhong;
        this.truongPhong = truongPhong;
    }

    public Phong() {
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTruongPhong() {
        return truongPhong;
    }

    public void setTruongPhong(String truongPhong) {
        this.truongPhong = truongPhong;
    }
}
