public class test {
    public static void main(String[] args) {
        Phieu phieu = new Phieu();
        phieu.NhapTT();
        if(phieu.getMaPhieu()==null || phieu.getNhanVien().getTen()==null){
            System.out.println("Nhap khong hop le, thuc hien lai");
        }else {
            phieu.InTT();
        }

    }
}
