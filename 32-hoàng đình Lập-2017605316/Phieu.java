import java.text.SimpleDateFormat;
import java.util.*;

public class Phieu {
    private String maPhieu;
    private String ngayKiemKe;
    private NhanVien nhanVien;
    private Phong phong ;
    private List<TaiSan> taiSan;

    public Phieu() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.ngayKiemKe = simpleDateFormat.format(date);
        this.taiSan = new Vector<>();
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getNgayKiemKe() {
        return ngayKiemKe;
    }

    public void setNgayKiemKe(String ngayKiemKe) {
        this.ngayKiemKe = ngayKiemKe;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    public List<TaiSan> getTaiSan() {
        return taiSan;
    }

    public void setTaiSan(List<TaiSan> taiSan) {
        this.taiSan = taiSan;
    }

    public void NhapTT(){
        boolean check = true;
        Scanner sc = new Scanner(System.in);
        NhanVien nv = new NhanVien();
        Phong p = new Phong();
        String maP;

        System.out.print("Ma phieu: ");maP=sc.nextLine();
        if(maP==null)check=false;
        System.out.print("Nhan vien: ");nv.setTen(sc.nextLine());
        System.out.print("Chuc vu: ");nv.setChucVu(sc.nextLine());
        System.out.print("Kiem ke tai phong: ");nv.setPhong(sc.nextLine());
        System.out.print("Ma phong:");p.setMaPhong(sc.nextLine());
        System.out.print("Truong Phong:");p.setTruongPhong(sc.nextLine());
        this.maPhieu = maP;
        this.nhanVien = nv;
        this.phong = p;
        System.out.println("Nhap tai san");
        int tmp;
        while (true){
            TaiSan ts = new TaiSan();
            System.out.println("Nhap 1 de tiep tuc, 0 de ket thuc. 1/0 ?");tmp=sc.nextInt();
            if(tmp==0)break;
            String tents;
            System.out.println("Nhap ten tai san: ");tents=sc.nextLine();
            Iterator<TaiSan> iterator = taiSan.iterator();
            TaiSan taiSan1;

            while (iterator.hasNext()){
                taiSan1=iterator.next();
                if(taiSan1.getTenTS()==tents){
                    check=false;
                }
            }
            if (!check)System.out.println("Nhap trung");
            else {
                System.out.println("Nhap so luong:");ts.setSoLuong(sc.nextInt());sc.nextLine();
                System.out.println("Nhap tinh trang:");ts.setTinhTrang(sc.nextLine());
                this.taiSan.add(ts);
            }

        }
    }
    public void InTT(){
        System.out.println("\t\t\tPhieu Kiem Ke Tai San");
        System.out.println("Ma phieu:\t\t"+this.maPhieu+"\t\tNgay kiem ke:\t"+this.ngayKiemKe);
        System.out.println("Nhan vien kiem ke:\t"+this.nhanVien.getTen()+"\tchuc vu:\t"+this.nhanVien.getChucVu());
        System.out.println("Kiem ke tai phong:\t"+this.nhanVien.getPhong());
        System.out.println("Ma Phong:\t"+this.phong.getMaPhong()+"\tTruong phong\t"+this.phong.getMaPhong());
        System.out.println("Ten tai san\t\tSo luong\t\tTinh Trang");
        Iterator<TaiSan> iterator = taiSan.iterator();
        TaiSan taiSan1;
        int soLuong=0;
        int dem=0;
        while (iterator.hasNext()){
            dem+=0;
            taiSan1=iterator.next();
            soLuong+=taiSan1.getSoLuong();
            System.out.println(taiSan1.getTenTS()+"\t\t"+taiSan1.getSoLuong()+"\t\t"+taiSan1.getTinhTrang());
        }
        System.out.println("So tai san da kiem ke:"+dem+"\tTong so luong:"+soLuong);
    }
}

