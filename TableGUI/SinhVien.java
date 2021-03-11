package TableGUI;

public class SinhVien {
    private String maSV,hoTen;
    private int tuoi;

    public SinhVien() {
    }

    public SinhVien(String maSV, String hoTen, int t) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        tuoi=t;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
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

    @Override
    public String toString() {
        return  "maSV=" + maSV + ", hoTen=" + hoTen +"tuoi:" + tuoi;
    }

   
   
    
}
