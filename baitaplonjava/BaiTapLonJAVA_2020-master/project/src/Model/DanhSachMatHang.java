/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author quang
 */
import DAO.MatHangDAO;


public class DanhSachMatHang {
    private ArrayList<MatHang> bangDias = null;
    private static MatHangDAO bangDiaDAO;

    public DanhSachMatHang() throws Exception {
        bangDiaDAO = MatHangDAO.getInstance();
        loadData();
    }

    /**
     * Load dữ liệu từ database
     *
     * @throws Exception
     */
    public void loadData() throws Exception {
        bangDias = bangDiaDAO.getBangDias();
    }


    /**
     * Lấy danh sách đồ dùng
     *
     * @return
     */
    public ArrayList<MatHang> getAll() {
        return bangDias;
    }


    /**
     * Thêm 1 đồ dùng mới (không cho thêm đồ dùng bị trùng mã)
     * Lưu đồ dùng vào DB
     *
     * @param bangDia
     * @return
     * @throws Exception
     */
    public boolean them(MatHang bangDia) throws Exception {
        if (bangDia == null || bangDias.contains(bangDia))
            return false;

        return (bangDias.add(bangDiaDAO.themBangDia(bangDia)));
    }


    /**
     * Xoá đồ dùng bằng mã đồ dùng
     * Xoá đồ dùng tương ứng trong DB
     *
     * @param maBangDia
     * @return
     * @throws Exception
     */
    public boolean xoa(String maBangDia) throws Exception {
        MatHang bangDia = bangDias.get(tim(maBangDia));

        if (bangDia == null)
            return false;

        return (bangDiaDAO.xoaBangDia(maBangDia) && bangDias.remove(bangDia));
    }


    /**
     * Cập nhật thông tin đồ dùng
     * Cập nhật thông tin đồ dùng tương ứng trong DB
     *
     * @param bangDia
     * @return
     * @throws Exception
     */
    public boolean sua(MatHang bangDia) throws Exception {
        return bangDias.set(tim(bangDia.getMaMatHang()), bangDiaDAO.suaBangDia(bangDia)) != null;
    }


    /**
     * Tìm vị trí của đồ dùng
     *
     * @param maBangDia
     * @return
     */
    public int tim(String maBangDia) {
        for (int i = 0; i < bangDias.size(); i++)
            if (bangDias.get(i).getMaMatHang().equals(maBangDia))
                return i;

        return -1;
    }


    /**
     * Xoá băng đỉa hỏng trong danh sách
     * Xoá đồ dùng tương ứng trong DB
     */
    public void xoaBangDiaHong() {
        ArrayList<String> dsXoa = new ArrayList<>();

        for (MatHang bangDia : bangDias) {
            if (!bangDia.isTinhTrang()) {
                dsXoa.add(bangDia.getMaMatHang());
            }
        }

        for (String maBangDia : dsXoa) {
            try {
                xoa(maBangDia);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Lấy tổng số băng đia tồn trong kho
     *
     * @return
     */
    public int tongSoBangDiaTon() {
        int tong = 0;

        for (MatHang bangDia : bangDias)
            tong += bangDia.getSoLuongTon();

        return tong;
    }


    /**
     * Lấy tổng số đồ dùng hỏng
     *
     * @return
     */
    public int tongSoBangDiaHong() {
        int count = 0;

        for (MatHang bangDia : bangDias)
            if (!bangDia.isTinhTrang())
                count++;

        return count;
    }
}
