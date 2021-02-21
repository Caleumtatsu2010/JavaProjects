import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: AnhNBT (anhnbt.it@gmail.com)
 * Date: 10/21/2020
 * Time: 1:50 PM
 */
public class KhachSan {
    List<Nguoi> lists;

    public KhachSan() {
        // init
        lists = new ArrayList<>();
    }

    public boolean nhap(Nguoi nguoi) {
        lists.add(nguoi);
        return true;
    }

    public void danhSach() {
        System.out.println("========================");
        System.out.println("Danh sach khach dang tro");
        System.out.println("========================");
        for (Nguoi nguoi: lists) {
            System.out.println(nguoi.toString());
            System.out.println("---------------------");
        }
    }

    public void hienThi(String cmnd) {
        for (Nguoi nguoi: lists) {
            if (cmnd == nguoi.getCmnd()) {
                nguoi.toString();
            }
        }
        throw new IndexOutOfBoundsException("Khach hang nay khong ton tai!");
    }

    public boolean xoa(String cmnd) {
        for (Nguoi nguoi: lists) {
            if (nguoi.getCmnd().equals(cmnd)) {
                lists.remove(nguoi);
                return true;
            }
        }
        return false;
    }

    public void tinhTien(String cmnd) {
        if (findByCMT(cmnd)) {
            for (Nguoi nguoi: lists) {
                if (nguoi.getCmnd().equals(cmnd)) {
                    double total = nguoi.getGiaPhongTro() * nguoi.getSoNgayTro();
                    System.out.println(nguoi.toString());
                    System.out.println("So tien can phai tra la: " + total);
                }
            }
        } else {
            System.out.println("Khong tim thay vi khach nay!");
        }
    }

    private boolean findByCMT(String cmnd) {
        for (Nguoi nguoi: lists) {
            if (nguoi.getCmnd().equals(cmnd)) {
                return true;
            }
        }
        return false;
    }
}