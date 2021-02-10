/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.MatHang;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author quang
 */
public class MatHangDAO {
    private static MatHangDAO _instance;
    private static DataBaseUtils dataBaseUtils;

    public MatHangDAO() throws Exception {
        dataBaseUtils = DataBaseUtils.getInstance();
    }


    /**
     * Design Pattern: Singleton
     *
     * @return
     * @throws Exception
     */
    public static MatHangDAO getInstance() throws Exception {
        if (_instance == null) {
            synchronized (MatHangDAO.class) {
                if (null == _instance) {
                    _instance = new MatHangDAO();
                }
            }
        }
        return _instance;
    }


    /**
     * Đọc danh sách đồ dùng từ DB
     *
     * @return
     * @throws Exception
     */
    public ArrayList<MatHang> getBangDias() throws Exception {
        ArrayList<MatHang> bangDias = new ArrayList<MatHang>();
        ResultSet resultSet = null;

        final String sql = "SELECT * FROM BANGDIA";

        try {
            resultSet = dataBaseUtils.excuteQueryRead(sql);

            while (resultSet.next()) {
                MatHang bangDia = new MatHang(
                        resultSet.getString("MABD"),
                        resultSet.getString("TENBD"),
                        resultSet.getString("THELOAI"),
                        resultSet.getBoolean("TINHTRANG"),
                        resultSet.getString("HANGSANXUAT"),
                        resultSet.getString("GHICHU"),
                        resultSet.getDouble("DONGIA"),
                        resultSet.getInt("SOLUONGTON")
                );

                bangDias.add(bangDia);
            }

        } catch (Exception e) {
            throw new Exception("Đọc danh sách đồ dùng lỗi");
        } finally {
            resultSet.close();
        }

        return bangDias;
    }
    
    
    public ArrayList<MatHang> getMatHangDeXoa() throws Exception {
        ArrayList<MatHang> bangDias = new ArrayList<MatHang>();
        ResultSet resultSet = null;

        final String sql = "SELECT * FROM BANGDIA";

        try {
            resultSet = dataBaseUtils.excuteQueryRead(sql);

            while (resultSet.next()) {
                MatHang bangDia = new MatHang(
                        resultSet.getString("MABD"),
                        resultSet.getString("TENBD"),
                        resultSet.getInt("SOLUONGTON")
                );

                bangDias.add(bangDia);
            }

        } catch (Exception e) {
            throw new Exception("Đọc danh sách đồ dùng lỗi");
        } finally {
            resultSet.close();
        }

        return bangDias;
    }
    
    
    


    /**
     * Lấy đồ dùng từ DB
     *
     * @param maBangDia
     * @return
     * @throws Exception
     */
    public MatHang getBangDia(String maBangDia) throws Exception {
        MatHang bangDia = null;
        String sql = String.format("SELECT * FROM BANGDIA WHERE MABD = '%s'", maBangDia);
        try (ResultSet resultSet = dataBaseUtils.excuteQueryRead(sql)) {

            while (resultSet.next()) {
                bangDia = new MatHang(
                        resultSet.getString("MABD"),
                        resultSet.getString("TENBD"),
                        resultSet.getString("THELOAI"),
                        resultSet.getBoolean("TINHTRANG"),
                        resultSet.getString("HANGSANXUAT"),
                        resultSet.getString("GHICHU"),
                        resultSet.getDouble("DONGIA"),
                        resultSet.getInt("SOLUONGTON")
                );
            }
        } catch (SQLException e) {
            throw new Exception(String.format("Đọc dữ liệu đồ dùng %s lỗi", bangDia.getMaMatHang()));
        }

        return bangDia;
    }


    /**
     * Lấy mã đồ dùng cuối trong DB
     * Dùng để generate mã đồ dùng mới
     *
     * @return
     * @throws Exception
     */
    public String getMaBangDiaCuoi() throws Exception {
        String sql = "SELECT TOP 1 MABD FROM BANGDIA ORDER BY MABD DESC";
        ResultSet resultSet = null;
        String ketQua;

        try {
            resultSet = dataBaseUtils.excuteQueryRead(sql);
            resultSet.next();

            ketQua = resultSet.getString("MABD");
        } catch (SQLException e) {
            throw new Exception("Đọc dữ liệu đồ dùng lỗi");
        } finally {
            resultSet.close();
        }

        return ketQua;
    }


    /**
     * Thêm đồ dùng mới vào DB
     *
     * @param bangDia
     * @return
     * @throws Exception
     */
    public MatHang themBangDia(MatHang bangDia) throws Exception {
        String sql = "INSERT INTO BANGDIA (MABD, TENBD, HANGSANXUAT, GHICHU, DONGIA, TINHTRANG, THELOAI, SOLUONGTON) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        

        if (bangDia == null)
            return null;

        try {
            preparedStatement = dataBaseUtils.excuteQueryWrite(sql);

            preparedStatement.setString(1, bangDia.getMaMatHang());
            preparedStatement.setString(2, bangDia.getTenMatHang());
            preparedStatement.setString(3, bangDia.getHangSanXuat());
            preparedStatement.setString(4, bangDia.getGhiChu());
            preparedStatement.setDouble(5, bangDia.getDonGia());
            preparedStatement.setBoolean(6, bangDia.isTinhTrang());
            preparedStatement.setString(7, bangDia.getTheLoai());
            preparedStatement.setInt(8, bangDia.getSoLuongTon());

            if (preparedStatement.executeUpdate() > 0) {
                dataBaseUtils.commitQuery();
                return getBangDia(bangDia.getMaMatHang());
            }
        } catch (Exception e) {
            dataBaseUtils.rollbackQuery();
            throw new Exception("Thêm đồ dùng lỗi");
        } finally {
            preparedStatement.close();
        }

        return null;
    }


    /**
     * Xoá đồ dùng trong DB
     *
     * @param maBangDia
     * @return
     * @throws Exception
     */
    public boolean xoaBangDia(String maBangDia) throws Exception {
        String sql = "DELETE FROM BANGDIA WHERE MABD = ?";
        PreparedStatement preparedStatement = null;

        if (getBangDia(maBangDia) == null)
            return false;

        try {
            preparedStatement = dataBaseUtils.excuteQueryWrite(sql);

            preparedStatement.setString(1, maBangDia);

            if (preparedStatement.executeUpdate() > 0) {
                dataBaseUtils.commitQuery();
                return true;
            }
        } catch (Exception e) {
            dataBaseUtils.rollbackQuery();
            throw new Exception("Lỗi xoá đồ dùng");
        } finally {
            preparedStatement.close();
        }

        return false;
    }


    /**
     * Cập nhật thông tin đồ dùng trong DB
     *
     * @param bangDia
     * @return
     * @throws Exception
     */
    public MatHang suaBangDia(MatHang bangDia) throws Exception {
        String sql = "UPDATE BANGDIA SET " +
                "TENBD = ?, HANGSANXUAT = ?, GHICHU = ?, DONGIA = ?, " +
                "TINHTRANG = ?, THELOAI = ?, SOLUONGTON = ? WHERE MABD = ?";
        PreparedStatement preparedStatement = null;

        if (bangDia == null)
            return null;

        try {
            preparedStatement = dataBaseUtils.excuteQueryWrite(sql);

            preparedStatement.setString(1, bangDia.getTenMatHang());
            preparedStatement.setString(2, bangDia.getHangSanXuat());
            preparedStatement.setString(3, bangDia.getGhiChu());
            preparedStatement.setDouble(4, bangDia.getDonGia());
            preparedStatement.setBoolean(5, bangDia.isTinhTrang());
            preparedStatement.setString(6, bangDia.getTheLoai());
            preparedStatement.setInt(7, bangDia.getSoLuongTon());
            preparedStatement.setString(8, bangDia.getMaMatHang());

            if (preparedStatement.executeUpdate() > 0) {
                dataBaseUtils.commitQuery();
                return getBangDia(bangDia.getMaMatHang());
            }
        } catch (Exception e) {
            dataBaseUtils.rollbackQuery();
            throw new Exception("Cập nhật thông tin đồ dùng lỗi");
        } finally {
            preparedStatement.close();
        }

        return null;
    }
}
